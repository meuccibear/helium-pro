<template>
  <el-dialog
    :close-on-click-modal="false"
    :visible.sync="visible">

    <bar-animation-delay :chart-data="lineChartData"></bar-animation-delay>
<!--    :chart-data="lineChartData"-->
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
<!--      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>-->
    </span>
  </el-dialog>
</template>

<script>
  import BarAnimationDelay from '@/views/common/components/BarAnimationDelay'

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
        data1: [],
        data2: [],
        dataKey: [],
        lineChartData: {}
      }
    },
    components: {
      BarAnimationDelay
    },
    methods: {
      init (id, typeId) {
        console.log(id, typeId)
        this.dataForm.id = id || 0
        this.visible = true
        this.lineChartData = {
          id: id,
          typeId: typeId
        }
      }
    }
  }
</script>
