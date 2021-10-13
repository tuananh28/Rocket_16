import axios from "axios";

const axiosClient = axios.create({
  baseURL: `http://localhost:8080/api/v1`, // Đường link API gốc
  timeout: 5000, // default is `0` (no timeout)
  responseType: "json", // kiểu dữ liệu trả về.
});
axiosClient.interceptors.response.use(
  (response) => {
    if (response && response.data) {
      return response.data;
    }
    return response;
  },
  (error) => {
    // Handle errors
    throw error;
  }
);
export default axiosClient;
