import {createRouter, createWebHistory} from 'vue-router'
import SignUpView from "@/views/SignUpView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: SignUpView
    },
  ]
})

export default router
