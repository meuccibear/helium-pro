/**
 * @name docker镜像打包上传脚本
 * @author weilan
 * @time 2021.02.22
 */
const fs = require('fs');
const path = require('path');
const util = require('util');
const { log } = require('../utils/log');
const exec = util.promisify(require('child_process').exec);
const sub_app_ath = path.resolve();
let sub_apps = fs.readdirSync(sub_app_ath).filter(i => /^subapp|master/.test(i));
const inquirer = require('inquirer'); // 用于命令行交互

/**
 * @name 命令行交互配置项
 */
const question = [
  {
    type: 'confirm',
    name: 'dist',
    message: '是否需要打包前端静态资源？',
  },
  {
    type: 'confirm',
    name: 'env',
    message: '请选择是否需要打包成不联网的内网部署',
    when: function (answers) { // 当answer为true的时候才会提问当前问题
      return answers.dist
    }
  },
  {
    type: 'checkbox',
    name: 'apps',
    message: '请选择要发布的模块',
    choices: sub_apps,
    validate: function (val) {
      if (val.length) { // 校验
        return true;
      }
      return "选择不能为空";
    }
  },
]

/**
 * @name 根据命令交互配置结果做逻辑处理
 */
inquirer.prompt(question).then(async (answer) => {
  let subApps = answer.apps;
  let buildScript = answer.env ? 'yarn build --Intranet' : 'yarn build';
  let needDist = answer.dist;
  let now = +new Date();
  // 登录阿里云
  const { error: loginError } = await exec('docker login --username=哈哈哈 --password=嘿嘿 registry.cn-zhangjiakou.aliyuncs.com');
  if (loginError) {
    log.red(loginError, '登录镜像中心失败')
    return;
  }
  console.log(`开始依次处理 ${JSON.stringify(subApps)} ......`);
  subApps.reduce((chain, item) => {
    return chain.then(() => publishIamge(item, now, needDist, buildScript))
  }, Promise.resolve())
});

/**
 * @name 打包镜像并推送阿里云
 * @param {String} moduleName 模块名
 * @param {String} now 当前版本时间戳
 * @param {Boolean} needDist 是否需要打包前端静态资源
 * @param {String} buildScript 前端静态资源打包命令
 */
async function publishIamge(moduleName, now, needDist, buildScript) {
  // 打包前端静态资源
  if (needDist) {
    console.log('开始打包前端静态资源' + moduleName);
    const { error } = await exec(buildScript, { cwd: path.resolve(moduleName) });
    if (error) {
      log.red(moduleName, '前端代码打包错误：', error)
      return;
    }
    log.green(moduleName + '前端代码打包成功')
  }
  // 打包镜像
  console.log(`开始打包镜像 ${moduleName} ......`);
  const { stdout: buildStdout, error: buildError } = await exec('docker-compose build ' + moduleName);
  if (buildError) {
    log.red(buildError, '镜像打包错误')
    return;
  }
  log.cyan(buildStdout)
  log.green('镜像打包完成，开始制作镜像标签')
  // 更新镜像标签
  const imageName = 'ibp2fe_' + moduleName;
  const { error: tagError } = await exec(`docker tag ${imageName} registry.cn-zhangjiakou.aliyuncs.com/futureweb/${imageName}:${now}`);
  if (tagError) {
    log.red(tagError, '镜像标签异常')
    return;
  }
  log.green('镜像版本标签更新完毕，开始更新last标签')
  // 更新镜像标签last版本
  const { error: tagLastError } = await exec(`docker tag ${imageName} registry.cn-zhangjiakou.aliyuncs.com/futureweb/${imageName}`);
  if (tagLastError) {
    log.red(tagError, '镜像last标签异常')
    return;
  }
  log.green('镜像last标签更新完毕，开始上传')
  const { stdout: pushStdout, error: pushError } = await exec('docker push registry.cn-zhangjiakou.aliyuncs.com/futureweb/' + imageName);
  if (pushError) {
    log.red(pushError, '镜像上传失败')
    return;
  }
  log.cyan(pushStdout)
  log.green('镜像上传成功')
}

process.on('unhandledRejection', (reason, p) => {
  console.log('Unhandled Rejection at: Promise', p, 'reason:', reason);
  // application specific logging, throwing an error, or other logic here
});

