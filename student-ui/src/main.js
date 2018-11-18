import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

//包含全局配置的js-start
import domain from './domain.js'
//将访问后台的地址放在全局的Vue中
Vue.prototype.domain=domain

import vueAxios from 'axios'
//默认当axios进行跨域请求的时候是不会携带Cookies的
//设置vueAxios.defaults.withCredentials的值为true则跨域的时候会带上cookie
vueAxios.defaults.withCredentials = true;
//将axios存储在全局的VUe中然后就可以用this.的方式去掉用
Vue.prototype.$axios=vueAxios

Vue.config.productionTip = false

// new Vue({
//   render: h => h(App),
// }).$mount('#app')
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
