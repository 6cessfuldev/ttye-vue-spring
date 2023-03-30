import axios from 'axios';

export async function submitEditorContent(editorContent, diary_date) {
    axios.post('/diary/register', { 
        content: editorContent,
        diary_date: diary_date
    })
    .then(response => {
        if(response.data){
        return true;
        }else{
        alert("서버 에러");
        }
    })
    .catch(error => {
        console.log(error);
        return false;
    });
    return false;
}

//getDiaryList
export async function getDiaryList(date) {
    const response = await axios.get('/diary/list', {
        params: {
            date: date
        }
    });
    return response.data;
}