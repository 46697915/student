// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';//element-ui 的样式
Vue.config.productionTip = false
Vue.use(ElementUI)
//包含全局配置的js-start
import domain from './domain.js'
//将访问后台的地址放在全局的Vue中
Vue.prototype.domain=domain
//包含全局配置的js-end
/* eslint-disable no-new */
import vueAxios from 'axios'
//默认当axios进行跨域请求的时候是不会携带Cookies的
//设置vueAxios.defaults.withCredentials的值为true则跨域的时候会带上cookie
vueAxios.defaults.withCredentials = true;
//将axios存储在全局的VUe中然后就可以用this.的方式去掉用
Vue.prototype.$axios=vueAxios

//全局事件总线start
const EventBus = new Vue();
Vue.prototype.$eventBus=EventBus
//全局事件总线end


//导入VUEX
import vuex from 'vuex'
//将Vuex实例存储在全局的VUE中
Vue.use(vuex)
const store=new vuex.Store({
  state:{
    token:""
  }
})
Vue.prototype.$store=store


//路由拦截，使用全局的router进行路由拦截，实现页面的权限
router.beforeEach((to,from,next)=>{
  console.log("===========888=========="+store.state.token)
  if(to.meta.requireAuth){//to.meta.requireAuth用来判断页面是否需要进行拦截
     //获取登陆标识
     //let to=store.state.token//会在刷新页面之后消失
     let to=window.localStorage.getItem("login_token")
     if(to!=null&&to!=""){
       next();//到首页
     }else{
       next({path:"/"});//跳转页面
     }
  }
     next();
})

//请求后台的axios请求拦截
/*vueAxios.interceptors.request.use((config)=>{

})*/



new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
