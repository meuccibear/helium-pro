<template>
  <el-dialog
    :title="!dataForm.hotspottyId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
<!--    <el-form-item label="名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="名称"></el-input>
    </el-form-item>-->
    <el-form-item label="分组" prop="groupId">
      <!--      <el-input v-model="dataForm.groupId" placeholder="分组"></el-input>-->
      <el-select v-model="dataForm.groupId" placeholder="请选择" :value="dataForm.groupId">
        <el-option
          v-for="item in groupSelect"
          :key="item.groupId"
          :label="item.groupName"
          :value="item.groupId">
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="内网IP" prop="privateIp">
      <el-input v-model="dataForm.privateIp" placeholder="内网IP"></el-input>
    </el-form-item>
    <el-form-item label="公网IP" prop="publicIp">
      <el-input v-model="dataForm.publicIp" placeholder="公网IP"></el-input>
    </el-form-item>
<!--    <el-form-item label="品牌" prop="brand">
      <el-input v-model="dataForm.brand" placeholder="品牌"></el-input>
    </el-form-item>-->
    <el-form-item label="房间" prop="room">
      <el-input v-model="dataForm.room" placeholder="房间"></el-input>
    </el-form-item>
<!--    <el-form-item label="设备状态" prop="online">
      <el-input v-model="dataForm.online" placeholder="设备状态"></el-input>
    </el-form-item>
    <el-form-item label="国家" prop="country">
      <el-input v-model="dataForm.country" placeholder="国家"></el-input>
    </el-form-item>
    <el-form-item label="城市" prop="city">
      <el-input v-model="dataForm.city" placeholder="城市"></el-input>
    </el-form-item>
    <el-form-item label="街道" prop="street">
      <el-input v-model="dataForm.street" placeholder="街道"></el-input>
    </el-form-item>
    <el-form-item label="Hex" prop="hex">
      <el-input v-model="dataForm.hex" placeholder="Hex"></el-input>
    </el-form-item>
    <el-form-item label="24小时收益" prop="total24h">
      <el-input v-model="dataForm.total24h" placeholder="24小时收益"></el-input>
    </el-form-item>
    <el-form-item label="7天收益" prop="total1d">
      <el-input v-model="dataForm.total1d" placeholder="7天收益"></el-input>
    </el-form-item>
    <el-form-item label="30天收益" prop="total30d">
      <el-input v-model="dataForm.total30d" placeholder="30天收益"></el-input>
    </el-form-item>
    <el-form-item label="钱包地址" prop="owner">
      <el-input v-model="dataForm.owner" placeholder="钱包地址"></el-input>
    </el-form-item>-->
    <el-form-item label="设备地址" prop="address">
      <el-tooltip placement="top">
        <div slot="content">使用换行隔开 实现批量导入~</div>
        <el-input
          type="textarea"
          :rows="2"
          v-model="dataForm.address" placeholder="设备地址"></el-input>
      </el-tooltip>
