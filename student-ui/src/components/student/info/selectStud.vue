<template>
  <el-select v-model="value8" filterable
             default-first-option="true"
             @change="changeHandle"
             placeholder="请选择">
    <el-option
      v-for="item in options"
      :key="item.id"
      :label="item.name"
      :value="item.id">
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
        value8: '',

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
      }
    },
    watch: {
      selectStudValue: function () {  //监控父组件传过来的属性变化
        this.value8 = this.selectStudValue;
      }
    }
  }
</script>
