<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-row>
<!--        <el-form-item-->
<!--          v-if="isAuth('business:businessdevice:oneLevelName')">-->
<!--          <el-input v-model="dataForm.key" placeholder="模糊搜索客户名" clearable></el-input>-->
<!--        </el-form-item>-->
        <el-form-item>
          <el-select
            v-model="dataForm.internel"
            placeholder="Gateway 网络"
            clearable
            :value="dataForm.internel">
            <el-option
              v-for="item in internel"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="dataForm.gpsStat"
            placeholder="GPS"
            clearable
            :value="dataForm.gpsStat">
            <el-option
              v-for="item in gpsStat"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="dataForm.sasStat"
            placeholder="Sas"
            clearable
            :value="dataForm.sasStat">
            <el-option
              v-for="item in sasStat"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="dataForm.status"
            placeholder="状态"
            clearable
            :value="dataForm.status">
            <el-option
              v-for="item in status"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button @click="getDataList()">查询</el-button>
        </el-form-item>
<!--        <el-form-item>-->
<!--          <el-upload-->
<!--            v-if="isAuth('business:businessdevice:importData')"-->
<!--            class="upload-demo"-->
<!--            :show-file-list="false"-->
<!--            :on-success="handleAvatarSuccess"-->
<!--            :action="updateUrl">-->
<!--            <el-button size="small" type="primary">导入数据</el-button>-->
<!--          </el-upload>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-button-->
<!--            v-if="isAuth('business:businessdevice:downloadDaily')"-->
<!--            @click="downloadDaily()"-->
<!--            type="success"-->
<!--            size="small"-->
<!--            plain>下载日报</el-button>-->
<!--        </el-form-item>-->
      </el-row>
    </el-form>
    <el-table
      :data="dataList"
      style="width: 100%;margin-bottom: 20px;"
      row-key="id"
      border
      default-expand-all
      :row-class-name="tableRowClassName"
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
      <el-table-column
        fixed
        label="编号"
        sortable
        width="220">
        <template slot-scope="scope">
          <el-link
            v-if="scope.row.address"
            :href="'https://app.hotspotty.net/hotspots/' + scope.row.address + '/rewards'"
            target="_blank"
            type="primary"
            :underline="false">{{ scope.row.id }}</el-link>
          <span v-else >{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="网关设信息信息">
<!--        <el-table-column-->
<!--          prop="name"-->
<!--          label="名称"-->
<!--          sortable-->
<!--          width="180">-->
<!--          <template slot-scope="scope">-->
<!--            <el-link-->
<!--              v-if="scope.row.address"-->
<!--              :href="'https://explorer.helium.com/hotspots/' + scope.row.address + '/5g-statistics'"-->
<!--              target="_blank"-->
<!--              type="primary"-->
<!--              :underline="false">{{ scope.row.name }}</el-link>-->
<!--            <span v-else >{{ scope.row.name }}</span>-->
<!--            &lt;!&ndash;          <a :href="'https://explorer.helium.com/hotspots/' + scope.row.address"&ndash;&gt;-->
<!--            &lt;!&ndash;             target="_blank"&ndash;&gt;-->
<!--            &lt;!&ndash;             class="buttonText">{{ scope.row.name }}</a>&ndash;&gt;-->
<!--          </template>-->
<!--        </el-table-column>-->
        <el-table-column
          prop="name"
          label="名称"
          sortable
          width="180">
        </el-table-column>
        <el-table-column
          prop="alis"
          label="别名"
          sortable
          width="80">
        </el-table-column>
        <el-table-column
          prop="privateIp"
          label="IP"
          sortable
          :sort-method="sortByIP"
          width="100">
          <template slot-scope="scope">
            <el-link
              :href="'http://' + scope.row.privateIp"
              target="_blank"
              type="primary"
              :underline="false">{{ scope.row.privateIp }}</el-link>
          </template>
        </el-table-column>
        <el-table-column
          prop="upload"
          label="上传"
          sortable
          width="80">
        </el-table-column>
        <el-table-column
          prop="download"
          label="下载"
          sortable
          width="80">
        </el-table-column>
        <el-table-column
          prop="minerVersion"
          label="Miner版本"
          sortable
          width="120">
        </el-table-column>
        <el-table-column
          prop="agwVersion"
          label="Agw版本"
          sortable
          width="110">
        </el-table-column>
        <el-table-column
          prop="todayEarnings"
          label="今日收益"
          sortable
          width="130">
        </el-table-column>
        <el-table-column
          prop="yesterdayEarnings"
          label="昨日收益"
          sortable
          width="130">
        </el-table-column>
        <el-table-column
          width="66"
          label="网络">
          <template slot-scope="scope">
            <el-tag v-if='scope.row.internel === true' size="small">正常</el-tag>
            <el-tag v-if='scope.row.internel === false'  size="small" type="danger">不正常</el-tag>
          </template>
        </el-table-column>
      </el-table-column>
      <el-table-column label="基站设备信息">
        <el-table-column
          prop="gpsStat"
          label="GPS状态">
          <template slot-scope="scope">
            <el-tag v-if='scope.row.gpsStat === true' size="small">正常</el-tag>
            <el-tag v-if='scope.row.gpsStat === false'  size="small" type="danger">不正常</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="sasStat"
          label="SAS状态">
          <template slot-scope="scope">
            <el-tag v-if='scope.row.sasStat === true' size="small">正常</el-tag>
            <el-tag v-if='scope.row.sasStat === false'  size="small" type="danger">不正常</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="onair"
          label="onair">
          <template slot-scope="scope">
            <el-tag v-if='scope.row.onair === true' size="small">正常</el-tag>
            <el-tag v-if='scope.row.onair === false'  size="small" type="danger">不正常</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="cellVersion"
          label="Cell版本"
          sortable
          :show-overflow-tooltip="true"
          width="110">
        </el-table-column>
      </el-table-column>
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        sortable
        width="80"
        :sort-method="sortByStatus"
        label="状态">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.status === 0" size="small" type="danger">离线</el-tag>
          <el-tag v-else size="small">正常</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id, scope.row.typeId)">历史统计</el-button>
