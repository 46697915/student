<template>
  <el-row>
    <!--查询 Popover 弹出框-->
    <el-popover placement="bottom-start" v-model="queryDialogIsShow" width="80%" trigger="click">
      <el-form :inline="true" :model="queryFormData" class="demo-form-inline" size="mini">

        <el-row>
          <el-col :span="8">
            <el-form-item label="名称">
              <el-input v-model="queryFormData.name" placeholder="姓名"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-form-item label="入学日期">
              <el-date-picker v-model="inschoolRange"
                              type="daterange"
                              range-separator="至"
                              start-placeholder="开始日期"
                              end-placeholder="结束日期"
                              format="yyyy-MM-dd"
                              value-format="yyyy-MM-dd"
                              :default-time="['00:00:00', '23:59:59']"
                              style="width: 80%;"
              >
              </el-date-picker>
              <!--<el-date-picker type="date" v-model="queryFormData.inschoolbegin" style="width: 30%;"-->
                              <!--format="yyyy-MM-dd"-->
                              <!--value-format="yyyy-MM-dd"></el-date-picker>-->
              <!--至-->
              <!--<el-date-picker type="date" v-model="queryFormData.inschoolend" style="width: 30%;"-->
                              <!--format="yyyy-MM-dd"-->
                              <!--value-format="yyyy-MM-dd"></el-date-picker>-->
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="性别">
              <!--<el-input v-model="formData.sex"></el-input>-->
              <el-select v-model="queryFormData.sex" placeholder="请选择性别">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-form-item>
          <el-button type="primary" @click="queryForm">查询</el-button>
          <el-button type="primary" @click="resetQueryForm">清空</el-button>
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
        inschoolRange: '',  //入学日期范围
        queryFormData: {
          name: '',
          inschoolbegin: '',
          inschoolend: '',
          sex: ''
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
      resetQueryForm() { //重置
        let datas = this.$data.queryFormData;
        for(var a in datas){
          datas[a] = '';
        }
        this.inschoolRange='';  //入学日期范围
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
    watch: {
      inschoolRange: function () {  //监控日期访问
        this.queryFormData.inschoolbegin=this.inschoolRange[0] ;
        this.queryFormData.inschoolend=this.inschoolRange[1] ;
      }
    },
    components: {
      add,edit
    }
  }
</script>

<style>

</style>
