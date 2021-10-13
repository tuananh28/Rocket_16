import Api from "./Api";
const url = "/accounts";

// Hàm getAllAccounts
const getAllAccounts = () => {
  return Api.get(url);
};

// Get ID Account
const getbyID = (id) => {
  return Api.get(`${url}/${id}`);
};

// Hàm tạo mới Account
const createAccount = (body) => {
  return Api.post(url, body);
};

// Hàm update
const updateAccount = (id, body) => {
  return Api.put(`${url}/${id}`, body);
};
// HÀm xóa
const deleteAccount = (id) => {
  return Api.delete(`${url}/${id}`);
};

//export
const AccountApi = { getAllAccounts, getbyID,createAccount, updateAccount, deleteAccount };
export default AccountApi;
