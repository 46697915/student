<template>
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
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="性别">
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
</template>

<script>

  export default {
    //父组件传过来的值
    props: ["selectRows"],
    data() {
      return {
        queryDialogIsShow: false,  //查询对话框是否显示
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
      queryForm(data) { //查询
        //保存新增加的菜单数据
        let form1 = this.$data.queryFormData;
        //获取查询参数，将参数解析成键值对
        let qs = require("qs");
//        let param =  qs.stringify(form1);
//        console.log(param);
        this.$emit("queryEvent",form1);
        this.queryDialogIsShow = false ;
      },
      resetQueryForm() { //重置
        let datas = this.$data.queryFormData;
        for(var a in datas){
          datas[a] = '';
        }
        this.inschoolRange='';  //入学日期范围
      }
    }
  }
</script>

<style>

</style>
