<template>
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-header">
            <h3>짝꿍 찾기</h3>
            <button class="modal-close" @click="$emit('close')">X</button>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" id="id" class="form-control">
              </div>
              <button type="submit" class="btn" @click="match">Match</button>
              <div class="form-validation">
                <span class="error-message not-exist">찾는 짝이 없어요..!</span>
                <span class="error-message already-partner">이미 짝꿍이 있는 사람이에요..</span>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
import axios from 'axios';
import $ from 'jquery';

export default {
  setup(props, context) {

    function resetError(){
      $(".error-message").hide();
    }

    function match(){

      console.log(props);

      var id = document.getElementById("id").value;

      axios.get("http://localhost:8080/user/checkPartner", {
          params: {
            id: id
          }
        }
      )
      .then(function(response){
        if(response.data==1){
          resetError();
          $(".not-exist").show();
          return false;  
        }
        if(response.data==2){
          resetError();
          $(".already-partner").show();
          return false;
        }
        
        //신청 후 대기 상태
        if(response.data==3){
          axios.post("http://localhost:8080/user/waiting", {
            id: id
          })
          .then(function(response){
            if(response.data){
              alert("매칭 신청했습니다.");
              context.emit("matching");
              return true;
            }
          })
        }

        //이미 나를 신청한 사람에게 신청한 경우
        if(response.data==4){
          axios.post("http://localhost:8080/user/matching", {
            id: id
          
          })
          .then(function(response){
            if(response.data){
              alert("매칭 완료했습니다.");
              context.emit("matching");
              return true;
            }
          })
        }
        return false;
      })
      .catch(function(error){
        alert(error);
      })

    }

    return {
      match,
      resetError
    }

  }
}
</script>

  <style scoped>
  .modal-mask {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .modal-wrapper {
    width: 90%;
    max-width: 500px;
  }
  
  .modal-container {
    background-color: #fff;
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  }
  
  .modal-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .modal-header h3 {
    margin: 0;
  }
  
  .modal-close {
    background-color: transparent;
    border: none;
    font-size: 1.5rem;
    cursor: pointer;
  }
  
  .modal-body {
    margin-top: 20px;
  }

  .form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 10px;
  font-weight: bold;
}

.form-control {
  width: 100%;
  padding: 10px;
  border-radius: 5px;
  border: 2px solid #f49ac1;
  transition: border-color 0.3s;
}

.form-control:focus {
  outline: none;
  border-color: #c29de3;
}

.btn {
  background-color: #f49ac1;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 20px;
  font-size: 1.2rem;
  transition: background-color 0.3s;
}

.btn:hover {
  background-color: #c29de3;
}

.form-validation {
  margin-top: 10px;
  text-align: center;
}

.error-message {
  display: none;
  color: red;
}
  </style>
  