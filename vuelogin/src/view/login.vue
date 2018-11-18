<template>
<div id="lo" >
   <div ref="d1">

      <el-form ref="form"  :model="form" label-width="80px" align="center" style="width: 40%;">
        <el-form-item label="账户">
          <el-input type="text" v-model.trim="form.userName" ></el-input>
        </el-form-item>
        <el-form-item label="密码">
           <el-input type="password"  v-model.trim="form.passWord"></el-input>
        </el-form-item>
        <el-form-item label="验证码">
          <el-col :span="11">
            <el-input type="text" v-model="form.code"  style="width:100%;"></el-input>
          </el-col>
          <el-col :span="11" style="margin-left: 20px">
            <img id="img" ref="img" style="width:100%" @click="image()" v-bind:src="src" ></img>
          </el-col>
        </el-form-item>

        <el-form-item >
          <el-button type="primary" @click="login()">登录</el-button>
          <el-button type="round" @click="register()">注册</el-button>
        </el-form-item>
      </el-form>

     <!-- <router-link to="/shouye"><a id="shouye" href="/shouye">首页</a></router-link>-->
   </div>
</div>
</template>

<script>
    export default {
      name: "login",
      data() {
        return {
          form: {
            userName: '',
            passWord: '',
            code:''
          },
          src:this.domain.serverpath+"/image/main",

        }
      },
      methods:{
          image:function(){
              let nu=Math.random(1);
              let url=this.domain.serverpath+"/image/main?"+nu;
              //document.getElementById("img").setAttribute("src",url);//这是写法之一
              //也可以这么写
              this.$refs.img.src=url;
          },
          loginInfo:function(info,type){
            this.$message({
              message: info,
              type: type,
            })
          },
          register:function(){

          },
          login:function(){
              if(this.form.userName==''||this.form.userName==null){

                 this.loginInfo('账户信息不能为空！','warning');
                 return;
              }
              if(this.form.passWord==''||this.form.passWord==null){
                this.loginInfo('密码信息不能为空！','warning');
                return;
              }
              if(this.form.code==''||this.form.code==null){
                 this.loginInfo('验证码不能为空！','warning');
                 return;
              }
              //验证通过开始进行登录
              let qs=require("qs");//用来让参数编程key-value对
              let form=this.form;
              let Base64 = require('js-base64').Base64;
              form.passWord=Base64.encode(form.passWord);
              this.$axios.post(this.domain.serverpath+"/vue/login",qs.stringify(this.form)).then((response)=>{
                  if(response.data.code==1){//登陆成功
                       //将登陆成功的表示存储在全局缓存中
                       let token=response.data.token
                       //存入VUEX的全局变量中
                       //this.$store.state.token=token
                       //使用本地存储存储、或者使用Cookie保存登录状态
                       window.localStorage.setItem("login_token",token)
                       //跳转到首页界面
                       this.$router.push({path:'/shouye'})
                  }else{
                    //登录失败
                    this.open(response.data.error)
                  }
              }).catch((error)=>{

                  this.open('登陆错误，请联系管理员进行处理'+error.message);
              })

          },
        open(message) {
            const h = this.$createElement;
            this.$notify({
              title: '错误提示',
              message: h('i', { style: 'color: teal'}, message),
              duration:5000 //延时时间
            });
        }

      },
      destroyed(){
        //eventBus 消息总线
        this.$eventBus.$emit('key',"data64545454654");
      }
    }
</script>

<style>
  #lo{
    padding-left: 40%;
    margin-top:15%;

  }
</style>
