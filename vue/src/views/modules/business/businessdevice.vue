<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-row>
        <el-form-item
          v-if="isAuth('business:businessdevice:oneLevelName')">
          <el-input v-model="dataForm.key" placeholder="模糊搜索客户名" clearable></el-input>
        </el-form-item>
        <el-form-item
          v-if="isAuth('business:businessdevice:oneLevelName')">
          <el-select
            v-model="dataForm.oneLevelName"
            placeholder="一级客户名称"
            clearable
            filterable
            :value="dataForm.oneLevelName">
            <el-option
              v-for="item in oneLevelNames"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="dataForm.twoLevelName"
            :placeholder="isAuth('business:businessdevice:oneLevelName') ? '二级客户名称' : '客户名称'"
            clearable
            filterable
            :value="dataForm.twoLevelName">
            <el-option
              v-for="item in twoLevelNames"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          v-if="isAuth('business:businessdevice:manage')"
        >
          <el-select
            v-model="dataForm.manageName"
            placeholder="管理机"
            clearable
            filterable
            :value="dataForm.manageName">
            <el-option
              v-for="item in manageNames"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="dataForm.groupName"
            placeholder="分组"
            clearable
            filterable
            :value="dataForm.groupName">
            <el-option
              v-for="item in groupNames"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="dataForm.country"
            placeholder="国家"
            clearable
            filterable
            :value="dataForm.country">
            <el-option
              v-for="item in countrys"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="dataForm.city"
            placeholder="城市"
            clearable
            filterable
            :value="dataForm.city">
            <el-option
              v-for="item in citys"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="dataForm.online"
            placeholder="设备状态"
            clearable
            :value="dataForm.online">
            <el-option
              v-for="item in onlines"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="dataForm.depl"
            placeholder="黑名单"
            clearable
            :value="dataForm.depl">
            <el-option
              v-for="item in depllists"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button @click="getDataList()">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-upload
            v-if="isAuth('business:businessdevice:importData')"
            class="upload-demo"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :action="updateUrl">
            <el-button size="small" type="primary">导入数据</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item>
          <el-button
            v-if="isAuth('business:businessdevice:downloadDaily')"
            @click="downloadDaily()"
            type="success"
            size="small"
            plain>下载日报</el-button>
        </el-form-item>
      </el-row>
    </el-form>
    <el-table
        ref="table"
        class="treeScrollbar"
        :data="dataList"
        border
        :max-height="isAuth('business:businessdevice:oneLevelName') ? 600 : 670"
        stripe
        :highlight-current-row="true"
        v-loading="dataListLoading"
        @selection-change="selectionChangeHandle"
        style="width: 100%; ">
        <el-table-column
          fixed
          type="selection"
          header-align="center"
          align="center"
          width="50">
        </el-table-column>
        <el-table-column
          prop="id"
          fixed
          v-if="isAuth('business:businessdevice:id')"
          header-align="center"
          align="center"
          label="序号">
        </el-table-column>
        <!--  <el-table-column
                   prop="en"
                   header-align="center"
                   align="center"
                   label="英文简写">
                 </el-table-column>
                <el-table-column
                   prop="address"
                   header-align="center"
                   align="center"
                   label="设备ID">
                 </el-table-column>-->

        <el-table-column
          fixed
          prop="oneLevelName"
          header-align="center"
          align="center"
          width="160"
          :show-overflow-tooltip="true"
          v-if="isAuth('business:businessdevice:oneLevelName')"
          label="一级客户名称">
        </el-table-column>
        <el-table-column
          fixed
          header-align="center"
          align="center"
          width="220"
          :show-overflow-tooltip="true"
          label="设备名称">
          <template slot-scope="scope">
            <el-link
              :href="'https://app.hotspotty.net/hotspots/' + scope.row.address + '/rewards'"
              target="_blank"
              type="primary"
              :underline="false">{{ scope.row.name || scope.row.address }}</el-link>
            <!--          <a :href="'https://explorer.helium.com/hotspots/' + scope.row.address"-->
            <!--             target="_blank"-->
            <!--             class="buttonText">{{ scope.row.name }}</a>-->
          </template>
        </el-table-column>
        <el-table-column
          prop="twoLevelName"
          header-align="center"
          align="center"
          width="160"
          :show-overflow-tooltip="true"
          label="客户名称">
        </el-table-column>
        <el-table-column
          prop="publicIp"
          header-align="center"
          align="center"
          sortable
          width="120"
          :sort-method="sortByIP"
          :show-overflow-tooltip="true"
          label="内网IP">
        </el-table-column>
        <el-table-column
          prop="ip"
          v-if="isAuth('business:businessdevice:ip')"
          header-align="center"
          align="center"
          sortable
          width="120"
          :sort-method="sortByIP"
          :show-overflow-tooltip="true"
          label="真实ip">
        </el-table-column>
        <el-table-column
          prop="total24h"
          header-align="center"
          align="center"
          sortable
          width="140"
          v-if="isAuth('business:businessdevice:mon')"
          label="24小时收益">
        </el-table-column>
        <el-table-column
          prop="scale"
          header-align="center"
          align="center"
          sortable
          width="90"
          v-if="isAuth('business:businessdevice:mon')"
          label="scale">
        </el-table-column>
        <el-table-column
          prop="depllist"
          header-align="center"
          align="center"
          sortable
          width="120"
          :show-overflow-tooltip="true"
          label="黑名单">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.depllist === 0" size="small" >不存在</el-tag>
            <el-tag v-else-if="scope.row.depllist === 1" size="small" type="danger">存在</el-tag>
            <el-tag v-else >未知</el-tag>
          </template>
        </el-table-column>
