import { createRouter, createWebHashHistory } from 'vue-router'
import IndexView from '../views/IndexView.vue'
import RegisterView from '../views/RegisterView.vue'
import DiaryView from '../views/DiaryView.vue'
import CalendarView from '../views/CalendarView.vue'
import DiaryListView from '../views/DiaryListView.vue'
import LetterBoxView from '../views/LetterBoxView.vue'
import LetterView from '../views/LetterView.vue'
import WelcomeView from '../views/WelcomeView.vue'
import { checkMatchStatus } from '@/services/AuthService'

const routes = [
  {
    path: '/',
    name: 'index',
    component: IndexView,
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/diary',
    name: 'diary',
    component: DiaryView
  },
  {
    path: '/diaryList',
    name: 'diaryList',
    component: DiaryListView
  },
  {
    path: '/calendar',
    name: 'calendar',
    component: CalendarView
  },
  {
    path: '/letterbox',
    name: 'letterbox',
    component: LetterBoxView
  },
  {
    path: '/letter/:id',
    name: 'letter',
    props: true,
    component: LetterView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/welcome',
    name: 'welcome',
    component: WelcomeView
  }

]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

router.beforeEach(async(to, from, next) => {
  const isMatchedIn = await checkMatchStatus();
  if(to.name !=='welcome' && !isMatchedIn){
    next({ name: 'welcome'})
  } else{
    next()
  }
})

export default router