<!--          <el-button type="text" size="small" @click="deleteHandle(scope.row.walletId)">删除</el-button>-->
        </template>
      </el-table-column>
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
import AddOrUpdate from './g5_device-statistics'
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
        depl: '',
        sasStat: null,
        gpsStat: null,
        internel: null,
        status: null
      },
      pageSizes: sizes,
      dataList: [],
      pageIndex: 1,
      pageSize: sizes[0],
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      addOrUpdateVisible: false,
      sasStat: [],
      gpsStat: [],
      internel: [],
      status: [],
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
    tableRowClassName ({row, rowIndex}) {
      if (row.typeId === 1) {
        return 'warning-row'
      }
      return ''
    },
    // 获取数据列表
    getDataList () {
      this.dataListLoading = true
      this.updateUrl = this.$http.adornUrl(`/business/businessdevice/importData?token=${this.$cookie.get('token')}`)
      this.$http({
        url: this.$http.adornUrl('/business/businessG5device/list'),
        method: 'get',
        params: this.$http.adornParams({
          'page': this.pageIndex,
          'limit': this.pageSize,
          'key': this.dataForm.key,
          'sasStat': this.dataForm.sasStat,
          'gpsStat': this.dataForm.gpsStat,
          'internel': this.dataForm.internel,
          'status': this.dataForm.status
        })
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.sasStat = data.sasStat
          this.gpsStat = data.gpsStat
          this.internel = data.internel
          this.status = data.status
          this.dataList = data.page.list
          this.totalPage = data.page.totalCount
        } else {
          this.dataList = []
          this.totalPage = 0
        }
        this.dataListLoading = false
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
    addOrUpdateHandle (id, typeId) {
      this.addOrUpdateVisible = true
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id, typeId)
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
    filterTag (value, row) {
      console.log('id:', row.id)
      return row.status === value
    },
    sortByStatus (obj1, obj2) {
      if (!obj1.statusNum && !obj2.statusNum) {
        obj1.statusNum = 0
        obj2.statusNum = 0
        obj1.children.forEach(function (data, index) {
          if (data.status === 0) {
            obj1.statusNum = obj1.statusNum + 1
          }
        })
        obj2.children.forEach(function (data, index) {
          if (data.status === 0) {
            obj2.statusNum = obj2.statusNum + 1
          }
        })
        console.log(obj1.id, ' is ', obj1.statusNum, '>', obj2.id, ' is ', obj2.statusNum)
        return obj1.statusNum - obj2.statusNum
      } else {
        return obj1.statusNum - obj2.statusNum
      }
    },
    sortByIP (obj1, obj2) {
      if (
        obj1.privateIp !== '' &&
        obj1.privateIp !== null &&
        obj1.privateIp !== undefined &&
        obj2.privateIp !== '' &&
        obj2.privateIp !== null &&
        obj2.privateIp !== undefined
      ) {
        let array1 = obj1.privateIp.split('.')
        let array2 = obj2.privateIp.split('.')
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
<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>
