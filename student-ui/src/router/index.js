import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import StudentInfotest from '@/components/student/StudentInfo'
import MenuInfo from '@/components/menu/list'
import StudentInfo from '@/components/student/info/list'
import StudentWork from '@/components/student/work/list'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/sys/menuInfo',
      name: 'MenuInfo',
      component: MenuInfo
    },
    {
      path: '/studentInfo',
      name: 'StudentInfo',
      component: StudentInfo
    },
    {
      path: '/studentWork',
      name: 'StudentWork',
      component: StudentWork
    },
    {
      path: '/studentInfotest',
      name: 'StudentInfotest',
      component: StudentInfotest
    }
  ]
})
