<template>
    <div>
      <div class="button-container">
      <button v-if="!isLoggedIn" class="login-button btn" @click="loginModal = true">Login</button>
      <button v-else class="match-button btn" @click="matchModal = true">Match</button>
     </div>
      <LoginModal v-if="loginModal" @close="loginModal = false" @register="loginModal = false; registerModal = true;"></LoginModal>
      <MatchModal v-if="matchModal" @close="matchModal = false" @matching="matchModal=false; $emit('matching')"></MatchModal>
      <RegisterModal v-if="registerModal" @submit="registerModal =false" @close="registerModal = false"></RegisterModal>
    </div>
</template>

<script>
import LoginModal from '@/components/LoginModal.vue'
import MatchModal from '@/components/MatchModal.vue'
import RegisterModal from '@/components/RegisterModal.vue'
import { ref, onMounted } from 'vue';
import axios from 'axios';

export default {
    name: "BeforeMatch",
    components: {
        LoginModal,
        MatchModal,
        RegisterModal
    },
    setup() {
        const isLoggedIn = ref(false)
        const loginModal = ref(false)
        const matchModal = ref(false)
        const registerModal = ref(false)

        onMounted(() => {
            axios.get("http://localhost:8080/user/isLoggedIn")
                .then(function(response){
                    isLoggedIn.value = response.data;
                })      
        })

        return {
            isLoggedIn,
            loginModal,
            matchModal,
            registerModal,

        }
    }
}
</script>

<style scoped>
.button-container {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    background-color: #EDDBC7;
    padding-bottom: 40px;
  }

  .btn {
    background-color: #A7727D;
    color: #fff;
    font-size: 1.2rem;
}

</style>