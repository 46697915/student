<template>
	<div>
		<el-form :model="propForm" ref="propForm" label-width="100px">
			<el-form-item prop="yearage" label="年代">
				<el-autocomplete size="mini" v-model="propForm.yearage" :fetch-suggestions="autoYearage" clearable @select="doSelectYearAge">
					<el-button slot="append" class="iconfont icon-add" size="mini" @click="addYearage" style="background: #55A532;color: white;" type="success">添加</el-button>
				</el-autocomplete>
			</el-form-item>
			<el-form-item prop="type" label="类型">
				<el-autocomplete size="mini" v-model="propForm.type" :fetch-suggestions="autoType" clearable @select="doSelectType">
					<el-button slot="append" class="iconfont icon-add" size="mini" @click="addType" style="background: #55A532;color: white;" type="success">添加</el-button>
				</el-autocomplete>
			</el-form-item>
			<el-form-item prop="area" label="地区">
				<el-autocomplete label="name" size="mini" v-model="propForm.area" :fetch-suggestions="autoArea" clearable @select="doSelectArea">
					<el-button slot="append" class="iconfont icon-add" size="mini" @click="addArea" style="background: #55A532;color: white;" type="success">添加</el-button>
				</el-autocomplete>
			</el-form-item>
		</el-form>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				autoData: {
					ages: [{
							id: "1",
							name: "2018年"
						},
						{
							id: "2",
							name: "90年代"
						},
						{
							id: "3",
							name: "80年代"
						},
						{
							id: "4",
							name: "70年代"
						}
					],
					types: [{
						id: "1",
						name: "动作"
					}, {
						id: "2",
						name: "冒险"
					}],
					areas: [{
						id: "1",
						name: "中国大陆"
					}, {
						id: "2",
						name: "中国香港"
					}]
				},
				propForm: {
					yearage: "",
					type: "",
					area: ""
				}
			};
		},
		methods: {
			autoYearage(qryStr, cb) {
				var ages = this.autoData.ages;
				for(var i in ages) {
					//自动补全要求必须有value属性
					ages[i].value = ages[i].name;
				}
				var results = qryStr ? ages.filter(this.createStateFilter(qryStr)) : ages;
				clearTimeout(this.timeout);
				this.timeout = setTimeout(() => {
					cb(results);
				}, 1000 * Math.random());
			},
			createStateFilter(queryString) {
				return(state) => {
					return(state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
				};
			},
			doSelectYearAge(item) {
				console.log(item);
			},
			addYearage() {
				//添加年代
			},

			autoType(qryStr, cb) {
				var types = this.autoData.types;
				for(var i in types) {
					//自动补全要求必须有value属性
					types[i].value = types[i].name;
				}
				var results = qryStr ? types.filter(this.createStateFilter(qryStr)) : types;
				clearTimeout(this.timeout);
				this.timeout = setTimeout(() => {
					cb(results);
				}, 1000 * Math.random());
			},
			doSelectType(item) {
				console.log(item);
			},
			addType() {
				//添加类型
			},

			//地区
			autoArea(qryStr, cb) {
				var areas = this.autoData.areas;
				for(var i in areas) {
					//自动补全要求必须有value属性
					areas[i].value = areas[i].name;
				}
				var results = qryStr ? areas.filter(this.createStateFilter(qryStr)) : areas;
				clearTimeout(this.timeout);
				this.timeout = setTimeout(() => {
					cb(results);
				}, 1000 * Math.random());
			},
			doSelectArea(item) {
				console.log(item);
			},
			addArea() {
				//添加地区

			},
		}
	}
</script>

<style>

</style>