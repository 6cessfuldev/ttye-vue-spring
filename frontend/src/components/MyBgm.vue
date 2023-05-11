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
            <table class="table table-striped">
              <thead>
                <tr>
                  <th scope="col">번호</th>
                  <th scope="col">제목</th>
                  <th scope="col">삭제</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(bgm, index) in bgmList" :key="bgm.bgm_id">
                  <th scope="row">{{index+1}}</th>
                  <td>{{bgm.bgm_title}}</td>
                  <td><button type="button" class="btn btn-danger">삭제</button></td>
                </tr>
              </tbody>
            </table>
            <ul class="pagination">
              <li class="page-item" v-if="page > 1">
                <button class="page-link" v-on:click="prevPage">이전</button>
              </li>
              <li class="page-item" v-for="i in pageList" :key="i">
                <button class="page-link" v-on:click="changePage(i)">{{i}}</button>
              </li>
              <li class="page-item" v-if="page < pageList.length">
                <button class="page-link" v-on:click="nextPage">다음</button>
              </li>
            </ul>

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

      const page = ref(1);
      const pageList = ref([]);

      const bgmList = ref([]);
      const bgm_url = ref('');

      function changePage(pageNum) {
        page.value = pageNum;
        getBgmList(pageNum).then((data) => {
          bgmList.value = data;
        });
      }

      function nextPage() {
        page.value += 1;
        getBgmList(page.value).then((data) => {
          bgmList.value = data;
        });
      }

      function prevPage() {
        page.value -= 1;
        getBgmList(page.value).then((data) => {
          bgmList.value = data;
        });
      }

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
          return getBgmList(1);
        }).then(function(data){
          bgmList.value = data;
        })
      }

      function addClick() {
        bgm_url.value = document.querySelector("#insert-bgm").value;
        window.gapi.load('client', start);
      }

      onMounted(async () => {
        bgmList.value = await getBgmList(1);
      })

      return {
        changePage,
        nextPage,
        prevPage,
        page,
        pageList,
        bgmList,
        bgm_url,
        start,
        addClick
      }
    },

}


</script>

<style scoped>
.pagination{
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top : 10px;
  padding-bottom : 20px;
  border: 1px solid #dee2e6;
  border-radius: 0.25rem;
}

.page-item{
  padding: 0.5rem;
}



.page-link{
  cursor: pointer;
}

.page-link:hover{
  background-color: #e9ecef;
}

.page-link:active{
  background-color: #e9ecef;
}

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