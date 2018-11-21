<template>
    <el-container style=" border: 0px solid #eee">
        <el-header style="height: 50px; text-align: left; font-size: 12px">
            <span>学生管理系统</span>
        </el-header>
        <el-container :style="{height: mapHeight+'px'}">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <sysMenu></sysMenu>
            </el-aside>
            <el-main style="text-align: left;">
              <router-view></router-view>
            </el-main>
        </el-container>
        <el-footer style="height: 20px;background: red;">
            <div></div>
        </el-footer>
    </el-container>
</template>
<script>
    import sysMenu from './menu.vue'

    export default {
        components: {
            sysMenu
        },
        computed: {
            mapHeight() {
                return window.innerHeight - 100
            }
        }
    };
</script>
<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>
