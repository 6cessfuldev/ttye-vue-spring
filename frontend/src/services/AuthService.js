import axios from 'axios';

export async function checkLoginStatus() {
  try {
    const response = await axios.get('http://localhost:8080/user/isLoggedIn');
    return response.data;
  } catch (error) {
    console.error(error);
    return false;
  }
}

export async function checkMatchStatus() {
    try {
      const response = await axios.get('http://localhost:8080/user/isMatched');
      return response.data;
    } catch (error) {
      console.error(error);
      return false;
    }
  }