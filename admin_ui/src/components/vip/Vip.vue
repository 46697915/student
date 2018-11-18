<template>

	<div>
		<el-row style="margin-top: 10px;">
			<template>
				<el-table :data="vips" border style="width: 100%" size="mini">
					<el-table-column prop="name" label="等级名称"></el-table-column>
					<el-table-column prop="level" label="用户等级"></el-table-column>
					<el-table-column prop="levelname" label="等级名称"></el-table-column>
					<el-table-column prop="money" label="消费金额"></el-table-column>
					<el-table-column prop="account" label="账户余额" width="100"></el-table-column>
					<el-table-column>
						<template slot-scope="scope">
							<el-button type="text" size="small" @click="deletevip(scope.row)">移除会员</el-button>
						</template>
					</el-table-column>
				</el-table>
			</template>
		</el-row>
	</div>
</template>

<script>
	import axios from 'axios'
	export default{
		data(){
			return {
				vips:[]
			}
		},
		mounted(){
			var that = this;
			axios.get("/static/home/data.json")
				.then(response => { //请求正确
					that.vips = response.data.vips;
				}).catch(error => { //请求失败
					console.log(error)
				});	
		},
		methods:{
			deletevip(){
				
			}
		}
	}
</script>

<style>

</style>