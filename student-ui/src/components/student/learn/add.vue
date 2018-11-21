<template>

  <!--窗口-->
  <el-dialog title="添加" :visible.sync="dialogIsShow" width="60%" @close="dialogClose">
    <el-form :model="formData" ref="formData" :rules="rules2" label-width="100px" size="medium">

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
          <el-form-item label="课程名称" prop="courseName">
            <el-input v-model="formData.courseName"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="讲师名称" prop="teacherName">
            <el-input v-model="formData.teacherName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="辅导员名称" prop="teacher2Name">
            <el-input v-model="formData.teacher2Name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="就业指导" prop="teacher3Name">
            <el-input v-model="formData.teacher3Name"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="课程开始时间" prop="courseBegin">
            <el-date-picker type="date" v-model="formData.courseBegin" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="课程结束时间" prop="courseEnd">
            <el-date-picker v-model="formData.courseEnd" type="date" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="理论成绩" prop="llCourse">
            <el-input v-model="formData.llCourse" type="number"
                      placeholder="输入数字"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="技能成绩" prop="jnCourse">
            <el-input v-model="formData.jnCourse" type="number"
                      placeholder="输入数字"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="末班次数" prop="mbConut">
            <el-input v-model="formData.mbConut" type="number"
                      placeholder="输入数字"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="16">
          <el-form-item label="备注" prop="remark">
            <el-input v-model="formData.remark" type="textarea"
                      :autosize="{ minRows: 2, maxRows: 4}"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!--<el-form-item >-->
        <!--<el-input type="hidden" v-model="formData.studId"></el-input>-->
      <!--</el-form-item>-->
      <el-form-item>
        <el-button type="primary" @click="submitForm()">保存</el-button>
        <el-button @click="resetForm()">重置</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>

  import axios from 'axios'
  import selectStud from './../info/selectStud.vue'
  import {checkNumPot2,checkInterNum} from '@/utils/rules'
  export default {
    //属性，接收父页面传值
    props: ["addDialogIsShow"],
    data() {
      return {
        dialogIsShow: false,
        formData: {
          id: '',
          studId: '',
          studCode: '',
          studName: '',
          courseId: '',
          courseName: '',
          teacherId: '',
          teacherName: '',
          teacher2Id: '',
          teacher2Name: '',
          teacher3Id: '',
          teacher3Name: '',
          courseBegin: '',
          courseEnd: '',
          llCourse: '',
          jnCourse: '',
          mbConut: '',
          remark: ''
        },
        rules2: {
          llCourse: [{validator: checkNumPot2, trigger: 'blur'}],
          jnCourse: [{validator: checkNumPot2, trigger: 'blur'}],
          mbConut: [{validator: checkInterNum, trigger: 'blur'}]
        },

        addUrl: this.domain.serverpath + "/studLearn/add"
      }
    },
    methods: {
      submitForm() { //添加
        this.$refs.formData.validate((valid) => {
          if (!valid) {
            this.$message.error("请重新输入");
            return false;
          }else{
            //保存新增加的菜单数据
            let form1 = this.$data.formData;
            //获取查询参数，将参数解析成键值对
            let qs = require("qs");
            this.$axios.post(this.addUrl,
              qs.stringify(form1)).then((response)=> {
              this.dialogIsShow = false;
              this.resetForm();
              console.log(response.data.result);
            }).catch((error)=> {
              this.$message.error(""+error);
//          console.log(error);
            })
          }
        });
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
      },
      selectStudChangeHandle(option){
        this.formData.studName=option.name ;
        this.formData.studCode=option.code ;
        this.formData.studId=option.id ;
      }

    },
    watch: {
      addDialogIsShow: function () {  //监控父组件传过来的属性变化
        this.dialogIsShow = this.addDialogIsShow;
      }
    },
    components: {
      selectStud
    }
  }
</script>

<style>

</style>
