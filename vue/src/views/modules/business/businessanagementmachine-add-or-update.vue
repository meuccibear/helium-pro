<template>
  <el-dialog
    :title="!dataForm.mmId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="名称" prop="mmName">
      <el-input v-model="dataForm.mmName" placeholder="名称"></el-input>
    </el-form-item>
    <el-form-item label="网段" prop="networkSegment">
      <el-input v-model="dataForm.networkSegment" placeholder="网段"></el-input>
    </el-form-item>
    <el-form-item label="内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="内容" type="textarea"></el-input>
    </el-form-item>
<!--    <el-form-item label="创建者ID" prop="createUserId">
      <el-input v-model="dataForm.createUserId" placeholder="创建者ID"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>-->
    <el-form-item label="备注" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="备注"></el-input>
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
          mmId: 0,
          mmName: '',
          networkSegment: '',
          content: '',
          createUserId: '',
          createTime: '',
          remarks: ''
        },
        dataRule: {
          mmName: [
            { required: true, message: '名称不能为空', trigger: 'blur' }
          ],
          networkSegment: [
            { required: true, message: '网段不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '内容不能为空', trigger: 'blur' }
          ]
          // ,
          // createUserId: [
          //   { required: true, message: '创建者ID不能为空', trigger: 'blur' }
          // ],
          // createTime: [
          //   { required: true, message: '创建时间不能为空', trigger: 'blur' }
          // ],
          // remarks: [
          //   { required: true, message: '备注不能为空', trigger: 'blur' }
          // ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.mmId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.mmId) {
            this.$http({
              url: this.$http.adornUrl(`/business/businessanagementmachine/info/${this.dataForm.mmId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.mmName = data.businessAnagementMachine.mmName
                this.dataForm.networkSegment = data.businessAnagementMachine.networkSegment
                this.dataForm.content = data.businessAnagementMachine.content
                this.dataForm.createUserId = data.businessAnagementMachine.createUserId
                this.dataForm.createTime = data.businessAnagementMachine.createTime
                this.dataForm.remarks = data.businessAnagementMachine.remarks
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
              url: this.$http.adornUrl(`/business/businessanagementmachine/${!this.dataForm.mmId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'mmId': this.dataForm.mmId || undefined,
                'mmName': this.dataForm.mmName,
                'networkSegment': this.dataForm.networkSegment,
                'content': this.dataForm.content,
                'createUserId': this.dataForm.createUserId,
                'createTime': this.dataForm.createTime,
                'remarks': this.dataForm.remarks
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
