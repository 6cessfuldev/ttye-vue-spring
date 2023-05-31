<template>
<div>
  <HeaderNav></HeaderNav>
  <transition name="slide-fade">
      <router-view :key="$route.fullPath"/>
  </transition>
</div>
</template>
<script>
import HeaderNav from '@/components/HeaderNav.vue'
export default {
  name: 'App',
  components: {
    HeaderNav
  }
}

</script>

<style>
</style>