<template>
  <div style="width:100%;height: 100%;">
    <el-container style="height: 100%" direction="vertical">
      <el-header style="text-align: right; font-size: 12px">
        <span style="font-size:25px;margin-right:80%;">
            信息管理平台
            <el-tooltip ref="tip" class="item" effect="dark"  placement="top-start" v-bind:content="mycontent">
              <i class="el-icon-menu" @click="openParentClose()"></i>
            </el-tooltip>
        </span>

        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>YYYY</span>
      </el-header>

      <el-container noresize:false>
        <!-- 左侧的菜单 -->
        <mymenu  ref="iiii" v-on:ee="updatePro"></mymenu>
        <!-- 右侧的主显示区域 -->
        <mymain style="padding:0px"></mymain>

      </el-container>
    </el-container>

  </div>
</template>

<script>
  import mymenu from './datamenu.vue'
  import mymain from './datamain.vue'
    export default {
      data(){
         return{
           mycontent:"点击打开菜单"
         }
      },
      components:{mymenu,mymain},
        name: "shouye",
      methods:{
        tttt(){
            alert("pppp999999");
        },
        openParentClose(){
           //调用子组件menu中的openClose()
           this.$refs.iiii.openClose();
        },
        updatePro(uu){
           if(uu){
             this.$data.content="点击打开菜单";
           }else{
             this.$data.content="点击关闭菜单";
           }
        }
      }
    }
</script>

<style scoped>
  .el-header {
    background-color: #409EFF;
    color: #333;
    line-height:60px;

  }

  .el-aside {
    color: #333;
    height: 100%;
  }


</style>
