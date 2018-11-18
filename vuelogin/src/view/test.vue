<template>
   <div @contextmenu="showMenu">
     <div>
       <el-form :inline="true" :style="{'margin-top':15+'px'}" style="margin-top: " :model="formInline" class="demo-form-inline">
         <el-form-item label="审批人">
           <el-input v-model="formInline.user" placeholder="审批人"></el-input>
         </el-form-item>
         <el-form-item label="活动区域">
           <el-select v-model="formInline.region" placeholder="活动区域">
             <el-option label="区域一" value="shanghai"></el-option>
             <el-option label="区域二" value="beijing"></el-option>
           </el-select>
         </el-form-item>
         <el-form-item>
           <el-button type="primary" >查询</el-button>
         </el-form-item>
       </el-form>
     </div>
      <div>
         <el-table :data="tableData">
           <el-table-column fixed prop="id" label="日期" width="140">
           </el-table-column>
           <el-table-column prop="menuName" label="姓名" width="120">
           </el-table-column>
           <el-table-column prop="parentMenuId" label="地址">
           </el-table-column>
         </el-table>
      </div>
     <page ref="page" total="100" @toPage="toPage" ></page>
   </div>
</template>

<script>

    import page from './pagefoot.vue';
    export default {
      components:{
        page
      },
      name: "test",
      data() {
        return {
          tableData:[],
          total:0,
          pageNo:1,
          pageSize:10,
          formInline: {
            user: '',
            region: ''
          }
        }

      },
        methods:{
          test:function(){
            console.log("---消息总线---1")
            this.$eventBus.$on('',function(){
              console.log("===>"+key);  // data-1232131232132131232
            });

          },
          toPage(page){//选页码的时候的操作/改变每页显示的条数的时候触发
               //获取查询参数
               let qs=require("qs");
               this.$axios.post(this.domain.serverpath+"/menu/menuList",qs.stringify(page)).then((response)=>{
                    this.$data.tableData=response.data.result.resultList
                    //给父页面赋值
                    //引用组件的话在引用组件的父页面调用子组件的方法
                    this.$refs.page.setPageData(response.data.result.totalCount)
               }).catch((error)=>{

               })
          },
          showMenu(){
            alert("---右键显示---")
          }
        },
        mounted(){
            //设置分页参数，参数一表示总页数
          //获取查询参数
          let page={pageNo:1,pageSize:10};
          let qs=require("qs");
          this.$axios.post(this.domain.serverpath+"/menu/menuList",qs.stringify(page)).then((response)=>{
               this.$data.tableData=response.data.result.resultList
               //给父页面赋值
               this.$refs.page.setPageData(response.data.result.totalCount)
          }).catch((error)=>{

          })

        }
    }


</script>

<style scoped>

</style>
