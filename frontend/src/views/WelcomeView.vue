<template>
<div class="container">
  <div class="wrapper">
    <!-- 우측 상단에 로그아웃 버튼 -->
    <div class="title">
      <h1>Couple Blog</h1>
      <button class="logoutBtn" v-show="loginStatus" @click="logout">Logout</button>
    </div>
    <div class="img-wrap" @click="turnAround">  
      <img src="https://images.unsplash.com/photo-1506014299253-3725319c0f69?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80" alt="">
    </div>
    <BeforeMatch></BeforeMatch>
  </div>
</div>
</template>
<script>
import BeforeMatch from '@/components/BeforeMatch.vue';
import { onMounted } from 'vue';
import { ref } from 'vue';
import axios from 'axios';

export default {
  name: "WelcomeView",
  components: {
    BeforeMatch
  },
  setup() {    

    const loginStatus = ref(false)

    function logout() {
      axios.get("http://localhost:8080/user/logout")
      .then(function(response){
        console.log(response.data);
        location.reload();
      })
      .catch(function(error){
        console.log(error);
      });
    }

    function turnAround() {
      const img = document.querySelector('img');
      img.style.transition = 'transform 1s';
      if(img.style.transform === 'rotateY(180deg)') {
        img.style.transform = 'rotateY(0deg)';
      }else{
        img.style.transform = 'rotateY(180deg)';
      }
    }

    onMounted(() => {
      axios.get("http://localhost:8080/user/isLoggedIn")
      .then(function(response){
        if(!response.data) {
          loginStatus.value = false;
        } else {
          loginStatus.value = true;
        }
      })
      .catch(function(error){
        console.log(error);
      });
    })


    return {
      turnAround,
      loginStatus,
      logout
    }
  }
}
</script>

<style scoped>
.container{
    display: flex;
    justify-content: center;
}
.wrapper{
  padding: 50px;
  margin:0;
  text-align: center;
}

.title{
  margin-top: 30px;
  text-align: center;
}

.logoutBtn{
  /* 우측 상단 로그아웃버튼 */
  position: absolute;
  right: 0;
  top: 0;
  margin: 10px;
  padding: 10px;
  border: 1px solid #b3afaf;
  border-radius: 5px;
  background-color: #fff;
  color: #b3afaf;
  font-size: 15px;
  cursor: pointer;
}

.img-wrap{
  display: flex;
  justify-content: center;
}

img {
  box-shadow: 0 0 20px #b3afaf;
  width: 250px;
  margin-top: 20px;
  margin-bottom: 20px;
}

#app {
  background-color: transparent;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

#app>div{
    background-color: transparent;
}

</style>