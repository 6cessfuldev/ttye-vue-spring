<template>
<div>
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/calendar">Calendar</router-link> |
      <router-link to="/letterbox">LetterBox</router-link> |
      <router-link to="/about">About</router-link>
    </nav>  
</div>  
</template>

<script>
export default {
    name: 'NaviBar'
}
</script>

<style scoped>
nav {
  text-align: center;
  padding: 30px;
}

nav a {
  text-decoration: none;
  font-weight: bold;
  color: white;
}

nav a.router-link-exact-active {
  color: #EDDBC7;
}
</style>