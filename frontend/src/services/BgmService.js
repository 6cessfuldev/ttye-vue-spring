import axios from 'axios';

export async function getBgmList(pageNum) {

    return axios.get('http://localhost:8080/bgm/listWithPaging', {
        params : {
            currentPage : pageNum,
            blockCount : 10,
            blockPage : 5,
        }
    })
    .then(function(response) {
        console.log(response.data);
        return response.data;
    })
    .catch(function(error) {
        console.log(error);
    })
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