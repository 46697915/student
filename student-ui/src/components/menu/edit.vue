<template>

  <!--窗口-->
  <el-dialog title="修改" :visible.sync="dialogIsShow" width="60%" @close="dialogClose">
    <el-form :model="formData" ref="formData" label-width="100px" size="medium">
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
      <el-form-item >
        <el-input type="hidden" v-model="formData.code"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm()">保存</el-button>
        <!--<el-button @click="resetForm()">重置</el-button>-->
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>

  import axios from 'axios'
  export default {
    //属性，接收父页面传值
    props: ["editDialogIsShow"],
    data() {
      return {
        dialogIsShow: false,
        formData: {
          code: '',
          name: '',
          url: ''
        },

        editUrl: this.domain.serverpath + "/sysMenu/edit"
      }
    },
    methods: {
      submitForm() { //添加
        //保存新增加的菜单数据
        let form1 = this.$data.formData;
        //获取查询参数，将参数解析成键值对
        let qs = require("qs");
        console.log(qs.stringify(form1));
        let that = this ;
        this.$axios.post(this.editUrl, qs.stringify(form1))
          .then(function(response){
            that.dialogIsShow = false ;
            that.resetForm();
            console.log(response.data.result);
          }).catch(function(error){
              console.log(error);
          })
      },
      resetForm() { //重置
        this.$refs.formData.resetFields();
      },
      dialogClose() { //窗口关闭事件
        //弹出框关闭是，触发dialogClose事件，父组件处理此事件
        this.$emit("dialogClose", false);
      }
    },
    watch: {
      editDialogIsShow: function () {  //监控父组件传过来的属性变化
        this.dialogIsShow = this.editDialogIsShow;
      }
    }
  }
</script>

<style>

</style>
