<template>

  <!--窗口-->
  <el-dialog title="修改" :visible.sync="dialogIsShow" width="60%" @close="dialogClose">
    <el-form :model="formData" ref="formData" label-width="100px" size="medium">
      <el-row>
        <el-col :span="8">
          <el-form-item label="编号" prop="code">
            <el-input v-model="formData.code"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="formData.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="身份证号" prop="ic">
            <el-input v-model="formData.ic"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="性别" prop="sex">
            <!--<el-input v-model="formData.sex"></el-input>-->
            <el-select v-model="formData.sex" placeholder="请选择性别">
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="出生日期" prop="birthday">
            <el-date-picker type="date" v-model="formData.birthday" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="学历" prop="xueli">
            <el-input v-model="formData.xueli"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="formData.email"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="婚否" prop="hunfou">
            <!--<el-input v-model="formData.hunfou"></el-input>-->
            <el-select v-model="formData.hunfou" placeholder="请选择">
              <el-option label="是" value="是"></el-option>
              <el-option label="否" value="否"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="地址" prop="address">
            <el-input v-model="formData.address"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="入学日期" prop="inschool">
            <el-date-picker type="date" v-model="formData.inschool" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="市场部" prop="shichangbu">
            <el-input v-model="formData.shichangbu"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="备注" prop="remarks">
            <el-input v-model="formData.remarks"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

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
          id: '',
          code: '',
          name: '',
          ic: '',
          sex: '',
          birthday: '',
          xueli: '',
          email: '',
          hunfou: '',
          address: '',
          inschool: '',
          shichangbu: '',
          remarks: ''
        },

        editUrl: this.domain.serverpath + "/studentInfo/edit"
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
