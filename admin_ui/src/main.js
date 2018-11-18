// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

import VueRouter from 'vue-router'
Vue.use(VueRouter)

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

import Films from "./components/films/Films"
import FilmSetting from "./components/films/Setting"

import Wel from "./components/Wel"
import Cinema from "./components/cinema/Cinema"

import Vip from "./components/vip/Vip"
import Level from "./components/vip/Level"

Vue.config.productionTip = false

const routes = [{
	path: "/films/list",
	component: Films
},{
	path: "/films/setting",
	component: FilmSetting
}, {
	path: "/vip/list",
	component: Vip
},{
	path: "/vip/level",
	component: Level
},{
	path: "/wel",
	component: Wel
}, {
	path: "/cinema/list",
	component: Cinema
},{
	path: "*",
	component: Wel
}]

const router = new VueRouter({
	routes, // (缩写) 相当于 routes: routes ，定义路由器
	"mode": "history" //去掉地址上的#号
})

/* eslint-disable no-new */
new Vue({
	el: '#app',
  router,
	components: {
		App
	},
	template: '<App/>'
})
