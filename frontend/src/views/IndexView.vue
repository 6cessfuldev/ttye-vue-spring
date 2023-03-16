<template>
    <div class="index-page">
      <img src="../assets/images/index.jpg" alt="A cute couple image">
      <h1 class="title">안녕하쇼~</h1>
      <p class="description"></p>
      <div class="button-container">
      <button class="login-button btn" @click="showModal = true">Login</button>
     </div>
      <modal v-if="showModal" @close="showModal = false">
      </modal>
    </div>
  </template>

<script>
    import Modal from '@/components/LoginModal.vue'

    export default {
        name : "IndexView",
        components: {
            Modal
        },
        data() {
            return {
                showModal: false,
            }
        },
    }
</script>
<style>
.index-page {
  background-color: #EDDBC7;
  text-align: center;
  padding: 20px;
}

</style>

<style scoped>


.title {
  font-family: 'Dancing Script', cursive;
  font-size: 3rem;
  margin-top: 30px;
}

.description {
  font-size: 1.5rem;
  margin-top: 20px;
}

img {
  border: 5px solid #fff;
  box-shadow: 0 0 10px #ddd;
  border-radius: 50%;
  width: 300px;
  height: 300px;
  margin-top: 50px;
}

.button-container {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    margin-top: 30px;
  }

  .login-button {
    background-color: #A7727D;
    color: #fff;
    font-size: 1.2rem;
} 
</style>
