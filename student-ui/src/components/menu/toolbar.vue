<template>
  <el-row>
    <!--查询 Popover 弹出框-->
    <el-popover placement="bottom-start" v-model="queryDialogIsShow" width="80%" trigger="click">
      <el-form :inline="true" :model="queryFormData" class="demo-form-inline">
        <el-form-item label="菜单名">
          <el-input v-model="queryFormData.name" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-select v-model="queryFormData.region" placeholder="类型">
            <el-option label="类型一" value="shanghai"></el-option>
            <el-option label="类型二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="queryForm">查询</el-button>
        </el-form-item>
      </el-form>
      <el-button slot="reference" size="small" icon="el-icon-search">查询</el-button>
    </el-popover>
    <el-button type="success" size="small" icon="el-icon-plus" @click="addDialog">添加</el-button>
    <el-button type="info" size="small" icon="el-icon-edit" @click="editDialog">修改</el-button>
    <el-button type="danger" size="small" icon="el-icon-delete" @click="deleteHandle">删除</el-button>

    <!--添加弹出框-->
    <add  ref="addDialog"
          :addDialogIsShow="addDialogIsShow"
         v-on:dialogClose="addDialogCloseHandle"></add>
    <!--添加弹出框-->
    <edit  ref="editDialog"
          :editDialogIsShow="editDialogIsShow"
          v-on:dialogClose="editDialogCloseHandle"></edit>
  </el-row>
</template>

<script>
  import axios from 'axios'
  import add from './add.vue'
  import edit from './edit.vue'

  export default {
    //父组件传过来的值
    props: ["selectRows"],
    data() {
      return {
        queryDialogIsShow: false,  //查询对话框是否显示
        addDialogIsShow: false, //添加窗口
        editDialogIsShow: false, //修改窗口
        queryFormData: {
          name: '',
          region: ''
        }
      }
    },
    methods: {
      //点击添加 按钮 调用
      addDialog(data) { //添加
        this.addDialogIsShow = true;
      },
      queryForm(data) { //查询
        //保存新增加的菜单数据
        let form1 = this.$data.queryFormData;
        //获取查询参数，将参数解析成键值对
        let qs = require("qs");
        let param =  qs.stringify(form1);
        this.$emit("toolbarEvent","query",param);
        this.queryDialogIsShow = false ;
      },
      //修改按钮，弹出修改框
      editDialog(){
        let datas = this.selectRows;
        if (datas.length == 0) {
          alert("请选择要操作的数据");
        } else {
//          rowData = datas[0];
          let formData = this.$refs.editDialog.$data.formData;
          for (var a in formData) {
            formData[a] = datas[0][a];
          }
          this.editDialogIsShow = true;
          console.log('editDialog!'+this.editDialogIsShow);
        }
      }
      ,
      //删除按钮
      deleteHandle()
      {
        //获取要被删除的行，然后到后台删除
        this.$emit("toolbarEvent","delete","");
      }
      ,
      //当弹出框关闭时调用
      addDialogCloseHandle(isShow)
      {
        this.$emit("toolbarEvent","query","");
        this.addDialogIsShow = isShow;
      },
      editDialogCloseHandle(isShow)
      {
        this.$emit("toolbarEvent","query","");
        this.editDialogIsShow = isShow;
      }
    },
    components: {
      add,edit
    }
  }
</script>

<style>

</style>
