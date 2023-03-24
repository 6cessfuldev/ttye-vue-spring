<template>
  <div class="index-page">
  <div id="diary">
    <editor
      api-key="no-api-key"
      :init="{
         language : 'ko_KR',
         width: 800,
          height: 600,
          plugins: [
            'advlist', 'autolink', 'link', 'image', 'lists', 'charmap', 'preview', 'anchor', 'pagebreak',
            'searchreplace', 'wordcount', 'visualblocks', 'visualchars', 'code', 'fullscreen', 'insertdatetime',
            'media', 'table', 'emoticons', 'template', 'help', 'save'
          ],
          toolbar: ' styles bold italic alignleft aligncenter alignright alignjustify ' +
          'forecolor backcolor emoticons' +
          ' link image media | save | ',
            
          menubar: false,
          content_css: 'css/content.css',
          
      }" 
      v-model="editorContent"
    />
    <br>
  </div>
  <button @click="submitEditorContent">저장</button>
</div>
</template>

<script>
import Editor from '@tinymce/tinymce-vue'
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

export default {
  name: 'diaryView',
  components: {
    'editor': Editor
  },
  setup() {
    const editorContent = ref('');
    const router = useRouter();

    function submitEditorContent() {
      axios.post('/diary/register', { content: editorContent.value })
        .then(response => {
          if(response.data){
            router.replace("/calendar");
          }else{
            alert("서버 에러");
          }
        })
        .catch(error => {
          console.log(error);
        });
    }

    return {
      editorContent,
      submitEditorContent,
  
    }
  }
}
</script>

<style scoped>

#diary{
  margin-top:100px;
  display:flex;
  align-items: center;
  justify-content: center;  
}
</style>