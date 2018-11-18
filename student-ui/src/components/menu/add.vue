<template>

  <!--窗口-->
  <el-dialog title="添加" :visible.sync="dialogIsShow" width="60%" @close="dialogClose">
    <el-form :model="formData" ref="formData" label-width="100px" size="medium">
      <el-row>
        <el-col :span="12">
          <el-form-item label="菜单编号" prop="code">
            <el-input v-model="formData.code"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="父菜单" prop="pcode">
            <el-input v-model="formData.pcode"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="菜单名称" prop="name" required>
            <el-input v-model="formData.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="菜单URL" prop="url">
            <el-input v-model="formData.url"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-form-item>
        <el-button type="primary" @click="submitForm()">保存</el-button>
        <el-button @click="resetForm()">重置</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>

  import axios from 'axios'
  export default {
    //属性，接收父页面传值
    props: ["addDialogIsShow"],
    data() {
      return {
        dialogIsShow: false,
        formData: {
          code: '',
          pcode: '',
          name: '',
          url: ''
        },

        addUrl : this.domain.serverpath + "/sysMenu/add"
      }
    },
    methods: {
      submitForm() { //添加
        //保存新增加的菜单数据
        let form1 = this.$data.formData;
        //获取查询参数，将参数解析成键值对
        let qs = require("qs");
        this.$axios.post(this.addUrl,
          qs.stringify(form1)).then((response)=> {
          this.dialogIsShow = false ;
          this.resetForm();
          console.log(response.data.result);
        }).catch((error)=> {
          console.log(error);
        })
      },
      resetForm() { //重置
//        let datas = this.$data.formData;
//        for(var a in datas){
//          datas[a] = '';
//        }
        this.$refs.formData.resetFields();
      },
      dialogClose() { //窗口关闭事件
        //弹出框关闭是，触发dialogClose事件，父组件处理此事件
        this.$emit("dialogClose", false);
      }
    },
    watch: {
      addDialogIsShow: function () {  //监控父组件传过来的属性变化
        this.dialogIsShow = this.addDialogIsShow;
      }
    }
  }
</script>

<style>

</style>
