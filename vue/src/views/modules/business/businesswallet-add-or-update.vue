<template>
  <el-dialog
    :title="!dataForm.walletId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="分组" prop="groupId">
<!--      <el-input v-model="dataForm.groupId" placeholder="分组"></el-input>-->
      <el-select v-model="dataForm.groupId" placeholder="请选择" :value="dataForm.groupId">
        <el-option
          v-for="item in groupList"
          :key="item.groupId"
          :label="item.groupName"
          :value="item.groupId">
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="钱包地址" prop="owner">
      <el-tooltip placement="top">
        <div slot="content">使用换行隔开 实现批量导入~</div>
        <el-input
          type="textarea"
          :rows="2"
          v-model="dataForm.owner" placeholder="钱包地址"></el-input>
      </el-tooltip>
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
          <el-radio :label="1">正常</el-radio>
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
          walletId: 0,
          groupId: null,
          owner: '',
          remarks: '',
          createUserId: '',
          createTime: '',
          status: ''
        },
        dataRule: {
          groupId: [
            { required: true, message: '分组不能为空', trigger: 'blur' }
          ],
          owner: [
            { required: true, message: '钱包地址不能为空', trigger: 'blur' }
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
        },
        groupList: []
      }
    },
    methods: {
      init (id) {
        this.dataForm.walletId = id || 0
        this.visible = true
        this.$http({
          url: this.$http.adornUrl('/business/businessgroup/select'),
          method: 'get',
          params: this.$http.adornParams()
        }).then(({data}) => {
          this.groupList = data.groupList
        }).then(() => {
          this.visible = true
          this.$nextTick(() => {
            this.$refs['dataForm'].resetFields()
          })
        }).then(() => {
          if (this.dataForm.walletId) {
            this.$http({
              url: this.$http.adornUrl(`/business/businesswallet/info/${this.dataForm.walletId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.groupId = data.businessWallet.groupId
                this.dataForm.owner = data.businessWallet.owner
                this.dataForm.remarks = data.businessWallet.remarks
                this.dataForm.createUserId = data.businessWallet.createUserId
                this.dataForm.createTime = data.businessWallet.createTime
                this.dataForm.status = data.businessWallet.status
              }
            })
          }
        })
        // this.$nextTick(() => {
        //   this.$refs['dataForm'].resetFields()
        //
        // })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/business/businesswallet/${!this.dataForm.walletId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'walletId': this.dataForm.walletId || undefined,
                'groupId': this.dataForm.groupId,
                'owner': this.dataForm.owner,
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
