<template>
	
	<!--========主页面========-->
	
	<div>
		<el-container :style="{ height:clientheight+'px'}" style=" border: 1px solid #eee">
			<el-container>
				<el-header style="text-align: right; font-size: 12px">
					<el-dropdown>
						<i class="el-icon-setting" style="margin-right:5px;font-size: 14px;"></i>
						<el-dropdown-menu slot="dropdown">
							<el-dropdown-item>个人信息</el-dropdown-item>
							<el-dropdown-item>重置密码</el-dropdown-item>
							<el-dropdown-item>退出</el-dropdown-item>
						</el-dropdown-menu>
					</el-dropdown>
					<span>刘兴</span>
				</el-header>
				<el-container>
					<el-aside width="200px" style="background-color: rgb(238, 241, 246)">
						<Menu/>
					</el-aside>

					<el-container>
						<el-main style="text-align: left;">
							<router-view></router-view>
						</el-main>
					</el-container>
				</el-container>
			</el-container>
		</el-container>

	</div>
</template>

<script>
	import Menu from './Menu'

	export default {
		components: {
			Menu
		},
		data() {
			return {
				clientheight: 0
			}
		},
		mounted() {
			// 获取浏览器可视区域高度
			this.clientheight = `${document.documentElement.clientHeight}` //document.body.clientWidth;
			var that = this;
			window.onresize = function temp() {
				that.clientheight = `${document.documentElement.clientHeight}`;
			};
		}
	}
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