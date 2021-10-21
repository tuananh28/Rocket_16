import * as types from "../constants/ActionTypes"; // Import acctionType đê sử dụng
// Khai báo để lấy lại dữ liệu ở localStorage
let listAccounts; // khai báo biến để lưu dữ liệu lấy từ LocalStorage
if (localStorage && localStorage.getItem("listAccounts")) {
  listAccounts = JSON.parse(localStorage.getItem("listAccounts")); // Lấy dữ liệu từ LocalStorage và gán vào biến lưu trữ
}
// Khai báo các state mặc định
var initialState = listAccounts; // Khởi tạo giá trị cho State
// Khai báo reducer, truyền vào các state mặc định
var Reducer = (state = initialState, action) => {
  switch (action.type) {
    case types.GET_LIST_ACCOUNTS: // Xử lý lấy danh sách Account
      return state;
      break;

    default:
      return state; // Chú ý cần return về state mặc định nếu không sẽ gặp lỗi.
      break;
  }
};

export default Reducer;
