<template>
  <el-row>
    <!--查询 Popover 弹出框-->
    <el-popover placement="bottom-start" width="80%" trigger="click">
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item label="姓名">
          <el-input v-model="formInline.user" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-select v-model="formInline.region" placeholder="类型">
            <el-option label="类型一" value="shanghai"></el-option>
            <el-option label="类型二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
      </el-form>
      <el-button slot="reference" size="small" icon="el-icon-search">查询</el-button>
    </el-popover>
    <el-button type="success" size="small" icon="el-icon-plus" @click="addDialog">添加</el-button>
    <el-button type="info" size="small" icon="el-icon-edit" @click="editDialog">修改</el-button>
    <el-button type="danger" size="small" icon="el-icon-delete" @click="deleteHandle">删除</el-button>

    <!--添加弹出框-->
    <add :addDialogIsShow="addDialogShow" v-on:dialogClose="dialogCloseHandle"></add>
  </el-row>
</template>

<script>
  import axios from 'axios'
  import add from './add.vue'

  export default {
    data() {
      return {
        addDialogShow: false, //添加窗口
        formInline: {
          user: '',
          region: ''
        }
      }
    },
    methods: {
      //点击添加 按钮 调用
      addDialog(data) { //添加
        this.addDialogShow = true;
        console.log('add!');
      },
      //修改按钮
      editDialog(){
        //获取要被删除的影片，然后到后台删除
        console.log('editDialog!');
      }
      ,
      //删除按钮
      deleteHandle()
      {
        //获取要被删除的影片，然后到后台删除
        console.log('deleteHandle!');
      }
      ,
      //查询方法
      onSubmit()
      {
        console.log('submit!');
      }
      ,
      //当弹出框关闭时调用
      dialogCloseHandle(isShow)
      {
        this.addDialogShow = isShow;
      }
    },
    components: {
      add
    }
  }
</script>

<style>

</style>
