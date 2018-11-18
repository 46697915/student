import Vue from 'vue'

import HelloWorld from '@/components/HelloWorld'
import Router from 'vue-router'
import login from '@/view/login'
import shouye from '@/view/shouye'
import test from '@/view/test'
import test2 from '@/view/yewu/test2'
import menuManger from '@/view/yewu/menuManger'
import datamenu from '@/view/datamenu'
import datamain from '@/view/datamain'
Vue.use(Router)

export default new Router({
  mode:'history',
  /*base:'/dist/',*/
  routes: [
    {
      path:'/',
      name:"login",
      component:login
    },
    {
      path:'/shouye',
      name:"shouye",
      meta:{
        requireAuth:true,//表示进入该路由的时候需要登录
      },
      component:shouye,
      children:[
        {
          path:"/datamain",
          component:datamain,
          children:[//页面主显示区域的页面路由（采用嵌套路由的方式实现）
            {path:'/datamain/test',component:test,meta:{requireAuth:true}},
            {path:'/datamain/yewu/test2',component:test2,meta:{requireAuth:true}},
            {path:'/datamain/yewu/menuManger',component:menuManger,meta:{requireAuth:true}}
          ]
        }
      ]
    },
    {
      path:"/datamenu",
      component:datamenu,
      meta:{requireAuth:true}
    }
  ]
})

