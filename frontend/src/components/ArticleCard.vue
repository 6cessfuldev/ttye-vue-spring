<template>
  <div class="article-card" :style="{ '--aspect-ratio': aspectRatio }">
    <div class="article-image">
      <img :src="image" :alt="title" @load="setImageAspectRatio" />
    </div>
    <h2 class="article-title">{{ title }}</h2>
  </div>
</template>

<script>
export default {
  name: 'ArticleCard',
  props: {
    title: {
      type: String,
      required: true,
    },
    image: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      aspectRatio: null,
    };
  },
  methods: {
    setImageAspectRatio() {
      const img = this.$el.querySelector('.article-image img');
      this.aspectRatio = img.naturalWidth / img.naturalHeight;
    },
  },
};
</script>

<style scoped>
.article-card {
  position: relative;
  margin-bottom: 40px;
  border-radius: 8px;
  box-shadow: 0px 2px 6px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  transition: transform 0.2s ease-in-out;
  cursor: pointer;
  background-color: #f3f3f3;
}

.article-image {
  position: relative;
  width: 100%;
  padding-bottom: calc(100% / var(--aspect-ratio));
  overflow: hidden;
}

.article-image img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.article-title {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 10px 20px;
  font-size: 20px;
  font-weight: bold;
  color: #fff;
  background-color: rgba(0, 0, 0, 0.6);
  text-align: center;
  border-radius: 0 0 8px 8px;
}
</style>
