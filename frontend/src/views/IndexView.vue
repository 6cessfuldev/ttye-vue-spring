<template>
    <div class="index-page">
      <HeaderNav></HeaderNav>
      <div class="title">
        <h1>제목은 뭐로 할까나</h1>
        <img src="https://via.placeholder.com/200x300" alt="대문 사진">
        <p>
          <br>
          "나의 삶에서 가장 아름다운 일은 너와 함께 있을 때이다."
        </p>
      </div>
    </div>
  </template>

<script>
import HeaderNav from '@/components/HeaderNav.vue'

export default {
  name : "IndexView",
  components: {
    HeaderNav,
  },
  setup() {

  }

}
</script>
<style>
.index-page {
  background-color: #EDDBC7;
  text-align: center;
  padding-bottom: 100px;
}

</style>
<style scoped>
.title{
  padding: 30px;
}
</style>