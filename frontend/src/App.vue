<template>
<div>
  <HeaderNav v-if="loginStatus"></HeaderNav>
  <transition name="slide-fade">
      <router-view :key="$route.fullPath"/>
  </transition>
</div>
</template>
<script>
import HeaderNav from '@/components/HeaderNav.vue'
import { ref, onMounted } from 'vue';
import axios from 'axios';

export default {
  name: 'App',
  components: {
    HeaderNav
  },
  setup() {

    const loginStatus = ref(false)

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
      loginStatus
    }
  }
}

</script>

<style>
</style>