<!--        <el-table-column-->
<!--          prop="height"-->
<!--          header-align="center"-->
<!--          align="center"-->
<!--          width="120"-->
<!--          :show-overflow-tooltip="true"-->
<!--          label="高度">-->
<!--        </el-table-column>-->
      <el-table-column
          prop="disk"
          header-align="center"
          align="center"
          width="160"
          sortable
          :show-overflow-tooltip="true"
          label="占用磁盘大小(%)">
        </el-table-column>
<!--        <el-table-column-->
<!--          prop="gap"-->
<!--          header-align="center"-->
<!--          align="center"-->
<!--          sortable-->
<!--          width="120"-->
<!--          :show-overflow-tooltip="true"-->
<!--          label="gap">-->
<!--        </el-table-column>-->
        <el-table-column
          prop="online"
          header-align="center"
          align="center"
          label="设备状态"
        >
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.online === 'online' ? 'success' : 'primary'"
              disable-transitions>{{scope.row.online}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="manageName"
          header-align="center"
          align="center"
          width="240"
          :show-overflow-tooltip="true"
          v-if="isAuth('business:businessdevice:manage')"
          label="管理机">
        </el-table-column>
        <el-table-column
          prop="country"
          header-align="center"
          align="center"
          width="120"
          :show-overflow-tooltip="true"
          label="国家">
        </el-table-column>
        <el-table-column
          prop="city"
          header-align="center"
          align="center"
          width="160"
          :show-overflow-tooltip="true"
          label="城市">
        </el-table-column>
        <el-table-column
          prop="groupName"
          header-align="center"
          align="center"
          width="100"
          :show-overflow-tooltip="true"
          label="分组">
        </el-table-column>
      <el-table-column
        prop="muxtm"
        header-align="center"
        align="center"
        sortable
        width="240"
        :show-overflow-tooltip="true"
        label="muxtm">
      </el-table-column>
      <el-table-column
        prop="minerver"
        header-align="center"
        align="center"
        sortable
        width="120"
        :show-overflow-tooltip="true"
        label="miner版本">
      </el-table-column>
      <el-table-column
        prop="minerstat"
        header-align="center"
        align="center"
        sortable
        width="120"
        :show-overflow-tooltip="true"
        label="miner状态">
      </el-table-column>
      <el-table-column
        prop="ver"
        header-align="center"
        align="center"
        sortable
        width="140"
        :show-overflow-tooltip="true"
        label="hntMan版本">
      </el-table-column>
      <el-table-column
        prop="loratm"
        header-align="center"
        align="center"
        sortable
        width="240"
        :show-overflow-tooltip="true"
        label="最后收到lora时间">
      </el-table-column>
      <el-table-column
        prop="witnesstm"
        v-if="isAuth('business:businessdevice:dev')"
        width="240"
        sortable
        :show-overflow-tooltip="true"
        label="最后的见证【见证别人】">
      </el-table-column>
      <el-table-column
        prop="beacontm"
        v-if="isAuth('business:businessdevice:dev')"
        width="240"
        sortable
        :show-overflow-tooltip="true"
        label="最后beacontm时间">
      </el-table-column>
<!--      <el-table-column-->
<!--        prop="lastwitness"-->
<!--        v-if="isAuth('business:businessdevice:dev')"-->
<!--        header-align="center"-->
<!--        align="center"-->
<!--        width="240"-->
<!--        :show-overflow-tooltip="true"-->
<!--        label="挑战者地址">-->
<!--      </el-table-column>-->
        <el-table-column
          prop="pingpai"
          header-align="center"
          align="center"
          width="120"
          :show-overflow-tooltip="true"
          label="品牌">
        </el-table-column>
        <el-table-column
          prop="mac"
          header-align="center"
          align="center"
          width="180"
          :show-overflow-tooltip="true"
          label="MAC地址">
        </el-table-column>
<!--        <el-table-column-->
<!--          prop="ownerNo"-->
<!--          header-align="center"-->
<!--          align="center"-->
<!--          width="120"-->
<!--          :show-overflow-tooltip="true"-->
<!--          label="钱包序号">-->
<!--        </el-table-column>-->
        <el-table-column
          prop="locationAddress"
          header-align="center"
          align="center"
          width="120"
          :show-overflow-tooltip="true"
          label="设备存放地点">
        </el-table-column>
        <el-table-column
          prop="date"
          sortable
          width="240"
          label="提供运维时间">
        </el-table-column>
        <el-table-column
          prop="re"
          header-align="center"
          align="center"
          width="240"
          :show-overflow-tooltip="true"
          label="备注">
        </el-table-column>
<!--        <el-table-column-->
<!--          prop="cname"-->
<!--          header-align="center"-->
<!--          align="center"-->
<!--          sortable-->
<!--          width="120"-->
<!--          :show-overflow-tooltip="true"-->
<!--          label="分组名称">-->
<!--        </el-table-column>-->
        <el-table-column
          prop="devtype"
          header-align="center"
          align="center"
          width="120"
          :show-overflow-tooltip="true"
          label="设备类型">
        </el-table-column>
<!--        <el-table-column-->
<!--          prop="gip"-->
<!--          align="center"-->
<!--          sortable-->
<!--          width="240"-->
<!--          :show-overflow-tooltip="true"-->
<!--          label="信号管理服务器内网ip">-->
<!--        </el-table-column>-->
        <el-table-column
          prop="remark"
          header-align="center"
          align="center"
          width="120"
          :show-overflow-tooltip="true"
          label="检测结果">
        </el-table-column>
        <el-table-column
          prop="hearttm"
          header-align="center"
          align="center"
          sortable
          width="160"
          :show-overflow-tooltip="true"
          label="最后心跳时间">
        </el-table-column>
<!--        <el-table-column-->
<!--          prop="updateTime"-->
<!--          header-align="center"-->
<!--          align="center"-->
<!--          fixed="right"-->
<!--          width="160"-->
<!--          label="更新时间">-->
<!--        </el-table-column>-->
        <el-table-column
          prop="importDataTime"
          header-align="center"
          align="center"
          width="160"
          label="数据导入时间">
        </el-table-column>
        <!--      <el-table-column
                fixed="right"
                header-align="center"
                align="center"
                width="150"
                label="操作">
                <template slot-scope="scope">
                  <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
                  <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
                </template>
              </el-table-column>-->
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="pageSizes"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
import AddOrUpdate from './businessdevice-add-or-update'
export default {
  data () {
    var sizes = [200, 500, 1000, 5000]
    return {
      updateUrl: '',
      dataForm: {
        key: '',
        oneLevelName: '',
        twoLevelName: '',
        manageName: '',
        groupName: '',
        country: '',
        city: '',
        online: '',
        depl: ''
      },
      pageSizes: sizes,
      dataList: [],
      pageIndex: 1,
      pageSize: sizes[0],
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      addOrUpdateVisible: false,
      depllists: [],
      groupNames: [],
      // locations:[] data.location,
      countrys: [],
      citys: [],
      manageNames: [],
      oneLevelNames: [],
      twoLevelNames: [],
      onlines: []
    }
  },
  components: {
    AddOrUpdate
  },
  activated () {
    this.getDataList()
  },
  methods: {
    // 获取数据列表
    getDataList () {
      this.dataListLoading = true
      this.updateUrl = this.$http.adornUrl(`/business/businessdevice/importData?token=${this.$cookie.get('token')}`)
      this.$http({
        url: this.$http.adornUrl('/business/businessdevice/list'),
        method: 'get',
        params: this.$http.adornParams({
          'page': this.pageIndex,
          'limit': this.pageSize,
          'key': this.dataForm.key,
          'oneLevelName': this.dataForm.oneLevelName,
          'twoLevelName': this.dataForm.twoLevelName,
          'manageName': this.dataForm.manageName,
          'groupName': this.dataForm.groupName,
          'country': this.dataForm.country,
          'city': this.dataForm.city,
          'online': this.dataForm.online,
          'depllist': this.dataForm.depl
        })
        // oneLevelName: '',
        // twoLevelName: '',
        // manageName: '',
        // groupName: '',
        // location: '',
        // online: '',
        // depl: ''
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.depllists = data.depllists
          this.groupNames = data.groupNames
          this.countrys = data.countrys
          this.citys = data.citys
          this.manageNames = data.manageNames
          this.oneLevelNames = data.oneLevelNames
          this.twoLevelNames = data.twoLevelNames
          this.onlines = data.onlines

          this.dataList = data.page.list
          this.totalPage = data.page.totalCount
        } else {
          this.dataList = []
          this.totalPage = 0
        }
        this.dataListLoading = false
        this.$nextTick(() => {
          this.$refs.table.doLayout()
        })
      })
    },
    // 每页数
    sizeChangeHandle (val) {
      this.pageSize = val
      this.pageIndex = 1
      this.getDataList()
    },
    // 当前页
    currentChangeHandle (val) {
      this.pageIndex = val
      this.getDataList()
    },
    // 多选
    selectionChangeHandle (val) {
      this.dataListSelections = val
    },
    // 新增 / 修改
    addOrUpdateHandle (id) {
      this.addOrUpdateVisible = true
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id)
      })
    },
    // 删除
    deleteHandle (id) {
      var ids = id ? [id] : this.dataListSelections.map(item => {
        return item.id
      })
      this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http({
          url: this.$http.adornUrl('/business/businessdevice/delete'),
          method: 'post',
          data: this.$http.adornData(ids, false)
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.$message({
              message: '操作成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.getDataList()
              }
            })
          } else {
            this.$message.error(data.msg)
          }
        })
      })
    },
    handleAvatarSuccess () {
      this.$notify({
        title: '提示',
        message: '导入数据成功',
        duration: 0
      })
      this.getDataList()
    },
    downloadDaily () {
      this.$http({
        url: this.$http.adornUrl('/business/businessdevice/downloadDaily'),
        method: 'get'
        // 首先设置responseType字段格式为 blob
        // responseType: 'blob'
      }).then((res) => {
        // console.log(res)
        // console.log(JSON.stringify(res))
        // 为blob设置文件类型，这里以.xlsx为例
        // let blob = new Blob([res],
        //   {
        //     type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;'
        //   }
        // )
        if (res.data.existence) {
          let blob = new Blob([res.data.context])
          // 创建一个临时的url指向blob对象
          let url = window.URL.createObjectURL(blob)
          let a = document.createElement('a')
          a.href = url
          a.download = '日报'
          a.click()
          // 释放这个临时的对象url
          window.URL.revokeObjectURL(url)
        } else {
          this.$notify({
            title: '提示',
            message: res.data.msg,
            duration: 0
          })
        }
      })
      // window.open(this.$http.adornUrl(`/business/businessdevice/businessdevice?token=${this.$cookie.get('token')}`), "_self")
    },
    download (item) {
      // 下载文件
      // 创建a标签
      let a = document.createElement('a')
      // 完整图片地址url连接  例如https://xxxx.cn/xxx/xxx/xxxx.xlsx   或者https://xxxx.cn/xxx/xxx/xxxx.png
      let url = item.fileurls
      fetch(url).then(res => res.blob()).then(blob => {
        // blob地址
        a.href = URL.createObjectURL(blob)
        // 下载文件的名字
        a.download = item.name
        a.click()
      })
    },
    sortByIP (obj1, obj2) {
      if (
        obj1.publicIp !== '' &&
        obj1.publicIp !== null &&
        obj1.publicIp !== undefined &&
        obj2.publicIp !== '' &&
        obj2.publicIp !== null &&
        obj2.publicIp !== undefined
      ) {
        let array1 = obj1.publicIp.split('.')
        let array2 = obj2.publicIp.split('.')
        if (array1[0] === array2[0]) {
          if (array1[1] === array2[1]) {
            if (array1[2] === array2[2]) {
              return array1[3] - array2[3]
            } else {
              return array1[2] - array2[2]
            }
          } else {
            return array1[1] - array2[1]
          }
        } else {
          return array1[0] - array2[0]
        }
      }
    }
  }
}
</script>
