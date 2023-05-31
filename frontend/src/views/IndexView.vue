<template>
    <div class="index-page">
      
      <div class="title">
        <h1>제목</h1>
        <img src="https://via.placeholder.com/200x300" alt="대문 사진">
        <p>
          <br>
          "나의 삶에서 가장 아름다운 일은 너와 함께 있을 때이다."
        </p>
      </div>
    </div>
  </template>

<script>

export default {
  name : "IndexView",
  setup() {

  }

}
</script>
<style>
.index-page {
  text-align: center;
  padding-bottom: 100px;
}

</style>
<style scoped>
.title{
  padding: 30px;
}
h1{
  font-family: 'Dancing Script', cursive;
  font-size: 2rem;
  margin-bottom: 20px;
}
</style>