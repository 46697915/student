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
      <el-table-column prop="id" label="主键" width="55" v-if="false"></el-table-column>
      <el-table-column prop="studName" label="学生名" width="55" ></el-table-column>
      <el-table-column prop="comName" label="公司名称" width="100" ></el-table-column>
      <el-table-column prop="comAddress" label="工作地址" width="100" ></el-table-column>
      <el-table-column prop="workContent" label="工作内容" width="100" ></el-table-column>
      <el-table-column prop="inDate" label="入职日期" width="80" ></el-table-column>
      <el-table-column prop="outDate" label="离职日期" width="80" ></el-table-column>
      <el-table-column prop="linkMan" label="联系人" width="60" ></el-table-column>
      <el-table-column prop="comCity" label="所在城市" width="55" ></el-table-column>
      <el-table-column prop="workXz" label="工作性质" width="55" ></el-table-column>
      <el-table-column prop="workSshy" label="所属行业" width="55" ></el-table-column>
      <el-table-column prop="remarks" label="备注" width="100" ></el-table-column>
      <el-table-column prop="operator" label="录入人" width="80"  v-if="false"></el-table-column>
      <el-table-column prop="operatedate" label="录入日期" width="140" ></el-table-column>
      <el-table-column prop="studId" label="学生ID" width="55" ></el-table-column>
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
        queryUrl: this.domain.serverpath+"/studWork/listForPage",
        deleteUrl: this.domain.serverpath+"/studWork/deleteBatch",

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
