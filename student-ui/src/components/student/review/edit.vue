<template>

  <!--窗口-->
  <el-dialog title="修改" :visible.sync="dialogIsShow" width="60%" @close="dialogClose">
    <el-form :model="formData" ref="formData" label-width="100px" size="medium">

      <el-row>
        <el-col :span="8">
          <el-form-item label="老师名称" prop="teacherName">
            <el-input v-model="formData.teacherName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="老师类型" prop="teacherType">
            <el-select v-model="formData.teacherType" placeholder="请选择">
              <el-option
                v-for="item in teacherTypeOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="学生名称" prop="studName">
            <selectStud v-model="formData.studName"
                        :selectStudValue="formData.studName"
                        @selectStudChange="selectStudChangeHandle"></selectStud>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="阶段名称" prop="courseName">
            <el-input v-model="formData.courseName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="阶段开始时间" prop="courseBegin">
            <el-date-picker type="date" v-model="formData.courseBegin" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="阶段结束时间" prop="courseEnd">
            <el-date-picker type="date" v-model="formData.courseEnd" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="技能等级" prop="skillLevel">
            <el-input v-model="formData.skillLevel"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="沟通等级" prop="gtLevel">
            <el-input v-model="formData.gtLevel"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="点评分数" prop="reviewScore">
            <el-input v-model="formData.reviewScore"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="点评内容" prop="reviewContent">
            <el-input v-model="formData.reviewContent"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="点评时间" prop="reviewDate">
            <el-date-picker type="date" v-model="formData.reviewDate" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="推荐方向" prop="tjFx">
            <el-input v-model="formData.tjFx"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="推荐公司类型" prop="tjCom">
            <el-input v-model="formData.tjCom"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="推荐岗位" prop="tjGw">
            <el-input v-model="formData.tjGw"></el-input>
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
          teacherName: '',
          teacherId: '',
          teacherType: '',
          studId: '',
          studName: '',
          courseId: '',
          courseName: '',
          courseBegin: '',
          courseEnd: '',
          skillLevel: '',
          gtLevel: '',
          reviewScore: '',
          reviewContent: '',
          reviewDate: '',
          tjFx: '',
          tjCom: '',
          tjGw: '',
          remark: ''
        },
        teacherTypeOptions: [
          {
            value: '讲师',
            label: '讲师'
          }, {
            value: '辅导员',
            label: '辅导员'
          }, {
            value: '就业指导',
            label: '就业指导'
          }
        ],

        editUrl: this.domain.serverpath + "/studReview/edit"
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
