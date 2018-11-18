<template>
	<!--========左侧彩单树========-->
	<div>
		<el-menu :default-openeds="['1']">
			<el-menu default-active="2" class="el-menu-vertical-demo">
				<el-submenu  v-for=" (menu, idx) in menus" :index="idx+1+''">
					<template slot="title">
						<i :class="menu.menuIcon" style="margin-right: 10px;"></i><span>{{menu.name}}</span>
					</template>
					<el-menu-item-group>
						<el-menu-item v-for="(m,i) in menu.childrens" :index="idx+1+'-'+i" @click="changePage(m)">{{m.name}}</el-menu-item>
					</el-menu-item-group>
				</el-submenu>
			</el-menu>

			<!--<el-submenu v-for=" (menu, idx) in menus" :index="idx+1+''">
				<template slot="title">
					<i :class="menu.menuIcon"></i><span>{{menu.name}}</span>
					<el-menu-item-group>
						<template slot="title">分组一</template>
						<el-menu-item index="1-1">选项1</el-menu-item>
						<el-menu-item index="1-2">选项2</el-menu-item>
					</el-menu-item-group>
				</template>
			</el-submenu>-->
		</el-menu>
	</div>
</template>

<script>
	import axios from 'axios'
	export default {
		mounted() {
			var that = this;
			axios.get("/static/home/data.json")
				.then(response => { //请求正确
					console.log(response);
					console.log(response.menus)
					that.menus = response.data.menus;
				}).catch(error => { //请求失败
					console.log(error)
				});
		},
		data() {
			return {
				menus: []
			}
		},
		methods:{
			changePage:function(m){
				var pageUrl = m.pageUrl;
				if(pageUrl)
					this.$router.replace(pageUrl)
			}
		}
	}
</script>

<style>

</style>