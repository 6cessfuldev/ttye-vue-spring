<template>
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-header">
            <h3>Login</h3>
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
                <input type="password" id="pw" class="form-control">
              </div>
              <div class="button-container">
                <button class="btn" @click="login">Login</button>
              </div>
              <a href="#" @click="$emit('register')">회원가입</a>
                
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
import $ from 'jquery';

export default {
  setup() {

    function login(){

      var id = document.getElementById("id").value;
      var pw = document.getElementById('pw').value;

      alert("login");
      axios.post("http://localhost:8080/user/login", {
        id : id,
        pw : pw
      })
      .then(function(response){
        if(!response.data){
          $(".error-message").show();
          return false;
        }
        window.location.href = "/";
        return true;

      })
      .catch(function(error){
        alert(error);
      })

    }

    return {
      login,
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
    position:relative;
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

.button-container{
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.modal-body>form>a{
  text-decoration: none;
  position: absolute;
  right: 10px;
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
  