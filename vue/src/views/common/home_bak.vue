<template>
  <div class="mod-home">
    <el-row :gutter="20">
      <el-col :span="6"><div class="grid-content bg-purple">钱包总余额</div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">24小时总收益</div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">设备总数</div></el-col>
<!--      <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>-->
    </el-row>
<!--    <h3>欢迎来到Helium 管理系统</h3>-->
  </div>
</template>

<script>
  export default {
  }
</script>

<style>
  .mod-home {
    line-height: 1.5;
  }

  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>

