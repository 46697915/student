<template>
  <!--========list页面及分页========-->
  <el-row>
    <toolbar ref="toolbar"
             :selectRows=selectRows
             v-on:toolbarEvent="toolbarEventHandle"></toolbar>
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
    <page ref="page" :total=pageTotal @pageChange="pageChange" ></page>
  </el-row>

</template>

<script>
  import axios from 'axios'
  import toolbar from './toolbar.vue'
  import page from './pagefoot.vue';

  export default {
    data() {
      return {
        listData: [],
        selectRows: [],
        listDataLoading: false, //加载框
        queryUrl: this.domain.serverpath+"/studInterview/listForPage",
        deleteUrl: this.domain.serverpath+"/studInterview/deleteBatch",

        //分页组件使用，总页数
        pageTotal: 0
      }
    },
    mounted() {
      this.listDataLoading = true ;
      axios.get(this.queryUrl)
        .then(response => { //请求正确
          console.log(response);
          this.listData = response.data.result.list;
          this.pageTotal = response.data.result.total;
          this.listDataLoading = false ;
        }).catch(error => { //请求失败
        //console.log(error)
        this.listDataLoading = false ;
      });
    },
    methods: {
      //查询
      toolbarEventHandle(eventType,param){ //点击查询返回数据后
        if("query"==eventType){
          this.queryToServier();
        }
        if("toEdit"==eventType){
          this.toEdit();
        }
        if("edit"==eventType){
          this.toEdit();
        }
        if("delete"==eventType){
          this.deleteToserver();
        }
      },
      //具体和后台交互请求方法，
      queryToServier(){
        //获取查询参数
        let qs=require("qs");
        let param = this.$refs.toolbar.$data.queryFormData;
        this.$set(param,"pageNO",this.$refs.page.$data.pageNO );
        this.$set(param,"pageSize",this.$refs.page.$data.pageSize );
        param =  qs.stringify(param);
        console.log(param);
        this.listDataLoading = true ;
        this.$axios.post(this.queryUrl,param)
          .then((response)=>{
            this.listData=response.data.result.list
            //引用组件的话在引用组件的父页面调用子组件的方法
            this.pageTotal = response.data.result.total;
            this.listDataLoading = false ;
          }).catch((error)=>{
          this.listDataLoading = false ;

        })
      },
      toEdit(){
        let datas = this.$data.selectRows;
        if (datas.length == 0) {
          alert("请选择要删除的数据");
        } else {
          console.log('deleteHandle!'+ids);
          this.$axios.delete(this.deleteUrl,{  //params参数必写 , 如果没有参数传{}也可以
            params: {
              ids: ids
            }
          })
            .then((response)=>{
              this.queryToServier();
            })
            .catch((error)=>{
              this.queryToServier();
            });
        }
      },
      deleteToserver(){
        let datas = this.$data.selectRows;
        let ids = ''
        for(var a in datas){
          if (ids == '') {
            ids = datas[a].id;
          }else {
            ids = ids + ',' + datas[a].id;
          }
        }
        if (ids == '') {
          alert("请选择要删除的数据");
        } else {
          console.log('deleteHandle!'+ids);
          this.$axios.delete(this.deleteUrl,{  //params参数必写 , 如果没有参数传{}也可以
              params: {
                ids: ids
              }
            })
            .then((response)=>{
              this.queryToServier();
            })
            .catch((error)=>{
              this.queryToServier();
            });
        }
      },
      //选中行
      handleSelectionChange(val) {
        console.log(val); //被选中的行，就是要被删除的行
        this.selectRows = val;
      },
      pageChange(page){//选页码的时候的操作/改变每页显示的条数的时候触发
        this.queryToServier();
      }
    },
    components: {
      toolbar,page
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
