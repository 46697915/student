<template>
  <el-menu ref="emenu" default-active="2"
           class="el-menu-vertical-demo"
           :collapse="isCollapse"
           style="background-color:#EEF1F6;"
  >

    <el-submenu :title="getMenuName(m1.name)" v-for="(m1,mindex) in listMenu" :key="mindex"
                :index="getIndex(m1.code)">
      <template slot="title">
        <i v-if="m1.code==1" class="el-icon-setting"></i>
        <i v-else-if="m1.code==4" class="el-icon-goods"></i>
        <i v-else-if="m1.code==12" class="el-icon-sold-out"></i>
        <i v-else class="el-icon-search"></i>
        <span slot="title">{{m1.name}}</span>
      </template>

      <div v-for="(m2,m2Index) in m1.childMenu" :key="m2Index">
        <el-submenu v-if="m2.childMenu!=null&&m2.childMenu.length > 0"
                    :index="getIndex(m2.pcode)+'-'+getIndex(m2.code)">
          <span slot="title">{{m2.name}}</span>
          <el-menu-item @click="toforPath(m3.url)" v-for="(m3,m3Index) in m2.childMenu" :key="m3Index"
                        :index="getIndex(m2.pcode)+'-'+getIndex(m3.pcode)+'-'+getIndex(m3.code)">
            {{m3.name}}
          </el-menu-item>
        </el-submenu>
        <el-menu-item v-else @click="toforPath(m2.url)" :index="getIndex(m2.pcode)+'-'+getIndex(m2.code)">
          {{m2.name}}
        </el-menu-item>
      </div>
    </el-submenu>
  </el-menu>
</template>

<script>
  export default {
    name: "datamenu",
    data(){
      return {
        isCollapse: false,
        listMenu: [],
        wheight: window.innerHeight
      }
    },
    methods: {
      openClose(){
        if (this.$refs.emenu.collapse) {
          this.$data.isCollapse = false;
          //调用父组件的方法，更改变量值
          this.$emit("ee", false)
          //this.$refs.tip.content="点击关闭菜单";
        } else {
          this.$data.isCollapse = true;
          //调用父组件的方法，更改变量值
          this.$emit("ee", true)
          //this.$refs.tip.content="点击打开菜单";
        }
      },
      getIndex(index){
        return '' + index.toString();
      },
      getMenuName(menuName){
        return menuName;
      },
      toforPath(url){
        if (url != null) {
          //进入对应的路由
          this.$router.push({path: url})
        } else {
          this.$router.push({path: '/datamain/test'})
        }

      }

    },
    mounted(){
      this.$axios.post(this.domain.serverpath + "/sysMenu/listForMenu").then((reponse)=> {
        //为data中的listMenu赋值
        console.log(reponse.data.result);
        this.listMenu = reponse.data.result;
      }).catch((error)=> {
        console.log("===error===" + error.message);

      })
    }
  }
</script>

<style>

  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
</style>