<!--      <el-input v-model="dataForm.address" placeholder="设备地址"></el-input>-->
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
    <el-form-item label="修改时间" prop="updateTime" >
      <el-input v-model="dataForm.updateTime" placeholder="修改时间" :disabled="true"></el-input>
    </el-form-item>
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
          hotspottyId: 0,
          groupId: null,
          name: '',
          privateIp: '',
          publicIp: '',
          brand: '',
          room: '',
          online: '',
          country: '',
          city: '',
          street: '',
          hex: '',
          total24h: '',
          total1d: '',
          total30d: '',
          owner: '',
          address: '',
          remarks: '',
          createUserId: '',
          createTime: '',
          updateTime: '',
          status: ''
        },
        dataRule: {
          // name: [
          //   { required: true, message: '名称不能为空', trigger: 'blur' }
          // ],
          // privateIp: [
          //   { required: true, message: '内网IP不能为空', trigger: 'blur' }
          // ],
          // publicIp: [
          //   { required: true, message: '公网IP不能为空', trigger: 'blur' }
          // ],
          // brand: [
          //   { required: true, message: '品牌不能为空', trigger: 'blur' }
          // ],
          // room: [
          //   { required: true, message: '房间不能为空', trigger: 'blur' }
          // ],
          // online: [
          //   { required: true, message: '设备状态不能为空', trigger: 'blur' }
          // ],
          // country: [
          //   { required: true, message: '国家不能为空', trigger: 'blur' }
          // ],
          // city: [
          //   { required: true, message: '城市不能为空', trigger: 'blur' }
          // ],
          // street: [
          //   { required: true, message: '街道不能为空', trigger: 'blur' }
          // ],
          // hex: [
          //   { required: true, message: 'Hex不能为空', trigger: 'blur' }
          // ],
          // total24h: [
          //   { required: true, message: '24小时收益不能为空', trigger: 'blur' }
          // ],
          // total1d: [
          //   { required: true, message: '7天收益不能为空', trigger: 'blur' }
          // ],
          // total30d: [
          //   { required: true, message: '30天收益不能为空', trigger: 'blur' }
          // ],
          // owner: [
          //   { required: true, message: '钱包地址不能为空', trigger: 'blur' }
          // ],
          address: [
            { required: true, message: '设备地址不能为空', trigger: 'blur' }
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
          // updateTime: [
          //   { required: true, message: '修改时间不能为空', trigger: 'blur' }
          // ],
          status: [
            { required: true, message: '状态  0：禁用   1：正常不能为空', trigger: 'blur' }
          ]
        },
        groupSelect: []
      }
    },
    methods: {
      init (id) {
        this.dataForm.hotspottyId = id || 0
        this.visible = true
        this.$http({
          url: this.$http.adornUrl('/business/businessgroup/select'),
          method: 'get',
          params: this.$http.adornParams()
        }).then(({data}) => {
          this.groupSelect = data.groupSelect
        }).then(() => {
          this.visible = true
          this.$nextTick(() => {
            this.$refs['dataForm'].resetFields()
          })
        }).then(() => {
          this.$nextTick(() => {
            this.$refs['dataForm'].resetFields()
            if (this.dataForm.hotspottyId) {
              this.$http({
                url: this.$http.adornUrl(`/business/businesshotspotty/info/${this.dataForm.hotspottyId}`),
                method: 'get',
                params: this.$http.adornParams()
              }).then(({data}) => {
                if (data && data.code === 0) {
                  this.dataForm.name = data.businessHotspotty.name
                  this.dataForm.privateIp = data.businessHotspotty.privateIp
                  this.dataForm.publicIp = data.businessHotspotty.publicIp
                  this.dataForm.brand = data.businessHotspotty.brand
                  this.dataForm.room = data.businessHotspotty.room
                  this.dataForm.online = data.businessHotspotty.online
                  this.dataForm.country = data.businessHotspotty.country
                  this.dataForm.city = data.businessHotspotty.city
                  this.dataForm.street = data.businessHotspotty.street
                  this.dataForm.hex = data.businessHotspotty.hex
                  this.dataForm.total24h = data.businessHotspotty.total24h
                  this.dataForm.total1d = data.businessHotspotty.total1d
                  this.dataForm.total30d = data.businessHotspotty.total30d
                  this.dataForm.owner = data.businessHotspotty.owner
                  this.dataForm.address = data.businessHotspotty.address
                  this.dataForm.remarks = data.businessHotspotty.remarks
                  this.dataForm.createUserId = data.businessHotspotty.createUserId
                  this.dataForm.createTime = data.businessHotspotty.createTime
                  this.dataForm.updateTime = data.businessHotspotty.updateTime
                  this.dataForm.status = data.businessHotspotty.status
                }
              })
            }
          })
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/business/businesshotspotty/${!this.dataForm.hotspottyId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'hotspottyId': this.dataForm.hotspottyId || undefined,
                'groupId': this.dataForm.groupId,
                'name': this.dataForm.name,
                'privateIp': this.dataForm.privateIp,
                'publicIp': this.dataForm.publicIp,
                'brand': this.dataForm.brand,
                'room': this.dataForm.room,
                'online': this.dataForm.online,
                'country': this.dataForm.country,
                'city': this.dataForm.city,
                'street': this.dataForm.street,
                'hex': this.dataForm.hex,
                'total24h': this.dataForm.total24h,
                'total1d': this.dataForm.total1d,
                'total30d': this.dataForm.total30d,
                'owner': this.dataForm.owner,
                'address': this.dataForm.address,
                'remarks': this.dataForm.remarks,
                'createUserId': this.dataForm.createUserId,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
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
