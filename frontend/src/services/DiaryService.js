import axios from 'axios';

export async function submitEditorContent(editorContent, diary_date, title) {
    axios.post('/diary/register', { 
        content: editorContent,
        diary_date: diary_date,
        diary_title: title,
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
export async function getDiaryList(month) {
    const response = await axios.get('/diary/list', {
        params: {
            month: month
        }
    });
    return response.data;
}