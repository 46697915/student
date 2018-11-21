<template>

  <!--窗口-->
  <el-dialog title="添加" :visible.sync="dialogIsShow" width="60%" @close="dialogClose">
    <el-form :model="formData" ref="formData" label-width="100px" size="medium">

      <el-row>
        <el-col :span="8">
          <el-form-item label="学生名称" prop="studName">
            <selectStud v-model="formData.studName"
                        :selectStudValue="formData.studName"
                        @selectStudChange="selectStudChangeHandle"></selectStud>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="面试公司" prop="comName">
            <el-input v-model="formData.comName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="公司性质" prop="comXz">
            <el-input v-model="formData.comXz"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="公司地址" prop="comAdress">
            <el-input v-model="formData.comAdress"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="面试岗位" prop="interviewGw">
            <el-input v-model="formData.interviewGw"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="公司规模" prop="comGm">
            <el-input v-model="formData.comGm"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="招聘规模" prop="zpGm">
            <el-input v-model="formData.zpGm"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="面试时间" prop="interviewDate">
            <el-date-picker type="date" v-model="formData.interviewDate" style="width: 100%;"
                            format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="面试轮次" prop="interviewLc">
            <el-input v-model="formData.interviewLc"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="面试情况" prop="interviewComment">
            <el-input v-model="formData.interviewComment"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="联系人" prop="linkMail">
            <el-input v-model="formData.linkMail"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="联系电话" prop="linkPhone">
            <el-input v-model="formData.linkPhone"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="是否渠道" prop="isChannel">
            <el-select v-model="formData.isChannel" placeholder="请选择">
              <el-option
                v-for="item in isNoOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="渠道负责人" prop="channelManager">
            <el-input v-model="formData.channelManager"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="投递简历" prop="resume">
            <el-input v-model="formData.resume"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="通过难度" prop="passingDifficulty">
            <el-input v-model="formData.passingDifficulty"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="是否推荐" prop="isRecommend">
            <el-select v-model="formData.isRecommend" placeholder="请选择">
              <el-option
                v-for="item in isNoOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="是否有笔试" prop="isWritten">
            <el-select v-model="formData.isWritten" placeholder="请选择">
              <el-option
                v-for="item in isNoOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
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
  export default {
    //属性，接收父页面传值
    props: ["addDialogIsShow"],
    data() {
      return {
        dialogIsShow: false,
        formData: {
          id: '',
          studId: '',
          studName: '',
          comName: '',
          comXz: '',
          comAdress: '',
          interviewGw: '',
          comGm: '',
          zpGm: '',
          interviewDate: '',
          interviewLc: '',
          interviewComment: '',
          linkMail: '',
          linkPhone: '',
          isChannel: '',
          channelManager: '',
          resume: '',
          passingDifficulty: '',
          isRecommend: '',
          isWritten: '',
          remark: ''
        },
        isNoOptions: [
          {
            value: '是',
            label: '是'
          }, {
            value: '否',
            label: '否'
          }
        ],

        addUrl: this.domain.serverpath + "/studInterview/add"
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
          this.dialogIsShow = false;
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
      },
      selectStudChangeHandle(option){
        this.formData.studName=option.name ;
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
