<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
<!--      <el-form-item>-->
<!--        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>-->
<!--      </el-form-item>-->

      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('business:businessgroup:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('business:businessgroup:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="groupId"
        header-align="center"
        align="center"
        label="编号">
      </el-table-column>
      <el-table-column
        prop="mmId"
        header-align="center"
        align="center"
        label="管理机">
      </el-table-column>
      <el-table-column
        prop="groupName"
        header-align="center"
        align="center"
        label="名称">
      </el-table-column>
      <el-table-column
        prop="remarks"
        header-align="center"
        align="center"
        label="备注">
      </el-table-column>
<!--      <el-table-column
        prop="createUserId"
        header-align="center"
        align="center"
        label="创建者ID">
      </el-table-column>
      <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column>-->
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        label="状态">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.status === 0" size="small" type="danger">禁用</el-tag>
          <el-tag v-else size="small">正常</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="240"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addHotspottyHandle(scope.row.groupId)">指定设备</el-button>
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.groupId)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.groupId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
    <add-hotspotty v-if="addHotspottyVisible" ref="addHotspotty" @refreshDataList="getDataList"></add-hotspotty>
  </div>
</template>

<script>
  import AddOrUpdate from './businessgroup-add-or-update'
  import AddHotspotty from './businessgroup-add-hotspotty'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false,
        addHotspottyVisible: false,
        userId: null,
        options: [],
        // options: [
        //   {
        //     value: 'zhinan',
        //   label: '指南',
        //   children: [{
        //     value: 'shejiyuanze',
        //     label: '设计原则',
        //     children: [{
        //       value: 'yizhi',
        //       label: '一致'
        //     }, {
        //       value: 'fankui',
        //       label: '反馈'
        //     }, {
        //       value: 'xiaolv',
        //       label: '效率'
        //     }, {
        //       value: 'kekong',
        //       label: '可控'
        //     }]
        //   }, {
        //     value: 'daohang',
        //     label: '导航',
        //     children: [{
        //       value: 'cexiangdaohang',
        //       label: '侧向导航'
        //     }, {
        //       value: 'dingbudaohang',
        //       label: '顶部导航'
        //     }]
        //   }]
        // }, {
        //   value: 'zujian',
        //   label: '组件',
        //   children: [{
        //     value: 'basic',
        //     label: 'Basic',
        //     children: [{
        //       value: 'layout',
        //       label: 'Layout 布局'
        //     }, {
        //       value: 'color',
        //       label: 'Color 色彩'
        //     }, {
        //       value: 'typography',
        //       label: 'Typography 字体'
        //     }, {
        //       value: 'icon',
        //       label: 'Icon 图标'
        //     }, {
        //       value: 'button',
        //       label: 'Button 按钮'
        //     }]
        //   }, {
        //     value: 'form',
        //     label: 'Form',
        //     children: [{
        //       value: 'radio',
        //       label: 'Radio 单选框'
        //     }, {
        //       value: 'checkbox',
        //       label: 'Checkbox 多选框'
        //     }, {
        //       value: 'input',
        //       label: 'Input 输入框'
        //     }, {
        //       value: 'input-number',
        //       label: 'InputNumber 计数器'
        //     }, {
        //       value: 'select',
        //       label: 'Select 选择器'
        //     }, {
        //       value: 'cascader',
        //       label: 'Cascader 级联选择器'
        //     }, {
        //       value: 'switch',
        //       label: 'Switch 开关'
        //     }, {
        //       value: 'slider',
        //       label: 'Slider 滑块'
        //     }, {
        //       value: 'time-picker',
        //       label: 'TimePicker 时间选择器'
        //     }, {
        //       value: 'date-picker',
        //       label: 'DatePicker 日期选择器'
        //     }, {
        //       value: 'datetime-picker',
        //       label: 'DateTimePicker 日期时间选择器'
        //     }, {
        //       value: 'upload',
        //       label: 'Upload 上传'
        //     }, {
        //       value: 'rate',
        //       label: 'Rate 评分'
        //     }, {
        //       value: 'form',
        //       label: 'Form 表单'
        //     }]
        //   }, {
        //     value: 'data',
        //     label: 'Data',
        //     children: [{
        //       value: 'table',
        //       label: 'Table 表格'
        //     }, {
        //       value: 'tag',
        //       label: 'Tag 标签'
        //     }, {
        //       value: 'progress',
        //       label: 'Progress 进度条'
        //     }, {
        //       value: 'tree',
        //       label: 'Tree 树形控件'
        //     }, {
        //       value: 'pagination',
        //       label: 'Pagination 分页'
        //     }, {
        //       value: 'badge',
        //       label: 'Badge 标记'
        //     }]
        //   }, {
        //     value: 'notice',
        //     label: 'Notice',
        //     children: [{
        //       value: 'alert',
        //       label: 'Alert 警告'
        //     }, {
        //       value: 'loading',
        //       label: 'Loading 加载'
        //     }, {
        //       value: 'message',
        //       label: 'Message 消息提示'
        //     }, {
        //       value: 'message-box',
        //       label: 'MessageBox 弹框'
        //     }, {
        //       value: 'notification',
        //       label: 'Notification 通知'
        //     }]
        //   }, {
        //     value: 'navigation',
        //     label: 'Navigation',
        //     children: [{
        //       value: 'menu',
        //       label: 'NavMenu 导航菜单'
        //     }, {
        //       value: 'tabs',
        //       label: 'Tabs 标签页'
        //     }, {
        //       value: 'breadcrumb',
        //       label: 'Breadcrumb 面包屑'
        //     }, {
        //       value: 'dropdown',
        //       label: 'Dropdown 下拉菜单'
        //     }, {
        //       value: 'steps',
        //       label: 'Steps 步骤条'
        //     }]
        //   }, {
        //     value: 'others',
        //     label: 'Others',
        //     children: [{
        //       value: 'dialog',
        //       label: 'Dialog 对话框'
        //     }, {
        //       value: 'tooltip',
        //       label: 'Tooltip 文字提示'
        //     }, {
        //       value: 'popover',
        //       label: 'Popover 弹出框'
        //     }, {
        //       value: 'card',
        //       label: 'Card 卡片'
        //     }, {
        //       value: 'carousel',
        //       label: 'Carousel 走马灯'
        //     }, {
        //       value: 'collapse',
        //       label: 'Collapse 折叠面板'
        //     }]
        //   }]
        // }, {
        //   value: 'ziyuan',
        //   label: '资源',
        //   children: [{
        //     value: 'axure',
        //     label: 'Axure Components'
        //   }, {
        //     value: 'sketch',
        //     label: 'Sketch Templates'
        //   }, {
        //     value: 'jiaohu',
        //     label: '组件交互文档'
        //   }]
        // }],
        value1: []
      }
    },
    components: {
      AddOrUpdate,
      AddHotspotty
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/business/businessgroup/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
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
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      addHotspottyHandle (id) {
        this.addHotspottyVisible = true
        this.$nextTick(() => {
          this.$refs.addHotspotty.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.groupId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/business/businessgroup/delete'),
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
      // 授权分组
      authorizedGropUserHandle (id) {
        var ids = this.dataListSelections.map(item => {
          return item.groupId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${'批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/business/businessgroup/delete'),
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
      }
    }
  }
</script>
