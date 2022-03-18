/**
 * 生产环境
 */
;(function () {
  window.SITE_CONFIG = {};

  // api接口请求地址
  // window.SITE_CONFIG['baseUrl'] = 'http://134.175.164.227:10000';
  // window.SITE_CONFIG['baseUrl'] = 'http://117.176.245.2:10000';
  window.SITE_CONFIG['baseUrl'] = 'http://103.149.26.144:8081';
  window.SITE_CONFIG['key'] = 'aaa';

  // cdn地址 = 域名 + 版本号
  window.SITE_CONFIG['domain']  = './'; // 域名
  window.SITE_CONFIG['version'] = '';   // 版本号(年月日时分)
  window.SITE_CONFIG['cdnUrl']  = window.SITE_CONFIG.domain + window.SITE_CONFIG.version;
})();
