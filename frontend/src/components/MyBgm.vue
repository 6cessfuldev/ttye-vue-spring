<template>
  <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasExampleLabel">추억의 노래 BGM</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <div>
          <iframe width="300" height="180" src="https://www.youtube.com/embed/ciBisqVQ6xc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        </div>
        <div>
          <div class="bgm-list">
            <table border="1">
              <colgroup>
                <col style="width:60%">
                <col style="width:30%">
              </colgroup>
              <tr>
                <th>제목</th>
                <th>날짜</th>
              </tr>
              
              <tr v-for="(bgm, index) in bgmList" :key="index">
                <td>{{ bgm.video_title.length > 15 ? bgm.video_title.substring(0, 13) + '...' : bgm.video_title }}</td>
                <td>{{ bgm.reg_date.slice(0, 10) }}</td>
              </tr>

            </table>
          </div>
          <div class="bgm-list-insert">
            <input type="text" name="bgm-insert" id="insert-bgm" placeholder="유튜브 주소를 입력해주세요.">
            <input type="button" id="insert-bgm-button" value="추가" v-on:click = "addClick">
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import { getBgmList, addBgm } from '@/services/BgmService';
import { onMounted, ref } from 'vue';

export default {
    name: 'MyBgm',
    setup() {

      alert(process.env.VUE_APP_YOUTUBE_API_KEY);

      const bgmList = ref([]);
      const bgm_url = ref('');

      function start() {
        let url = bgm_url.value;
        url = url.substring(url.lastIndexOf("=")+1, url.length);
        alert(process.env.VUE_APP_YOUTUBE_API_KEY);
        // 2. Initialize the JavaScript client library.
        window.gapi.client.init({
          'apiKey': process.env.VUE_APP_YOUTUBE_API_KEY,
          // clientId and scope are optional if auth is not required.
          // 'clientId': 'YOUR_WEB_CLIENT_ID.apps.googleusercontent.com',
          // 'scope': 'profile',
        }).then(function() {
          // 3. Initialize and make the API request.
          return window.gapi.client.request({
            'path': 'https://www.googleapis.com/youtube/v3/videos?part=snippet&id='+url,
          })
        }).then(function(response) {
          console.log(response.result);
          var title = response.result.items[0].snippet.title;
          return addBgm(url, title);
        }).then(function(){
          return getBgmList();
        }).then(function(data){
          bgmList.value = data;
        })
      }

      function addClick() {
        bgm_url.value = document.querySelector("#insert-bgm").value;
        window.gapi.load('client', start);
      }

      onMounted(async () => {
        bgmList.value = await getBgmList();
      })

      return {
        bgmList,
        bgm_url,
        start,
        addClick
      }
    },

}


</script>

<style scoped>
#offcanvasExample{
  text-align: center;
}
table {
  width : 80%;
}
.bgm-list{
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top : 10px;
  padding-bottom : 20px;
}

</style>