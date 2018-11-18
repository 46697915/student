<template>
	<!--========影院管理页面========-->
	<div>
		<el-row>
			<el-row>
				<!--影片查询-->
				<el-popover placement="top-start" width="80%" trigger="click" v-model="queryDialogShow">
					<el-form :model="queryCinema" ref="queryCinema" label-width="100px" size="medium">
						<el-row>
							<el-col :span="12">
								<el-form-item label="影院名称" prop="name">
									<el-input v-model="queryCinema.name" placeholder="请输入影院名"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="12">
								<el-form-item label="影院地址" prop="address">
									<el-form-item prop="address">
										<el-input v-model="queryCinema.address" placeholder="请输入影院地址"></el-input>
									</el-form-item>
								</el-form-item>
							</el-col>
						</el-row>
						<el-form-item>
							<el-button type="primary" @click="doquery('queryFilm')">查询影院</el-button>
							<el-button @click="resetForm('queryFilm')">重置查询</el-button>
						</el-form-item>
					</el-form>
					<el-button slot="reference" type="primary" size="small" icon="el-icon-search">查询影片</el-button>
				</el-popover>
				<!--<el-button type="success" size="small" icon="el-icon-plus" @click="adddialog">添加影片</el-button>
			<el-button type="danger" size="small" icon="el-icon-delete" @click="deletefilms">删除影片</el-button>-->
			</el-row>

		</el-row>
		<el-row style="margin-top: 10px;">
			<template>
				<el-table :data="cinemas" border style="width: 100%" size="mini" @selection-change="handleSelectionChange">
					<el-table-column type="selection" width="55"></el-table-column>
					<el-table-column prop="name" label="影院名称"></el-table-column>
					<el-table-column prop="address" label="影院地址"></el-table-column>
					<el-table-column prop="status" label="状态" :formatter="formatCinemaStatus"></el-table-column>
					<el-table-column label="操作" width="150">
						<template slot-scope="scope">
							<el-button @click="detaildialog(scope.row)" type="text" size="small">详情</el-button>
							<template v-if="scope.row.status==1">
								<el-button type="text" size="small" @click="unplay(scope.row)">禁播</el-button>
							</template>
							<template v-else>
								<el-button type="text" size="small" disabled>禁播</el-button>
							</template>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="1" :page-sizes="[10, 20, 30, 40]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="400">
				</el-pagination>
				<el-row style="margin-bottom: 10px;">
					<el-col :span="3" style="text-align: left;">
						请输入地址：
					</el-col>
					<el-col :span="6">
						<el-input v-model="searchaddress" id="searchaddress" size="mini" placeholder="请输入"></el-input>
					</el-col>
				</el-row>
				<div class="baidumap" id="allmap" style="width: 50%; height: 300px;"></div>

			</template>
		</el-row>
	</div>
</template>
<script>
	import axios from 'axios'
	import BMap from 'BMap'
	import BMapSymbolSHAPEPOINT from 'BMap_Symbol_SHAPE_POINT'
	export default {
		data() {
			return {
				cinemas: [],
				searchaddress: '', //搜索的地址，
				queryDialogShow: false,
				queryCinema: {
					name: '',
					address: ''
				}
			}
		},
		mounted() {
			var that = this;
			axios.get("/static/home/data.json")
				.then(response => { //请求正确
					console.log(response)
					that.cinemas = response.data.cinemas;
				}).catch(error => { //请求失败
					console.log(error)
				});
			this.baiduMap();
		},
		methods: {
			//百度地图
			baiduMap() {
				var map = new BMap.Map('allmap')
				var point = new BMap.Point(111.742579, 40.818675)
				map.centerAndZoom(point, 12)
				var marker = new BMap.Marker(point) // 创建标注
				map.addOverlay(marker) // 将标注添加到地图中
				map.enableScrollWheelZoom(true);

				//智能搜索
				var ac = new BMap.Autocomplete({
					"input": "searchaddress",
					"location": map
				});
				var myValue;
				ac.addEventListener("onconfirm", function(e) { //鼠标点击下拉列表后的事件
					var _value = e.item.value;
					myValue = _value.province + _value.city + _value.district + _value.street + _value.business;
					setPlace();
				});
				//修改地址
				function setPlace() {
					map.clearOverlays(); //清除地图上所有覆盖物
					function myFun() {
						var pp = local.getResults().getPoi(0).point; //获取第一个智能搜索的结果
						map.centerAndZoom(pp, 12);
						map.addOverlay(new BMap.Marker(pp)); //添加标注
					}
					var local = new BMap.LocalSearch(map, { //智能搜索
						onSearchComplete: myFun
					});
					local.search(myValue);
				}
			},

			//查询
			doquery(form) {
				this.queryDialogShow = false;
				console.log(this.queryCinema);
			},

			//格式化电影状态
			formatCinemaStatus(row, column) {
				if(row.status == 1)
					return "正在营业";
				else if(row.status == 2)
					return "停止营业";
			},

			//分页
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				//更改了每页显示条数，去后台查询
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				//更改了当前要显示第几页
			},

			//选中行
			handleSelectionChange(val) {
				console.log(val); //被选中的行，就是要被删除的行
				this.selectFilms = val;
			},
		}
	}
</script>
<style>
</style>