<template>
    <div class="header">
        <a class="bgm fw-bold" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample" @mouseover="hoverBGM">BGM</a>
        <nav>
            <router-link to="/">Home</router-link> |
            <router-link to="/calendar">Calendar</router-link> |
            <router-link to="/letterbox">LetterBox</router-link> |
            <router-link to="/about">About</router-link>
        </nav>  
        <a class="logout" @click="logout"> 로그아웃 </a>
        <MyBgm @mouseleave="mouseleaveBGM"></MyBgm>
</div>
</template>
<script>
import MyBgm from '@/components/MyBgm.vue'
import axios from 'axios'; 
import { useRouter } from 'vue-router';

export default {
  name : "HeaderNav",
  components: {
    MyBgm,
  },
  setup() {

    const router = useRouter();
    
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
          router.replace('/welcome');
        } else{
          alert("서버 에러");
        }
      })
    }

    return {
      hoverBGM,
      mouseleaveBGM,
      logout,
    }

  }

}
</script>
<style>

</style>

<style scoped>

.title {
  margin-top: 10px;
  font-family: 'Dancing Script', cursive;
  font-size: 2rem;
}

.header{
  position:relative;
}

nav {
  text-align: center;
  padding: 30px;
}

nav a {
  font-size: 1.5rem;
  text-decoration: none;
  font-weight: bold;
  color: grey;
}

nav a.router-link-exact-active {
  color: black;
}
.bgm {
  text-align: center;
  height: 50px;
  width: 50px;
  line-height: 50px;
  border-radius: 10px;
  background-color: grey;
  position: absolute;
  color: white;
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
  background-color: grey;
  position: absolute;
  color: white;
  right: 30px;
  top: 20px;
  text-decoration: none;
  float: right;
}

.logout:hover{
  cursor: pointer;
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
