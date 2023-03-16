import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { BootstrapIconsPlugin } from 'bootstrap-icons-vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import 'bootswatch/dist/sketchy/bootstrap.min.css'


createApp(App).use(router).use(BootstrapIconsPlugin).mount('#app')
