<template>
  <el-row>
    <el-row>
      <el-col :span="24">
      </el-col>
    </el-row>
    <el-row>
      <el-table :data="listData" border style="width: 100%;"
                :height=mapHeight
                stripe
                size="mini"
                v-loading="listDataLoading"
                element-loading-text="拼命加载中"
                element-loading-spinner="el-icon-loading"
                element-loading-background="rgba(0, 0, 0, 0.5)"
                @selection-change="handleSelectionChange">
        <el-table-column type="index" label="序号" width="50"> </el-table-column>
        <el-table-column fixed type="selection" width="55"></el-table-column>
        <el-table-column prop="id" label="ID" width="80" ></el-table-column>
        <el-table-column prop="studName" label="学生名称" width="80" ></el-table-column>
        <el-table-column prop="comName" label="公司名称" width="80" ></el-table-column>
        <el-table-column prop="comXz" label="公司性质" width="80" ></el-table-column>
        <el-table-column prop="comAdress" label="公司地址" width="80" ></el-table-column>
        <el-table-column prop="interviewGw" label="面试岗位" width="80" ></el-table-column>
        <el-table-column prop="comGm" label="公司规模" width="80" ></el-table-column>
        <el-table-column prop="zpGm" label="招聘规模" width="80" ></el-table-column>
        <el-table-column prop="interviewDate" label="面试日期" width="80" ></el-table-column>
        <el-table-column prop="interviewLc" label="面试轮次" width="80" ></el-table-column>
        <el-table-column prop="interviewComment" label="面试情况" width="80" ></el-table-column>
        <el-table-column prop="linkMail" label="联系邮件" width="80" ></el-table-column>
        <el-table-column prop="linkPhone" label="联系电话" width="80" ></el-table-column>
        <el-table-column prop="isChannel" label="是否渠道" width="80" ></el-table-column>
        <el-table-column prop="channelManager" label="渠道负责人" width="80" ></el-table-column>
        <el-table-column prop="resume" label="投递简历" width="80" ></el-table-column>
        <el-table-column prop="passingDifficulty" label="通过难度" width="80" ></el-table-column>
        <el-table-column prop="isRecommend" label="是否推荐" width="80" ></el-table-column>
        <el-table-column prop="isWritten" label="是否有笔试" width="80" ></el-table-column>
        <el-table-column prop="remark" label="备注" width="80" ></el-table-column>
        <el-table-column prop="studId" label="学生id" width="80" ></el-table-column>

        <el-table-column label="操作" width="150">
          <template slot-scope="scope">
            <!--<el-button @click="detaildialog(scope.row)" type="text" size="small">详情</el-button>-->
            <!--<el-button type="text" size="small" @click="editdialog(scope.row)">编辑</el-button>-->
            <!--<el-button type="text" size="small" @click="unplay(scope.row)">下架</el-button>-->
          </template>
        </el-table-column>
      </el-table>
      <el-pagination @size-change="handleSizeChange"
                     @current-change="handleCurrentPageChange"
                     :current-page="1"
                     :page-sizes="[10, 20, 30, 40]"
                     :page-size="10"
                     :total=pageTotal
                     layout="total, sizes, prev, pager, next, jumper"
      >
      </el-pagination>
    </el-row>
  </el-row>
</template>

<script>

  import axios from 'axios'

  export default {
    props: ["selectStudRow"],
    data() {
      return {
        listData: [],
        selectRows: [],
        studId: '',
        listDataLoading: false, //加载框
        queryUrl: this.domain.serverpath + "/studInterview/listForPage",

        //分页组件使用，总页数
        pageTotal: 0,
        pageNO: 1,
        pageSize: 10
      }
    },
    mounted() {
//      this.listDataLoading = true;
//      axios.get(this.queryUrl)
//        .then(response => { //请求正确
//          console.log(response);
//          this.listData = response.data.result.list;
//          this.pageTotal = response.data.result.total;
//          this.listDataLoading = false;
//        }).catch(error => { //请求失败
//        console.log(error)
//        this.listDataLoading = false;
//      });
    },
    methods: {
      //具体和后台交互请求方法，
      queryToServier(param){
        //获取查询参数
        let qs = require("qs");
        this.$set(param, "pageNO", this.$data.pageNO);
        this.$set(param, "pageSize", this.$data.pageSize);
        param = qs.stringify(param);
        console.log(param);
        this.listDataLoading = true;
        this.$axios.post(this.queryUrl, param)
          .then((response)=> {
            this.listData = response.data.result.list
            //引用组件的话在引用组件的父页面调用子组件的方法
            this.pageTotal = response.data.result.total;
            this.listDataLoading = false;
          }).catch((error)=> {
          this.$message.error("" + error);
          this.listDataLoading = false;
        })
      },
      queryEvent(param){

        this.queryToServier(param);
      },
      //选中行
      handleSelectionChange(val) {
        console.log(val); //被选中的行，就是要被删除的行
        this.selectRows = val;
      },
      setPageData(total){//初始化page的配置，第一次加载页面的时候初始化配置，并获取pagefoot的初始化配置返回
        return {
          pageNO: this.$data.pageNO,
          pageSize: this.$data.pageSize
        }
      },
      handleSizeChange(evn){//当页面大小发生变化的时候调用父页面的toPage加载页面
        this.$data.pageSize = evn;
        //evn表示所选中的每页的显示条数
        this.queryToServier("");
      },
      handleCurrentPageChange(currentPage){//当当前页发生变化的时候调用父页面的toPage加载页面
        //currentPage表示所选中的页码
        this.$data.pageNO = currentPage;
        this.queryToServier("");
      }
    },
    components: {
    },
    watch: {
      selectStudRow: function () {  //监控父组件传过来的属性变化
//        this.selectedValue = this.selectStudValue;

        let  param = {};
        if(this.selectStudRow){
          param.studId = this.selectStudRow.id ;
          this.queryToServier(param);
        }else{
          this.listData = [];
          //引用组件的话在引用组件的父页面调用子组件的方法
          this.pageTotal = 0;
        }

      }
    },
    computed: {
      mapHeight() {
        return window.innerHeight - 270
      }
    }
  }
</script>

<style>

</style>
