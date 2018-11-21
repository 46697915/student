<template>

  <el-container style=" border: 0px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      学生信息
      <studentList></studentList>
    </el-aside>
    <el-main>
      <el-tabs type="border-card" tab-position="top">
        <el-tab-pane label="用户管理">用户管理</el-tab-pane>
        <el-tab-pane label="配置管理">配置管理</el-tab-pane>
        <el-tab-pane label="角色管理">角色管理</el-tab-pane>
        <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>
      </el-tabs>
    </el-main>
  </el-container>

</template>

<script>
  import axios from 'axios'
  import studentList from '../../student/info/list.vue'

  export default {

    components: {
      studentList
    }
  }
</script>

<style>

</style>
