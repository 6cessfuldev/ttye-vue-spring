<template>
  <div class="index-page">
    <h1>{{ diary_date }}</h1>
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
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';

export default {
  name: 'diaryView',
  components: {
    'editor': Editor
  },
  setup() {
    const editorContent = ref('')
    const router = useRouter()
    const route = useRoute()
    const diary_date = ref('')

    function submitEditorContent() {
      axios.post('/diary/register', { 
        content: editorContent.value,
        diary_date: route.query.diary_date
      })
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

    onMounted(() => {
      diary_date.value = route.query.diary_date;
    })

    return {
      editorContent,
      submitEditorContent,
      diary_date
    }
  }
}
</script>

<style scoped>

#diary{
  margin-top:50px;
  display:flex;
  align-items: center;
  justify-content: center;  
}
</style>