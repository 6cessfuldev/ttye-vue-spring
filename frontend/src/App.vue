<template>
  <div>
    <div v-if="isMatched">
      <NaviBar></NaviBar>
      <a class="bgm fw-bold" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample" @mouseover="hoverBGM">BGM</a>
      <MyBgm @mouseleave="mouseleaveBGM"></MyBgm>
    </div>
    <transition name="slide-fade">
      <router-view :key="$route.fullPath"/>
    </transition>
    <BeforeMatch v-if="!isMatched"></BeforeMatch>
    
  </div>
</template>
<script>
import MyBgm from '@/components/MyBgm.vue'
import NaviBar from '@/components/NaviBar.vue'
import BeforeMatch from '@/components/BeforeMatch.vue';
import { ref, onMounted } from 'vue';

// import axios from 'axios';

export default {
  components: {
    MyBgm,
    NaviBar,
    BeforeMatch
  },
  setup() {

    const isMatched = ref(false);

    const hoverBGM = () => {
      document.querySelector('.bgm').click();
    }

    const mouseleaveBGM = () => {
      document.querySelector('.bgm').click();
    }
    
    onMounted(() => {
      // axios.get("http://localhost:8080/user/isLoggedIn")
      //   .then(function(response){
      //       isLoggedIn = response.data;
      //   }); 
    })

    return {
      isMatched,
      hoverBGM,
      mouseleaveBGM
      
    }
  }
}
</script>
<style>
html {
  background-color: #F9F5E7;
}

nav {
 background-color: #A7727D; 
}
.background {
  background-color: #EDDBC7;
  text-align: center;
  padding: 20px;
  min-height: 500px;
}
</style>
<style scoped>
.bgm {
  text-align: center;
  height: 50px;
  width: 50px;
  line-height: 50px;
  border-radius: 10px;
  background-color: #EDDBC7;
  color: #A7727D;
  position: fixed;
  right: 30px;
  top: 20px;
  text-decoration: none;
  float: right;
}

.bgm:focus {
  outline: none;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}


.slide-fade-enter-active {
  transition: all 0.3s ease-out;
}


.slide-fade-enter-from,
.slide-fade-leave-to {
  transform: translateX(20px);
  opacity: 0;
}
</style>