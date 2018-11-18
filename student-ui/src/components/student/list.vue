<template>
  <el-row style="margin-top: 10px;">
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
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="1"
                   :page-sizes="[10, 20, 30, 40]" :page-size="100" layout="total, sizes, prev, pager, next, jumper"
                   :total="400">
    </el-pagination>
  </el-row>
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
      /**格式化状态*/
      formatstatus(row, column) {
        if (row.status == 0)
          return '即将上映';
        else if (row.status == 1)
          return '正在热映';
        else
          return '已经下架';
      },
      //查询
      doquery(form) {
        this.queryDialogShow = false;
        console.log(this.queryFilm);
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

</style>
