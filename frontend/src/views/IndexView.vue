<template>
    <div class="index-page">
      <img src="../assets/images/index.jpg" alt="A cute couple image">
      <h2 class="title">안녕</h2>
    </div>
  </template>

<script>
    export default {
        name : "IndexView",

    }
</script>
<style>
.index-page {
  padding-top: 50px;
  background-color: #EDDBC7;
  text-align: center;
  padding-bottom: 100px;
}

</style>

<style scoped>


.title {
  margin-top: 10px;
  font-family: 'Dancing Script', cursive;
  font-size: 2rem;
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
