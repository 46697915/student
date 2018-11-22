<template>
  <el-row>
    <el-row>
      <el-col :span="24">
        <queryButton
          v-on:queryEvent="queryEvent">
        </queryButton>
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
        <el-table-column type="index" width="30"></el-table-column>
        <el-table-column fixed type="selection" width="30"></el-table-column>
        <el-table-column prop="id" label="主键" width="50" v-if="false"></el-table-column>
        <el-table-column prop="name" label="名称" width="100"></el-table-column>
        <el-table-column prop="code" label="学生编号" width="55"></el-table-column>
        <el-table-column prop="ic" label="身份信息" width="55"></el-table-column>
        <el-table-column prop="sex" label="性别" width="80"></el-table-column>
        <el-table-column prop="birthday" label="生日"></el-table-column>
        <el-table-column prop="xueli" label="学历"></el-table-column>
        <el-table-column prop="email" label="邮箱"></el-table-column>
        <el-table-column prop="hunfou" label="婚否"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
        <el-table-column prop="inschool" label="入学日期"></el-table-column>
        <el-table-column prop="shichangbu" label="市场部"></el-table-column>
        <el-table-column prop="remarks" label="备注"></el-table-column>
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
                     layout="total, jumper"
      >
      </el-pagination>
    </el-row>
  </el-row>
</template>

<script>

  import axios from 'axios'
  import queryButton from './queryButton.vue'

  export default {
    data() {
      return {
        listData: [],
        selectRows: [],
        listDataLoading: false, //加载框
        queryUrl: this.domain.serverpath + "/studentInfo/listForPage",

        //分页组件使用，总页数
        pageTotal: 0,
        pageNO: 1,
        pageSize: 10
      }
    },
    mounted() {
      this.listDataLoading = true;
      axios.get(this.queryUrl)
        .then(response => { //请求正确
          console.log(response);
          this.listData = response.data.result.list;
          this.pageTotal = response.data.result.total;
          this.listDataLoading = false;
        }).catch(error => { //请求失败
        console.log(error)
        this.listDataLoading = false;
      });
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
        if( val.length>0){
          let index = val.length-1;
          this.$emit("studSelectEvent",val[val.length-1]);
        }else{
          this.$emit("studSelectEvent",null);
        }
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
      queryButton
    },
    computed: {
      mapHeight() {
        return window.innerHeight - 210
      }
    }
  }
</script>

<style>

</style>
