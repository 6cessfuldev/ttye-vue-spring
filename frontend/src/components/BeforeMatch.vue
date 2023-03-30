<template>
    <div>
      <button v-if="!isLoggedIn" class="login-button btn" @click="loginModal = true"><h2>Login</h2></button>
      <button v-else class="match-button btn" @click="matchModal = true">Match</button>

      <LoginModal v-if="loginModal" @close="loginModal = false" @register="loginModal = false; registerModal = true;"></LoginModal>
      <MatchModal v-if="matchModal" @close="matchModal = false" @matching="matchModal=false;"></MatchModal>
      <RegisterModal v-if="registerModal" @submit="registerModal =false" @close="registerModal = false"></RegisterModal>
    </div>
</template>

<script>
import LoginModal from '@/components/LoginModal.vue'
import MatchModal from '@/components/MatchModal.vue'
import RegisterModal from '@/components/RegisterModal.vue'
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

export default {
    name: "BeforeMatch",
    components: {
        LoginModal,
        MatchModal,
        RegisterModal
    },
    setup() {

        const router = useRouter()
        const isLoggedIn = ref(false)
        const isMatched = ref(false)
        const loginModal = ref(false)
        const matchModal = ref(false)
        const registerModal = ref(false)

        onMounted(() => {
            axios.get("http://localhost:8080/user/isLoggedIn")
            .then(function(response){
                if(!response.data) {
                isLoggedIn.value = false;
                } else {
                isLoggedIn.value = true;
                axios.get("http://localhost:8080/user/isMatched")
                .then(function(response){
                    if(response.data) router.replace('/');
                    else isMatched.value = false;
                });
                }
            })
            .catch(function(error){
                console.log(error);
                
            });
        
        })

        return {
            isLoggedIn,
            isMatched,
            loginModal,
            matchModal,
            registerModal,
        }
    }
}
</script>

<style scoped>

.btn {
    border: black, 1px, solid;
    color: black;
}
.btn:hover{
    background-color: #EDDBC7;
    color: white;
}


</style>