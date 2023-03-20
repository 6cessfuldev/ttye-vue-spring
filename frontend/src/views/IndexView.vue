<template>
    <div class="index-page">
      <img src="../assets/images/index.jpg" alt="A cute couple image">
      <h1 class="title">안녕하쇼~</h1>
      <p class="description"></p>
    </div>
  </template>

<script>
    export default {
        name : "IndexView",

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

</style>
