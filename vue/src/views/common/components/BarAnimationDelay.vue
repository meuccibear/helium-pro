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
      option: {
        title: {
          text: '状态历史'
        },
        legend: {
          // a legendData
          data: []
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
          // a data.dataKey
          data: [],
          splitLine: {
            show: false
          }
        },
        yAxis: {},
        // a
        series: [],
        animationEasing: 'elasticOut',
        animationDelayUpdate: function (idx) {
          return idx * 5
        }
      },
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
    // this.$nextTick(() => {
    //   console.log('initChart')
    //   this.initChart()
    // })
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
      // this.setOptions(this.chartData)
      this.setOptions(this.chartData)
    },
    // setOptions ({ typeId, id } = {}) {
    //   this.$http({
    //     url: this.$http.adornUrl('/business/businessG5device/info'),
    //     method: 'get',
    //     params: this.$http.adornParams({
    //       'typeId': typeId,
    //       'id': id
    //     })
    //   }).then(({data}) => {
    //     if (data && data.code === 0) {
    //       var legendData = []
    //       var series = []
    //       for (const col of data.dataCol) {
    //         series.push({
    //           name: col,
    //           type: 'bar',
    //           data: data[col],
    //           emphasis: {
    //             focus: 'series'
    //           },
    //           animationDelay: function (idx) {
    //             return idx * 10
    //           }
    //         })
    //       }
    //       legendData = data.dataCol
    //       var option = {
    //         title: {
    //           text: '状态历史'
    //         },
    //         legend: {
    //           data: legendData
    //         },
    //         toolbox: {
    //           // y: 'bottom',
    //           feature: {
    //             magicType: {
    //               type: ['stack']
    //             },
    //             dataView: {},
    //             saveAsImage: {
    //               pixelRatio: 2
    //             }
    //           }
    //         },
    //         dataZoom: [
    //           {
    //             type: 'inside',
    //             start: 0,
    //             end: 100
    //           },
    //           {
    //             start: 0,
    //             end: 100
    //           }
    //         ],
    //         tooltip: {},
    //         xAxis: {
    //           data: data.dataKey,
    //           splitLine: {
    //             show: false
    //           }
    //         },
    //         yAxis: {},
    //         series: series,
    //         animationEasing: 'elasticOut',
    //         animationDelayUpdate: function (idx) {
    //           return idx * 5
    //         }
    //       }
    //       window.option = option
    //       this.chart.setOption(option)
    //     } else {
    //       this.chart.setOption({
    //         'title': {
    //           'text': '状态历史'
    //         },
    //         'legend': {
    //           'data': [
    //             'internel'
    //           ]
    //         },
    //         'toolbox': {
    //           'feature': {
    //             'magicType': {
    //               'type': [
    //                 'stack'
    //               ]
    //             },
    //             'dataView': {
    //
    //             },
    //             'saveAsImage': {
    //               'pixelRatio': 2
    //             }
    //           }
    //         },
    //         'dataZoom': [
    //           {
    //             'type': 'inside',
    //             'start': 0,
    //             'end': 100
    //           },
    //           {
    //             'start': 0,
    //             'end': 100
    //           }
    //         ],
    //         'tooltip': {
    //
    //         },
    //         'xAxis': {
    //           'data': [
    //
    //           ],
    //           'splitLine': {
    //             'show': false
    //           }
    //         },
    //         'yAxis': {
    //
    //         },
    //         'series': [
    //           {
    //             'name': 'internel',
    //             'type': 'bar',
    //             'data': [
    //
    //             ],
    //             'emphasis': {
    //               'focus': 'series'
    //             }
    //           }
    //         ],
    //         'animationEasing': 'elasticOut'
    //       })
    //     }
    //   })
    // },
    setOptions (data) {
      if (!this.chart) {
        console.log('echarts:', echarts)
        this.chart = echarts.init(this.$el, 'macarons')
      }
      var series = []
      for (const col of data.dataCol) {
        series.push({
          name: col,
          type: 'bar',
          data: data[col],
          emphasis: {
            focus: 'series'
          },
          animationDelay: function (idx) {
            return idx * 10
          }
        })
      }
      this.option.series = series
      this.option.xAxis.data = data.dataKey
      this.option.legend.data = data.dataCol
      window.option = this.option
      console.log(this.option)
      this.chart.setOption(this.option, true)
    }
  }
}
</script>
