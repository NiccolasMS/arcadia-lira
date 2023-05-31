import axios from 'axios';

const api = axios.create({
  baseURL: "http://34.233.118.85:8080"
})

export default api;