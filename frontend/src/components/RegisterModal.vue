<template>
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-header">
            <h3>회원가입</h3>
            <button class="modal-close" @click="$emit('close')">X</button>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" id="id" class="form-control">
              </div>
              <div class="form-group">
                <label for="pw">Password:</label>
                <input type="password" id="pw1" class="form-control">
              </div>
              <div class="form-group">
                <label for="pw2">Password check:</label>
                <input type="password" id="pw2" class="form-control">
              </div>
              <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" class="form-control">
              </div>
              <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" id="email" class="form-control">
              </div>
              <button type="submit" class="btn" @click="validation">Submit</button>
              <div class="form-validation">
                <span class="error-message">Invalid username or password</span>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </template>
<script>
import axios from 'axios';

export default {
  setup() {

    function validation(){
      
      var id = document.getElementById('id').value;
      var pw1 = document.getElementById('pw1').value;
      var pw2 = document.getElementById('pw2').value;
      var username = document.getElementById('username').value;
      var email = document.getElementById('email').value;

      if(id.length < 5){
        alert("아이디가 짧아요~");
        return false;
      }
      
      axios.get("http://localhost:8080/user/isExistedId", {
        params: {
          id:id
        }
      })
      .then(function(response){
        if(response.data){
          alert("중복된 아이디입니다.");
          return false;
        }

        if(pw1!=pw2){
          alert("동일한 비번을 입력해줘요~");
          return false;
        }

        axios.post("http://localhost:8080/user/register", {
          id: id,
          pw: pw1,
          userName: username,
          email: email
        })
        .then(function(response){
          if(response.data){
            alert("회원가입 되었습니다.");
          }else{
            alert("회원가입 에러!!!");
          }

          this.$emit("submit");
        })
      })
      .catch(function(error){
        alert(error);
        return false;
      })
    }
  
    return {
      validation

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
    max-height: 90vh;
    overflow-y: auto;
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
  