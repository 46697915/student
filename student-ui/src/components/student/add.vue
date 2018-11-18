<template>

  <!--添加影片窗口-->
  <el-dialog title="添加" :visible.sync="addDialogShow" width="80%" @close="dialogClose">
    <el-form :model="addFormData" ref="addFormData" label-width="100px" size="medium">
      <el-row>
        <el-col :span="12">
          <el-form-item label="影片名称" prop="name">
            <el-input v-model="addFormData.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="上映时间" prop="date" required>
            <el-form-item prop="date">
              <el-date-picker type="date" placeholder="选择日期" v-model="addFormData.date"
                              style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-form-item>
        </el-col>

      </el-row>

      <el-form-item>
        <el-button type="primary" @click="submitForm('filmData')">添加影片</el-button>
        <el-button @click="resetForm('filmData')">重置信息</el-button>
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
        addDialogShow: false,
        addFormData: {
          name: '',
          date: ''
        }
      }
    },
    methods: {
      submitForm(data) { //添加
        console.log('submit!');
      },
      dialogClose() { //窗口关闭事件
        //弹出框关闭是，触发dialogClose事件，父组件处理此事件
        this.$emit("dialogClose", false);
      }
    },
    watch: {
      addDialogIsShow: function(){  //监控父组件传过来的属性变化
        this.addDialogShow = this.addDialogIsShow;
      }
    }
  }
</script>

<style>

</style>
