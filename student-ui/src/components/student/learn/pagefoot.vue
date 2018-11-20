<template>
  <el-pagination @size-change="handleSizeChange"
                 @current-change="handleCurrentPageChange"
                 :current-page="1"
                 :page-sizes="[10, 20, 30, 40]"
                 :page-size="10"
                 :total=total
                 layout="total, sizes, prev, pager, next, jumper"
                 >
  </el-pagination>
</template>

<script>
    export default {
        name: "pagefoot",
        props: ["total"],
        data(){
           return{
             pageNO:1,
             pageSize:10
           }
        },
        methods:{
          setPageData(total){//初始化page的配置，第一次加载页面的时候初始化配置，并获取pagefoot的初始化配置返回
              return {
                pageNO:this.$data.pageNO,
                pageSize:this.$data.pageSize
              }
          },
          handleSizeChange(evn){//当页面大小发生变化的时候调用父页面的toPage加载页面
             this.$data.pageSize=evn;
             //evn表示所选中的每页的显示条数
             this.$emit("pageChange",{pageNO:this.$data.pageNO,pageSize:this.$data.pageSize});
          },
          handleCurrentPageChange(currentPage){//当当前页发生变化的时候调用父页面的toPage加载页面
            //currentPage表示所选中的页码
            this.$data.pageNO=currentPage;
            this.$emit("pageChange",{pageNO:this.$data.pageNO,pageSize:this.$data.pageSize});
          }
        }
    }
</script>

<style scoped>

</style>
