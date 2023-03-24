<template>
  <div>
    <div class="header"> 
      <a class="bgm fw-bold" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample" @mouseover="hoverBGM">BGM</a>
      <nav v-if="isMatched">
        <router-link to="/">Home</router-link> |
        <router-link to="/calendar">Calendar</router-link> |
        <router-link to="/letterbox">LetterBox</router-link> |
        <router-link to="/about">About</router-link>
      </nav>  
      <a class="logout" @click="logout" v-if="isLoggedIn"> 로그아웃 </a>
      <MyBgm @mouseleave="mouseleaveBGM"></MyBgm>
    </div>
    <transition name="slide-fade">
      <router-view :key="$route.fullPath"/>
    </transition>
    <BeforeMatch v-if="!isMatched" @matching="isMatched = true"></BeforeMatch>
    
  </div>
</template>
<script>
import MyBgm from '@/components/MyBgm.vue'
import BeforeMatch from '@/components/BeforeMatch.vue';
import { ref, onMounted } from 'vue';
import axios from 'axios';

// import axios from 'axios';

export default {
  components: {
    MyBgm,
    BeforeMatch
  },
  setup() {

    const isLoggedIn = ref(false);
    const isMatched = ref(false);

    const hoverBGM = () => {
      document.querySelector('.bgm').click();
    }

    const mouseleaveBGM = () => {
      document.querySelector('.bgm').click();
    }

    function logout () {
      axios.get("http://localhost:8080/user/logout")
      .then(function(response){
        if(response.data){
          alert("로그아웃!");
          window.location.href = "/";
        } else{
          alert("서버 에러");
        }
      })
    }
    
    onMounted(() => {

      axios.get("http://localhost:8080/user/isLoggedIn")
      .then(function(response){
        isLoggedIn.value=response.data;
      })

      axios.get("http://localhost:8080/user/isMatched")
      .then(function(response){
          isMatched.value = response.data;
      }); 
    })

    return {
      isMatched,
      hoverBGM,
      mouseleaveBGM,
      logout
    }
  }
}
</script>
<style>
html, body {
  background-color: #EDDBC7;
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

.header{
  position:relative;
}

nav {
  text-align: center;
  padding: 30px;
}

nav a {
  text-decoration: none;
  font-weight: bold;
  color: white;
}

nav a.router-link-exact-active {
  color: #EDDBC7;
}
.bgm {
  text-align: center;
  height: 50px;
  width: 50px;
  line-height: 50px;
  border-radius: 10px;
  background-color: #EDDBC7;
  position: absolute;
  color: #A7727D;
  left: 30px;
  top: 20px;
  text-decoration: none;
  float: left;
}

.logout{
  text-align: center;
  height: 50px;
  width: 70px;
  line-height: 50px;
  border-radius: 10px;
  background-color: #EDDBC7;
  position: absolute;
  color: #A7727D;
  right: 30px;
  top: 20px;
  text-decoration: none;
  float: right;
}

.logout:hover{
  cursor: pointer;
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