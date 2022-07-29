<template>
  <el-dialog
    :title="'添加设备'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="设备：" prop="hotsPottyIds">
      <el-cascader
        :show-all-levels="false"
        v-model="dataForm.hotsPottyIds"
        placeholder="试试搜索：设备名称"
        :options="options"
        :props="{ multiple: true }"
        clearable
        style="width: 100%;"
        filterable></el-cascader>
<!--      <el-cascader-panel :options="options"></el-cascader-panel>-->
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          groupId: 0,
          hotsPottyIds: []
        },
        options: [],
        dataRule: {
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.groupId = id || 0
        this.visible = true
        this.$http({
          url: this.$http.adornUrl('/business/businesshotspotty/select'),
          method: 'get',
          params: this.$http.adornParams()
        }).then(({data}) => {
          this.options = data.hotsPottyList
        }).then(() => {
          this.visible = true
          this.$nextTick(() => {
            this.$refs['dataForm'].resetFields()
          })
        }).then(() => {
          if (this.dataForm.groupId) {
            this.$http({
              url: this.$http.adornUrl(`/business/businessgroup/getHotspottyToGroup/${this.dataForm.groupId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.hotsPottyIds = data.groupHotspottySelect
              }
            })
          }
        })
        //   .then(() => {
        //   this.$nextTick(() => {
        //     this.$refs['dataForm'].resetFields()
        //     if (this.dataForm.groupId) {
        //       this.$http({
        //         url: this.$http.adornUrl(`/business/businessgroup/info/${this.dataForm.groupId}`),
        //         method: 'get',
        //         params: this.$http.adornParams()
        //       }).then(({data}) => {
        //         if (data && data.code === 0) {
        //           this.dataForm.mmId = data.businessGroup.mmId
        //           this.dataForm.groupName = data.businessGroup.groupName
        //           this.dataForm.remarks = data.businessGroup.remarks
        //           this.dataForm.createUserId = data.businessGroup.createUserId
        //           this.dataForm.createTime = data.businessGroup.createTime
        //           this.dataForm.status = data.businessGroup.status
        //         }
        //       })
        //     }
        //   })
        // })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/business/businessgroup/saveHotspottyToGroup`),
              method: 'post',
              data: this.$http.adornData({
                'groupId': this.dataForm.groupId,
                'hotsPottyIds': this.dataForm.hotsPottyIds
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
