<template>
<div class="container">
<div class="wrapper">
    <div class="title">
      <h1>Couple Blog</h1>
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
import { useRouter } from 'vue-router';
// import axios from 'axios';

export default {
  name: "WelcomeView",
  components: {
    BeforeMatch
  },
  setup() {    

    const router = useRouter()

    function goToDiary() {
      router.push('/diary');
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


    return {
      turnAround,
      goToDiary,
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