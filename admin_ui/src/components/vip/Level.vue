<template>
	<div>
		<el-row>
			<el-button type="success" size="small" icon="el-icon-plus" @click="adddialog">添加等级</el-button>
		</el-row>

		<el-row style="margin-top: 10px;">
			<template>
				<el-table :data="viplevels" border style="width: 100%" size="mini">
					<el-table-column prop="name" label="等级名称"></el-table-column>
					<el-table-column prop="minlevel" label="最低等级"></el-table-column>
					<el-table-column prop="minmoney" label="最低消费" width="100"></el-table-column>
					<el-table-column prop="iconcolor" label="图标" align="center">
						<template slot-scope="scope">
							<i class="iconfont icon-icon_vip_01" :style="{color:scope.row.iconcolor}"></i>
						</template>

					</el-table-column>
					<el-table-column>
						<template slot-scope="scope">
							<el-button type="text" size="small" @click="editviplevel(scope.row)">编辑</el-button>
							<el-button type="text" size="small" @click="deleteviplevel(scope.row)">删除</el-button>
						</template>
					</el-table-column>
				</el-table>

				<el-dialog title="添加等级" :visible.sync="addDialogShow" width="80%">
					<el-form :model="levelForm" ref="levelForm" label-width="100px" size="medium">
						<el-row>
							<el-col :span="12">
								<el-form-item label="等级名称" prop="name">
									<el-input v-model="levelForm.name"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="12">
								<el-form-item label="最低等级" prop="minlevel">
									<el-input v-model="levelForm.minlevel"></el-input>
								</el-form-item>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="12">
								<el-form-item label="最低消费" prop="minmoney">
									<el-input v-model="levelForm.minmoney"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="6">
								<el-form-item label="图标颜色" prop="iconcolor">
									<el-color-picker v-model="levelForm.iconcolor"></el-color-picker>
								</el-form-item>
							</el-col>
							<el-col :span="6">
								<el-form-item label="图标" >
									<i class="iconfont icon-icon_vip_01" :style="{color:levelForm.iconcolor}"></i>
								</el-form-item>
							</el-col>
						</el-row>
						<el-form-item>
							<el-button type="primary" @click="submitForm('levelForm')">添加等级</el-button>
							<el-button @click="resetForm('levelForm')">重置信息</el-button>
						</el-form-item>
					</el-form>
				</el-dialog>
			</template>
		</el-row>
	</div>
</template>
<script>
	import axios from 'axios'
	export default {
		data() {
			return {
				levelForm:{
					name:"",
					minlevel:"",
					minmoney:"",
					iconcolor:"#666666"
				},
				addDialogShow:false,
				viplevels: []
			}
		},
		mounted() {
			var that = this;
			axios.get("/static/home/data.json")
				.then(response => { //请求正确
					that.viplevels = response.data.viplevels;
				}).catch(error => { //请求失败
					console.log(error)
				});
		},
		methods: {
			adddialog() {
				this.addDialogShow = true;
			},
			submitForm(form){
				this.addDialogShow = false;
			}
		}
	}
</script>

<style>

</style>