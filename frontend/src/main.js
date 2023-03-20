import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { BootstrapIconsPlugin } from 'bootstrap-icons-vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import 'bootswatch/dist/sketchy/bootstrap.min.css'
import mitt from 'mitt'

const emitter = mitt();
const app = createApp(App);
app.config.globalProperties.emmiter=emitter;
app.use(router).use(BootstrapIconsPlugin).mount('#app');
