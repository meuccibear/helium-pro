<template>
  <div class="mod-config">
<!--    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">-->
<!--      <el-row>-->
<!--        <el-form-item-->
<!--          v-if="isAuth('business:businessdevice:oneLevelName')">-->
<!--          <el-input v-model="dataForm.key" placeholder="模糊搜索客户名" clearable></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item-->
<!--          v-if="isAuth('business:businessdevice:oneLevelName')">-->
<!--          <el-select-->
<!--            v-model="dataForm.oneLevelName"-->
<!--            placeholder="一级客户名称"-->
<!--            clearable-->
<!--            filterable-->
<!--            :value="dataForm.oneLevelName">-->
<!--            <el-option-->
<!--              v-for="item in oneLevelNames"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-select-->
<!--            v-model="dataForm.twoLevelName"-->
<!--            :placeholder="isAuth('business:businessdevice:oneLevelName') ? '二级客户名称' : '客户名称'"-->
<!--            clearable-->
<!--            filterable-->
<!--            :value="dataForm.twoLevelName">-->
<!--            <el-option-->
<!--              v-for="item in twoLevelNames"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item-->
<!--          v-if="isAuth('business:businessdevice:manage')"-->
<!--        >-->
<!--          <el-select-->
<!--            v-model="dataForm.manageName"-->
<!--            placeholder="管理机"-->
<!--            clearable-->
<!--            filterable-->
<!--            :value="dataForm.manageName">-->
<!--            <el-option-->
<!--              v-for="item in manageNames"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-select-->
<!--            v-model="dataForm.groupName"-->
<!--            placeholder="分组"-->
<!--            clearable-->
<!--            filterable-->
<!--            :value="dataForm.groupName">-->
<!--            <el-option-->
<!--              v-for="item in groupNames"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-select-->
<!--            v-model="dataForm.country"-->
<!--            placeholder="国家"-->
<!--            clearable-->
<!--            filterable-->
<!--            :value="dataForm.country">-->
<!--            <el-option-->
<!--              v-for="item in countrys"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-select-->
<!--            v-model="dataForm.city"-->
<!--            placeholder="城市"-->
<!--            clearable-->
<!--            filterable-->
<!--            :value="dataForm.city">-->
<!--            <el-option-->
<!--              v-for="item in citys"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-select-->
<!--            v-model="dataForm.online"-->
<!--            placeholder="设备状态"-->
<!--            clearable-->
<!--            :value="dataForm.online">-->
<!--            <el-option-->
<!--              v-for="item in onlines"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-select-->
<!--            v-model="dataForm.depl"-->
<!--            placeholder="黑名单"-->
<!--            clearable-->
<!--            :value="dataForm.depl">-->
<!--            <el-option-->
<!--              v-for="item in depllists"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-button @click="getDataList()">查询</el-button>-->
<!--        </el-form-item>-->
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
<!--      </el-row>-->
<!--    </el-form>-->
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
        prop="id"
        label="编号"
        sortable
        width="220">
      </el-table-column>
      <el-table-column label="网关设信息信息">
        <el-table-column
          prop="name"
          label="名称"
          sortable
          width="180">
          <template slot-scope="scope">
            <el-link
              v-if="scope.row.address"
              :href="'https://explorer.helium.com/hotspots/' + scope.row.address + '/5g-statistics'"
              target="_blank"
              type="primary"
              :underline="false">{{ scope.row.name }}</el-link>
            <span v-else >{{ scope.row.name }}</span>
            <!--          <a :href="'https://explorer.helium.com/hotspots/' + scope.row.address"-->
            <!--             target="_blank"-->
            <!--             class="buttonText">{{ scope.row.name }}</a>-->
          </template>
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
          width="100">
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
          prop="address"
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
          label="gps状态">
          <template slot-scope="scope">
            <el-tag v-if='scope.row.gpsStat === true' size="small">正常</el-tag>
            <el-tag v-if='scope.row.gpsStat === false'  size="small" type="danger">不正常</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="sasStat"
          label="sas状态">
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
      </el-table-column>
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
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
          'oneLevelName': this.dataForm.oneLevelName,
          'twoLevelName': this.dataForm.twoLevelName,
          'manageName': this.dataForm.manageName,
          'groupName': this.dataForm.groupName,
          'country': this.dataForm.country,
          'city': this.dataForm.city,
          'online': this.dataForm.online,
          'depllist': this.dataForm.depl
        })
      }).then(({data}) => {
        if (data && data.code === 0) {
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
<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>
