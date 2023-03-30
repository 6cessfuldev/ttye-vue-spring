import axios from 'axios';

export async function getBgmList() {
  try {
    const response = await axios.get("http://localhost:8080/bgm/list");
    return response.data;
  } catch (error) {
    console.error(error);
    return false;
  }
}

export async function addBgm(url, title) {

    axios.post('http://localhost:8080/bgm/add', {
        videoId : url,
        videoTitle : title
    })
    .then(function(response) {
        console.log(response);
    })
    .catch(function(error) {
        console.log(error);
    })
}