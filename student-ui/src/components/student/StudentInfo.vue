<template>
  <!--========list页面及分页========-->
  <el-row>
    <toolbar></toolbar>
    <list></list>
  </el-row>

</template>

<script>
  import axios from 'axios'
  import list from './list.vue'
  import toolbar from './toolbar.vue'

  export default {
    components: {
      list, toolbar
    }
  }
</script>

<style>

</style>
