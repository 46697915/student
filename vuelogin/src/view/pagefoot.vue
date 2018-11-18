<template>
  <el-pagination
    background
    layout="sizes,prev, pager, next"
    :page-sizes="[10, 20, 30, 40]"
    :page-size="10"
    :total=total
    @size-change="pageSizeChange"
    @current-change="currentPageChange"
    >
  </el-pagination>
</template>

<script>
    export default {
        name: "pagefoot",
        data(){
           return{
             total:0,
             pageNo:1,
             pageSize:10
           }
        },
        methods:{
          setPageData(total){//初始化page的配置，第一次加载页面的时候初始化配置，并获取pagefoot的初始化配置返回
              this.$data.total=total
              return {pageNo:this.$data.pageNo,pageSize:this.$data.pageSize}
          },
          pageSizeChange(evn){//当页面大小发生变化的时候调用父页面的toPage加载页面
             this.$data.pageSize=evn;
             //evn表示所选中的每页的显示条数
             this.$emit("toPage",{pageNo:this.$data.pageNo,pageSize:this.$data.pageSize});
          },
          currentPageChange(currentPage){//当当前页发生变化的时候调用父页面的toPage加载页面
            //currentPage表示所选中的页码
            this.$data.pageNo=currentPage;
            this.$emit("toPage",{pageNo:this.$data.pageNo,pageSize:this.$data.pageSize});
          }
        }
    }
</script>

<style scoped>

</style>
