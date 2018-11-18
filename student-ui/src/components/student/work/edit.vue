<template>

  <!--窗口-->
  <el-dialog title="修改" :visible.sync="dialogIsShow" width="60%" @close="dialogClose">
    <el-form :model="formData" ref="formData" label-width="100px" size="medium">

      <el-row>
        <el-col :span="8">
          <el-form-item label="学生名称" prop="studName">
            <!--<el-input v-model="formData.studName"></el-input>-->
            <selectStud v-model="formData.studName"
                        :selectStudValue="formData.studName"
                        @selectStudChange="selectStudChangeHandle"></selectStud>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="公司名称" prop="comName">
            <el-input v-model="formData.comName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="公司地址" prop="comAddress">
            <el-input v-model="formData.comAddress"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="工作内容" prop="workContent">
            <el-input v-model="formData.workContent"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="入职时间" prop="inDate">
            <el-date-picker type="date" v-model="formData.inDate" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="离职时间" prop="outDate">
            <el-date-picker type="date" v-model="formData.outDate" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="联系人" prop="linkMan">
            <el-input v-model="formData.linkMan"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="公司所在城市" prop="comCity">
            <el-input v-model="formData.comCity"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="工作性质" prop="workXz">
            <el-input v-model="formData.workXz"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="所属行业" prop="workSshy">
            <el-input v-model="formData.workSshy"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="备注" prop="remarks">
            <el-input v-model="formData.remarks"></el-input>
          </el-form-item>
        </el-col>
        <!--<el-col :span="8">-->
          <!--<el-form-item label="学生ID" prop="studId">-->
            <!--<el-input v-model="formData.studId"></el-input>-->
          <!--</el-form-item>-->
        <!--</el-col>-->
      </el-row>

      <!--<el-form-item >-->
        <!--<el-input type="hidden" v-model="formData.id"></el-input>-->
        <!--<el-input type="hidden" v-model="formData.studId"></el-input>-->
      <!--</el-form-item>-->

      <el-form-item>
        <el-button type="primary" @click="submitForm()">保存</el-button>
        <!--<el-button @click="resetForm()">重置</el-button>-->
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>

  import axios from 'axios'
  import selectStud from './../info/selectStud.vue'
  export default {
    //属性，接收父页面传值
    props: ["editDialogIsShow"],
    data() {
      return {
        dialogIsShow: false,
        formData: {
          id: '',
          comName: '',
          comAddress: '',
          workContent: '',
          inDate: '',
          outDate: '',
          linkMan: '',
          comCity: '',
          workXz: '',
          workSshy: '',
          remarks: '',
//          operator: '',
//          operatedate: '',
          studId: '',
          studName: ''
        },

        editUrl: this.domain.serverpath + "/studWork/edit"
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
      },
      selectStudChangeHandle(option){
        this.formData.studName=option.name ;
        this.formData.studId=option.id ;
      }

    },
    watch: {
      editDialogIsShow: function () {  //监控父组件传过来的属性变化
        this.dialogIsShow = this.editDialogIsShow;
      }
    },
    components: {
      selectStud
    }
  }
</script>

<style>

</style>
