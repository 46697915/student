<template>

  <el-container style=" border: 0px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <studentList v-on:studSelectEvent="studSelectEventHandle"></studentList>
    </el-aside>
    <el-main>
      <el-tabs type="border-card" tab-position="top">
        <el-tab-pane label="学习信息">
          <studentLearn
            :selectStudRow=selectStudRow></studentLearn>
        </el-tab-pane>
        <el-tab-pane label="点评信息">
          <studentReview
            :selectStudRow=selectStudRow>
          </studentReview>
        </el-tab-pane>
        <el-tab-pane label="面试信息">
          <studentInterview
            :selectStudRow=selectStudRow></studentInterview>
        </el-tab-pane>
        <el-tab-pane label="工作信息">
          <studentWork
            :selectStudRow=selectStudRow></studentWork>
        </el-tab-pane>
      </el-tabs>
    </el-main>
  </el-container>

</template>

<script>
  import axios from 'axios'
  import studentList from '../../student/info/list_query.vue'
  import studentLearn from '../../student/learn/listForStur.vue'
  import studentReview from '../../student/review/listForStur.vue'
  import studentInterview from '../../student/interview/listForStur.vue'
  import studentWork from '../../student/work/listForStur.vue'

  export default {

    data() {
      return {
        selectStudRow: {}
      }
    },
    methods: {
      studSelectEventHandle(row){
//        console.log("选中的学生："+row)
        this.selectStudRow = row ;
      }
    },
    components: {
      studentList,
      studentLearn,
      studentReview,studentInterview,studentWork
    }
  }
</script>

<style>

</style>
