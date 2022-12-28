<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from 'echarts'
import resize from './mixins/resize'
require('echarts/theme/macarons') // echarts theme

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '350px'
    },
    autoResize: {
      type: Boolean,
      default: true
    },
    chartData: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      chart: null
    }
  },
  watch: {
    chartData: {
      deep: true,
      handler (val) {
        this.setOptions(val)
      }
    }
  },
  mounted () {
    this.$nextTick(() => {
      this.initChart()
    })
  },
  beforeDestroy () {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart () {
      this.chart = echarts.init(this.$el, 'macarons')
      this.setOptions(this.chartData)
    },
    setOptions ({ typeId, id } = {}) {
      this.$http({
        url: this.$http.adornUrl('/business/businessG5device/info'),
        method: 'get',
        params: this.$http.adornParams({
          'typeId': typeId,
          'id': id
        })
      }).then(({data}) => {
        if (data && data.code === 0) {
          var legendData = []
          var series = []
          if (typeId === 1) {
            series = [
              {
                name: 'internel',
                type: 'bar',
                data: data.data1,
                emphasis: {
                  focus: 'series'
                },
                animationDelay: function (idx) {
                  return idx * 10
                }
              }]
            legendData = ['internel']
            this.data1 = data.data1
            this.dataKey = data.dataKey
          } else {
            series = [
              {
                name: 'core_stat',
                type: 'bar',
                data: data.data1,
                emphasis: {
                  focus: 'series'
                },
                animationDelay: function (idx) {
                  return idx * 10
                }
              },
              {
                name: 'onair',
                type: 'bar',
                data: data.data2,
                emphasis: {
                  focus: 'series'
                },
                animationDelay: function (idx) {
                  return idx * 10 + 100
                }
              }]
            legendData = ['core_stat', 'onair']
            this.data1 = data.data1
            this.data2 = data.data2
            this.dataKey = data.dataKey
          }
          var option = {
            title: {
              text: '状态历史'
            },
            legend: {
              data: legendData
            },
            toolbox: {
              // y: 'bottom',
              feature: {
                magicType: {
                  type: ['stack']
                },
                dataView: {},
                saveAsImage: {
                  pixelRatio: 2
                }
              }
            },
            dataZoom: [
              {
                type: 'inside',
                start: 0,
                end: 100
              },
              {
                start: 0,
                end: 100
              }
            ],
            tooltip: {},
            xAxis: {
              data: data.dataKey,
              splitLine: {
                show: false
              }
            },
            yAxis: {},
            series: series,
            animationEasing: 'elasticOut',
            animationDelayUpdate: function (idx) {
              return idx * 5
            }
          }
          this.chart.setOption(option)
        }
      })
    }
  }
}
</script>
