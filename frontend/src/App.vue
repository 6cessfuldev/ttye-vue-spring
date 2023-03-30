<template>
<div>
  <transition name="slide-fade">
      <router-view :key="$route.fullPath"/>
  </transition>
</div>
</template>
<script>

</script>

<style>
</style>