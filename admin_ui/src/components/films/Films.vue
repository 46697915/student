<template>
	<!--========影片管理页面========-->
	<div>
		<!--上面显示按钮-->
		<el-row >
			<!--影片查询-->
			<el-popover placement="top-start" width="80%" trigger="click" v-model="queryDialogShow">
				<el-form :model="queryFilm" ref="queryFilm" label-width="100px" size="medium">
					<el-row>
						<el-col :span="12">
							<el-form-item label="影片名称" prop="name">
								<el-input v-model="queryFilm.name"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="上映时间" prop="date">
								<el-form-item prop="date">
									<el-date-picker style="width: 100%;" v-model="queryFilm.date" type="daterange" align="right" unlink-panels range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" :picker-options="queryDatePicker">
									</el-date-picker>
								</el-form-item>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="12">
							<el-form-item label="导演" prop="leader">
								<el-input v-model="queryFilm.leader"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="价格" prop="price">
								<el-col :span="11">
									<el-input v-model="queryFilm.minprice" placeholder="最低价" :span="10"></el-input>
								</el-col>
								<el-col :span="2" style="text-align: center;">
									-
								</el-col>
								<el-col :span="11">
									<el-input v-model="queryFilm.maxprice" placeholder="最高价" :span="10"></el-input>
								</el-col>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="12">
							<el-form-item label="电影年代" prop="yearage">
								<!--<el-input v-model="queryFilm.yearage"></el-input>-->
								<el-select v-model="queryFilm.yearage" placeholder="请选择年代" style="width: 100%;">
									<el-option v-for="item in yearageoptions" :key="item.id" :label="item.name" :value="item.id">
									</el-option>
								</el-select>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="电影时长" prop="time">
								<el-col :span="11">
									<el-input v-model="queryFilm.mintime" placeholder="最短时间"></el-input>
								</el-col>
								<el-col :span="2" style="text-align: center;">
									-
								</el-col>
								<el-col :span="11">
									<el-input v-model="queryFilm.maxtime" placeholder="最长时间"></el-input>
								</el-col>
							</el-form-item>
						</el-col>
					</el-row>
					<el-form-item>
						<el-button type="primary" @click="doquery('queryFilm')">查询影片</el-button>
						<el-button @click="resetForm('queryFilm')">重置查询</el-button>
					</el-form-item>
				</el-form>
				<el-button slot="reference" type="primary" size="small" icon="el-icon-search">查询影片</el-button>
			</el-popover>
			<el-button type="success" size="small" icon="el-icon-plus" @click="adddialog">添加影片</el-button>
			<el-button type="danger" size="small" icon="el-icon-delete" @click="deletefilms">删除影片</el-button>
		</el-row>
		<!--下面默认显示列表，点击按钮后显示对应内容-->
		<el-row style="margin-top: 10px;">
			<template>
				<el-table :data="films" border style="width: 100%" size="mini" @selection-change="handleSelectionChange">
					<el-table-column type="selection" width="55"></el-table-column>
					<el-table-column prop="name" label="影片名"></el-table-column>
					<el-table-column prop="leader" label="导演"></el-table-column>
					<el-table-column prop="price" label="票价" width="50"></el-table-column>
					<el-table-column prop="date" label="上映时间"></el-table-column>
					<el-table-column prop="time" label="时长" width="50"></el-table-column>
					<el-table-column prop="type" label="类型"></el-table-column>
					<el-table-column prop="yearage" label="年代" sortable></el-table-column>
					<el-table-column prop="area" label="区域"></el-table-column>
					<el-table-column prop="status" label="状态" :formatter="formatstatus"></el-table-column>
					<el-table-column label="操作" width="150">
						<template slot-scope="scope">
							<el-button @click="detaildialog(scope.row)" type="text" size="small">详情</el-button>
							<el-button type="text" size="small" @click="editdialog(scope.row)">编辑</el-button>
							<el-button type="text" size="small" @click="unplay(scope.row)">下架</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="1" :page-sizes="[10, 20, 30, 40]" :page-size="100" layout="total, sizes, prev, pager, next, jumper" :total="400">
				</el-pagination>

				<!--添加影片窗口-->
				<el-dialog title="添加影片" :visible.sync="addDialogShow" width="80%">
					<el-form :model="filmData" :rules="rules" ref="filmData" label-width="100px" size="medium">
						<el-row>
							<el-col :span="12">
								<el-form-item label="影片名称" prop="name">
									<el-input v-model="filmData.name"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="12">
								<el-form-item label="上映时间" prop="date" required>
									<el-form-item prop="date">
										<el-date-picker type="date" placeholder="选择日期" v-model="filmData.date" style="width: 100%;"></el-date-picker>
									</el-form-item>
								</el-form-item>
							</el-col>

						</el-row>
						<el-row>
							<el-col :span="12">
								<el-form-item label="导演" prop="leader">
									<el-input v-model="filmData.leader"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="12">
								<el-form-item label="价格" prop="price">
									<el-input v-model="filmData.price"></el-input>
								</el-form-item>
							</el-col>
						</el-row>

						<el-row>
							<el-col :span="12">
								<el-form-item label="电影年代" prop="yearage">
									<el-input v-model="filmData.yearage"></el-input>
								</el-form-item>
							</el-col>
							<el-col :span="12">
								<el-form-item label="电影时长" prop="time">
									<el-input v-model="filmData.time" placeholder="单位是分钟"></el-input>
								</el-form-item>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="12">
								<el-form-item label="电影类型" prop="type">
									<el-select v-model="filmData.type" placeholder="请选择类型" style="width: 100%;">
										<el-option v-for="item in filmtypes" :key="item.id" :label="item.name" :value="item.id">
										</el-option>
									</el-select>
								</el-form-item>
							</el-col>
							<el-col :span="12">
								<el-form-item label="电影地区" prop="area">
									<el-select v-model="filmData.area" placeholder="请选择地区" style="width: 100%;">
										<el-option v-for="item in filmareas" :key="item.id" :label="item.name" :value="item.id">
										</el-option>
									</el-select>
								</el-form-item>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="12">
								<el-form-item label="主演" prop="mainplayers">
									<el-input v-model="filmData.mainplayers"></el-input>
								</el-form-item>
							</el-col>
						</el-row>
						<el-row>
							<el-form-item label="演员表" prop="players">
								<el-input v-model="filmData.players" type="textarea"></el-input>
							</el-form-item>
						</el-row>

						<el-row>
							<el-form-item label="电影描述" prop="describle">
								<el-input v-model="filmData.describle" type="textarea"></el-input>
							</el-form-item>
						</el-row>

						<el-row>
							<el-form-item label="电影海报" prop="poster">
								<el-upload class="avatar-uploader" action="/img/poster" name="poster" :show-file-list="false" :on-success="handlePosterSuccess" :before-upload="beforePosterUpload">
									<img v-if="imageUrl" :src="imageUrl" class="avatar">
									<i v-else class="el-icon-plus avatar-uploader-icon"></i>
								</el-upload>
							</el-form-item>
						</el-row>

						<el-row>
							<el-form-item label="电影图集" prop="pics">
								<el-upload action="/img/poster" list-type="picture-card" :on-preview="showPic" :on-remove="removePic">
									<i class="el-icon-plus"></i>
								</el-upload>
							</el-form-item>
						</el-row>

						<el-form-item>
							<el-button type="primary" @click="submitForm('filmData')">添加影片</el-button>
							<el-button @click="resetForm('filmData')">重置信息</el-button>
						</el-form-item>
					</el-form>
				</el-dialog>

				<!--点击已选图片放大按钮后效果-->
				<el-dialog :visible.sync="showPicVisible">
					<img width="100%" :src="picUrl" alt="">
				</el-dialog>

				<!--影片详情-->
				<el-dialog title="影片详情" :visible.sync="detailDialogShow" width="80%">
					<el-form :model="filmData" ref="filmData" label-width="100px" size="medium">
						<el-row>
							<el-col :span="12">
								<el-form-item label="影片名称:" prop="name">
									{{filmData.name}}
								</el-form-item>
							</el-col>
							<el-col :span="12">
								<el-form-item label="上映时间:" prop="date">
									{{filmData.date}}
								</el-form-item>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="12">
								<el-form-item label="导演:" prop="leader">
									{{filmData.leader}}
								</el-form-item>
							</el-col>
							<el-col :span="12">
								<el-form-item label="价格:" prop="price">
									{{filmData.price}}
								</el-form-item>
							</el-col>
						</el-row>

						<el-row>
							<el-col :span="12">
								<el-form-item label="电影年代:" prop="yearage">
									{{filmData.yearage}}
								</el-form-item>
							</el-col>
							<el-col :span="12">
								<el-form-item label="电影时长:" prop="time">
									{{filmData.time}}
								</el-form-item>
							</el-col>
						</el-row>
						<el-row>
							<el-form-item label="主演:" prop="mainplayers">
								{{filmData.mainplayers}}
							</el-form-item>
						</el-row>
						<el-row>
							<el-form-item label="演员表:" prop="players">
								{{filmData.players}}
							</el-form-item>
						</el-row>
						<el-row>
							<el-form-item label="电影描述:" prop="desci">
								{{filmData.describle}}
							</el-form-item>
						</el-row>
						<el-row>
							<el-form-item label="电影海报:" prop="poster">
								<img src="../../../build/logo.png" class="poster" />
							</el-form-item>
						</el-row>
						<el-row>
							<el-form-item label="电影图集:" prop="pics">
								<img src="../../../build/logo.png" class="pic" />
							</el-form-item>
						</el-row>
					</el-form>
				</el-dialog>
			</template>
		</el-row>
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
					that.films = response.data.films;
				}).catch(error => { //请求失败
					console.log(error)
				});
		},
		methods: {
			//下架
			unplay(row) {
				console.log("下架");
			},
			/**格式化状态*/
			formatstatus(row, column) {
				if(row.status == 0)
					return '即将上映';
				else if(row.status == 1)
					return '正在热映';
				else
					return '已经下架';
			},
			//查询
			doquery(form) {
				this.queryDialogShow = false;
				console.log(this.queryFilm);
			},

			//图集的图片处理
			//删除图片
			removePic(file, fileList) {
				console.log(file, fileList);
			},
			//显示图片
			showPic(file) {
				this.picUrl = file.url;
				this.showPicVisible = true;
			},

			//上传海报成功之后
			handlePosterSuccess(res, file) {
				this.imageUrl = URL.createObjectURL(file.raw);
				console.log(this.imageUrl);
			},
			//长传海报之前限定
			beforePosterUpload(file) {
				const isJPG = file.type === 'image/jpeg';
				const isLt2M = file.size / 1024 / 1024 < 2;
				if(!isJPG) {
					this.$message.error('上传头像图片只能是 JPG 格式!');
				}
				if(!isLt2M) {
					this.$message.error('上传头像图片大小不能超过 2MB!');
				}
				return isJPG && isLt2M;
			},
			//添加影片
			adddialog(data) { //添加
				this.addDialogShow = true;
			},
			//编辑
			editdialog(data) {
				this.filmData = data;
				this.addDialogShow = true;
			},
			//影片详情
			detaildialog(data) { //详情数据
				this.filmData = data;
				//data是用于回显的数据
				this.detailDialogShow = true;
			},
			//选中行
			handleSelectionChange(val) {
				console.log(val); //被选中的行，就是要被删除的行
				this.selectFilms = val;
			},
			//删除影片按钮
			deletefilms() {
				//获取要被删除的影片，然后到后台删除
			},
			//分页
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
				//更改了每页显示条数，去后台查询
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				//更改了当前要显示第几页
			}
		},
		data() {
			return {
				yearageoptions: [{
					name: '1980年',
					id: '1'
				}, {
					name: '80年代',
					id: '2'
				}, {
					name: '70年代',
					id: '3'
				}],
				filmtypes: [{
						id: 1,
						name: '爱情'
					},
					{
						id: 2,
						name: '战争'
					},
					{
						id: 3,
						name: '武侠'
					}
				],
				filmareas: [{
					id: 1,
					name: '中国大陆'
				}, {
					id: 2,
					name: '欧美'
				}, {
					id: 3,
					name: '英国'
				}],
				selectFilms: [],
				films: [],
				detailDialogShow: false, //详情窗口
				addDialogShow: false, //添加窗口
				queryDialogShow: false, //查询窗口

				//海报
				imageUrl: '',
				//图集
				showPicVisible: false,
				picUrl: '',
				//表单初始化数据
				filmData: {
					name: '龙门飞甲',
					date: '',
					leader: '',
					price: '',
					poster: '',
					time: '',
					pics: [],
					describle: ""
				},

				//查询
				queryFilm: {
					name: '',
					startdate: '',
					enddate: '',
					leader: '',
					minprice: '',
					maxprice: '',
					poster: '',
					mintime: '',
					maxtime: '',
				},
				//查询日期区间
				queryDatePicker: {
					shortcuts: [{
						text: '最近一周',
						onClick(picker) {
							const end = new Date();
							const start = new Date();
							start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
							picker.$emit('pick', [start, end]);
						}
					}, {
						text: '最近一个月',
						onClick(picker) {
							const end = new Date();
							const start = new Date();
							start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
							picker.$emit('pick', [start, end]);
						}
					}, {
						text: '最近三个月',
						onClick(picker) {
							const end = new Date();
							const start = new Date();
							start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
							picker.$emit('pick', [start, end]);
						}
					}]
				},

				//校验规则
				rules: {
					name: [{
							required: true,
							message: '请输入影片名称',
							trigger: 'blur'
						},
						{
							min: 3,
							max: 10,
							message: '影片名长度在 3 到 10 个字符',
							trigger: 'blur'
						}
					]
				}
			}
		}

	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}
	
	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}
	
	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}
	
	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
	
	.pic {
		/*图集*/
		width: 100px;
		height: auto;
	}
	
	.poster {
		/*海报*/
		width: 200px;
		height: auto;
	}
</style>