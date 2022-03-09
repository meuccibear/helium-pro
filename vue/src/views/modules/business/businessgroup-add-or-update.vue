<template>
  <el-dialog
    :title="!dataForm.groupId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="管理机" prop="mmId">
      <el-input v-model="dataForm.mmId" placeholder="管理机"></el-input>
    </el-form-item>
    <el-form-item label="名称" prop="groupName">
      <el-input v-model="dataForm.groupName" placeholder="名称"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="备注"></el-input>
    </el-form-item>
<!--    <el-form-item label="创建者ID" prop="createUserId">
      <el-input v-model="dataForm.createUserId" placeholder="创建者ID"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>-->
      <el-form-item label="状态" size="mini" prop="status">
        <el-radio-group v-model="dataForm.status">
          <el-radio :label="0">禁用</el-radio>
          <el-radio :label="1" >正常</el-radio>
        </el-radio-group>
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
          mmId: '',
          groupName: '',
          remarks: '',
          createUserId: '',
          createTime: '',
          status: ''
        },
        dataRule: {
          // mmId: [
          //   { required: true, message: '管理机不能为空', trigger: 'blur' }
          // ],
          groupName: [
            { required: true, message: '名称不能为空', trigger: 'blur' }
          ],
          // remarks: [
          //   { required: true, message: '备注不能为空', trigger: 'blur' }
          // ],
          // createUserId: [
          //   { required: true, message: '创建者ID不能为空', trigger: 'blur' }
          // ],
          // createTime: [
          //   { required: true, message: '创建时间不能为空', trigger: 'blur' }
          // ],
          status: [
            { required: true, message: '状态  0：禁用   1：正常不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.groupId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.groupId) {
            this.$http({
              url: this.$http.adornUrl(`/business/businessgroup/info/${this.dataForm.groupId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.mmId = data.businessGroup.mmId
                this.dataForm.groupName = data.businessGroup.groupName
                this.dataForm.remarks = data.businessGroup.remarks
                this.dataForm.createUserId = data.businessGroup.createUserId
                this.dataForm.createTime = data.businessGroup.createTime
                this.dataForm.status = data.businessGroup.status
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/business/businessgroup/${!this.dataForm.groupId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'groupId': this.dataForm.groupId || undefined,
                'mmId': this.dataForm.mmId,
                'groupName': this.dataForm.groupName,
                'remarks': this.dataForm.remarks,
                'createUserId': this.dataForm.createUserId,
                'createTime': this.dataForm.createTime,
                'status': this.dataForm.status
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
