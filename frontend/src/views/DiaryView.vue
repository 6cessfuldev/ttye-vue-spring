<template>
  <div class="index-page">
    <h1>{{ diary_date }}</h1>
    <div class="title">
      <input type="text" v-model="diary_title" placeholder="제목을 입력하세요.">
    </div>
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
    <button @click="submit">저장</button>
  </div>
</template>

<script>
import Editor from '@tinymce/tinymce-vue'
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { submitEditorContent } from '@/services/DiaryService';

export default {
  name: 'diaryView',
  components: {
    'editor': Editor
  },
  setup() {
    const editorContent = ref('')
    const route = useRoute()
    const diary_date = ref('')
    const diary_title = ref('')
    const router = useRouter()

    function submit(){
      return submitEditorContent(editorContent.value, route.query.diary_date, diary_title.value)
      .then(function(response){
        console.log(response);
        if(response){
          console.log(response);
          router.replace('/calendar');
        }
      });
    }

    onMounted(() => {
      diary_date.value = route.query.diary_date;
    })

    return {
      submit,
      editorContent,
      diary_date,
      diary_title
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

.title{
  margin-top:50px;
  display:flex;
  align-items: center;
  justify-content: center;
  background: #f5f5f5;
  border: 1px solid #e3e3e3;
  border-radius: 3px;
  padding: 10px;
  width: 800px;
  height: 50px;

}
</style>