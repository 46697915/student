<template>
  <el-select v-model="selectedValue"
             filterable
             :default-first-option="true"
             @change="changeHandle"
             placeholder="请选择">
    <el-option
      v-for="item in options"
      :key="item.id"
      :label="item.name"
      :value="item.id">
      <span style="float: left">{{item.name }}</span>
      <span style="float: right; color: #8492a6; font-size: 13px">{{ item.id }}</span>
    </el-option>
  </el-select>
</template>

<script>
  import axios from 'axios'
  export default {
    props: ["selectStudValue"],
    data() {
      return {
        options: [],
        selectedValue: '',

        queryUrl: this.domain.serverpath+"/studentInfo/list"
      }
    },
    mounted() {
      axios.get(this.queryUrl)
        .then(response => { //请求正确
          console.log(response);
          this.$data.options = response.data.result;
        }).catch(error => { //请求失败
        console.log(error)
      });
    },
    methods:{
      changeHandle(value){
        let datas = this.$data.options;
        let option ;
        for(var a in datas){
          if(value == datas[a].id){
            option = datas[a];
          }
        }
        //弹出框关闭是，触发dialogClose事件，父组件处理此事件
        this.$emit("selectStudChange", option);
      },
//      filterHandle(value){
//        let datas = this.$data.options;
//        for(var a in datas){
//          alert(datas[a].id);
//          if(datas[a].id.toLowerCase().indexOf(value.toLowerCase())
//              || datas[a].name.toLowerCase().indexOf(value.toLowerCase())
//          ){
//            alert(datas[a].name);
//            return true ;
//          }
//        }
//        return false ;
//      }
    },
    watch: {
      selectStudValue: function () {  //监控父组件传过来的属性变化
        this.selectedValue = this.selectStudValue;
      }
    }
  }
</script>
