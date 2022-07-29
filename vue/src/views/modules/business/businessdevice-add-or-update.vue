<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="一级客户名称" prop="onelevelname">
      <el-input v-model="dataForm.onelevelname" placeholder="一级客户名称"></el-input>
    </el-form-item>
    <el-form-item label="二级客户名称" prop="twolevelname">
      <el-input v-model="dataForm.twolevelname" placeholder="二级客户名称"></el-input>
    </el-form-item>
    <el-form-item label="英文简写" prop="en">
      <el-input v-model="dataForm.en" placeholder="英文简写"></el-input>
    </el-form-item>
    <el-form-item label="设备ID" prop="address">
      <el-input v-model="dataForm.address" placeholder="设备ID"></el-input>
    </el-form-item>
    <el-form-item label="设备名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="设备名称"></el-input>
    </el-form-item>
    <el-form-item label="内网IP" prop="publicid">
      <el-input v-model="dataForm.publicid" placeholder="内网IP"></el-input>
    </el-form-item>
    <el-form-item label="分组" prop="groupname">
      <el-input v-model="dataForm.groupname" placeholder="分组"></el-input>
    </el-form-item>
    <el-form-item label="管理机" prop="managename">
      <el-input v-model="dataForm.managename" placeholder="管理机"></el-input>
    </el-form-item>
    <el-form-item label="品牌" prop="pingpai">
      <el-input v-model="dataForm.pingpai" placeholder="品牌"></el-input>
    </el-form-item>
    <el-form-item label="MAC地址" prop="mac">
      <el-input v-model="dataForm.mac" placeholder="MAC地址"></el-input>
    </el-form-item>
    <el-form-item label="钱包" prop="owner">
      <el-input v-model="dataForm.owner" placeholder="钱包"></el-input>
    </el-form-item>
    <el-form-item label="设备存放地点" prop="locationaddress">
      <el-input v-model="dataForm.locationaddress" placeholder="设备存放地点"></el-input>
    </el-form-item>
    <el-form-item label="提供运维时间" prop="date">
      <el-input v-model="dataForm.date" placeholder="提供运维时间"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="re">
      <el-input v-model="dataForm.re" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="分组名称" prop="cname">
      <el-input v-model="dataForm.cname" placeholder="分组名称"></el-input>
    </el-form-item>
    <el-form-item label="ip" prop="ip">
      <el-input v-model="dataForm.ip" placeholder="ip"></el-input>
    </el-form-item>
    <el-form-item label="设备类型" prop="devtype">
      <el-input v-model="dataForm.devtype" placeholder="设备类型"></el-input>
    </el-form-item>
    <el-form-item label="信号管理服务器内网ip" prop="gip">
      <el-input v-model="dataForm.gip" placeholder="信号管理服务器内网ip"></el-input>
    </el-form-item>
    <el-form-item label="高度" prop="height">
      <el-input v-model="dataForm.height" placeholder="高度"></el-input>
    </el-form-item>
    <el-form-item label="gap" prop="gap">
      <el-input v-model="dataForm.gap" placeholder="gap"></el-input>
    </el-form-item>
    <el-form-item label="最后收到lora时间" prop="loratm">
      <el-input v-model="dataForm.loratm" placeholder="最后收到lora时间"></el-input>
    </el-form-item>
    <el-form-item label="最后的见证【见证别人】" prop="witnesstm">
      <el-input v-model="dataForm.witnesstm" placeholder="最后的见证【见证别人】"></el-input>
    </el-form-item>
    <el-form-item label="最后beacontm时间" prop="beacontm">
      <el-input v-model="dataForm.beacontm" placeholder="最后beacontm时间"></el-input>
    </el-form-item>
    <el-form-item label="挑战者地址" prop="lastwitness">
      <el-input v-model="dataForm.lastwitness" placeholder="挑战者地址"></el-input>
    </el-form-item>
    <el-form-item label="最后心跳时间" prop="hearttm">
      <el-input v-model="dataForm.hearttm" placeholder="最后心跳时间"></el-input>
    </el-form-item>
    <el-form-item label="检测结果" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="检测结果"></el-input>
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
          id: 0,
          onelevelname: '',
          twolevelname: '',
          en: '',
          address: '',
          name: '',
          publicid: '',
          groupname: '',
          managename: '',
          pingpai: '',
          mac: '',
          owner: '',
          locationaddress: '',
          date: '',
          re: '',
          cname: '',
          ip: '',
          devtype: '',
          gip: '',
          height: '',
          gap: '',
          loratm: '',
          witnesstm: '',
          beacontm: '',
          lastwitness: '',
          hearttm: '',
          remark: ''
        },
        dataRule: {
          onelevelname: [
            { required: true, message: '一级客户名称不能为空', trigger: 'blur' }
          ],
          twolevelname: [
            { required: true, message: '二级客户名称不能为空', trigger: 'blur' }
          ],
          en: [
            { required: true, message: '英文简写不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '设备ID不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '设备名称不能为空', trigger: 'blur' }
          ],
          publicid: [
            { required: true, message: '内网IP不能为空', trigger: 'blur' }
          ],
          groupname: [
            { required: true, message: '分组不能为空', trigger: 'blur' }
          ],
          managename: [
            { required: true, message: '管理机不能为空', trigger: 'blur' }
          ],
          pingpai: [
            { required: true, message: '品牌不能为空', trigger: 'blur' }
          ],
          mac: [
            { required: true, message: 'MAC地址不能为空', trigger: 'blur' }
          ],
          owner: [
            { required: true, message: '钱包不能为空', trigger: 'blur' }
          ],
          locationaddress: [
            { required: true, message: '设备存放地点不能为空', trigger: 'blur' }
          ],
          date: [
            { required: true, message: '提供运维时间不能为空', trigger: 'blur' }
          ],
          re: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          cname: [
            { required: true, message: '分组名称不能为空', trigger: 'blur' }
          ],
          ip: [
            { required: true, message: 'ip不能为空', trigger: 'blur' }
          ],
          devtype: [
            { required: true, message: '设备类型不能为空', trigger: 'blur' }
          ],
          gip: [
            { required: true, message: '信号管理服务器内网ip不能为空', trigger: 'blur' }
          ],
          height: [
            { required: true, message: '高度不能为空', trigger: 'blur' }
          ],
          gap: [
            { required: true, message: 'gap不能为空', trigger: 'blur' }
          ],
          loratm: [
            { required: true, message: '最后收到lora时间不能为空', trigger: 'blur' }
          ],
          witnesstm: [
            { required: true, message: '最后的见证【见证别人】不能为空', trigger: 'blur' }
          ],
          beacontm: [
            { required: true, message: '最后beacontm时间不能为空', trigger: 'blur' }
          ],
          lastwitness: [
            { required: true, message: '挑战者地址不能为空', trigger: 'blur' }
          ],
          hearttm: [
            { required: true, message: '最后心跳时间不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '检测结果不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/business/businessdevice/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.onelevelname = data.businessDevice.onelevelname
                this.dataForm.twolevelname = data.businessDevice.twolevelname
                this.dataForm.en = data.businessDevice.en
                this.dataForm.address = data.businessDevice.address
                this.dataForm.name = data.businessDevice.name
                this.dataForm.publicid = data.businessDevice.publicid
                this.dataForm.groupname = data.businessDevice.groupname
                this.dataForm.managename = data.businessDevice.managename
                this.dataForm.pingpai = data.businessDevice.pingpai
                this.dataForm.mac = data.businessDevice.mac
                this.dataForm.owner = data.businessDevice.owner
                this.dataForm.locationaddress = data.businessDevice.locationaddress
                this.dataForm.date = data.businessDevice.date
                this.dataForm.re = data.businessDevice.re
                this.dataForm.cname = data.businessDevice.cname
                this.dataForm.ip = data.businessDevice.ip
                this.dataForm.devtype = data.businessDevice.devtype
                this.dataForm.gip = data.businessDevice.gip
                this.dataForm.height = data.businessDevice.height
                this.dataForm.gap = data.businessDevice.gap
                this.dataForm.loratm = data.businessDevice.loratm
                this.dataForm.witnesstm = data.businessDevice.witnesstm
                this.dataForm.beacontm = data.businessDevice.beacontm
                this.dataForm.lastwitness = data.businessDevice.lastwitness
                this.dataForm.hearttm = data.businessDevice.hearttm
                this.dataForm.remark = data.businessDevice.remark
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
              url: this.$http.adornUrl(`/business/businessdevice/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'onelevelname': this.dataForm.onelevelname,
                'twolevelname': this.dataForm.twolevelname,
                'en': this.dataForm.en,
                'address': this.dataForm.address,
                'name': this.dataForm.name,
                'publicid': this.dataForm.publicid,
                'groupname': this.dataForm.groupname,
                'managename': this.dataForm.managename,
                'pingpai': this.dataForm.pingpai,
                'mac': this.dataForm.mac,
                'owner': this.dataForm.owner,
                'locationaddress': this.dataForm.locationaddress,
                'date': this.dataForm.date,
                're': this.dataForm.re,
                'cname': this.dataForm.cname,
                'ip': this.dataForm.ip,
                'devtype': this.dataForm.devtype,
                'gip': this.dataForm.gip,
                'height': this.dataForm.height,
                'gap': this.dataForm.gap,
                'loratm': this.dataForm.loratm,
                'witnesstm': this.dataForm.witnesstm,
                'beacontm': this.dataForm.beacontm,
                'lastwitness': this.dataForm.lastwitness,
                'hearttm': this.dataForm.hearttm,
                'remark': this.dataForm.remark
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
