import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import MenuInfo from '@/components/menu/list'
import StudentInfo from '@/components/student/info/list'
import StudentWork from '@/components/student/work/list'
import StudentLearn from '@/components/student/learn/list'
import StudentReview from '@/components/student/review/list'
import StudentInterview from '@/components/student/interview/list'

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
      path: '/studentLearn',
      name: 'StudentLearn',
      component: StudentLearn
    },
    {
      path: '/studentReview',
      name: 'StudentReview',
      component: StudentReview
    },
    {
      path: '/studentInterview',
      name: 'StudentInterview',
      component: StudentInterview
    }
  ]
})
