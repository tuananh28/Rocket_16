import { createStore } from "redux";

//  Bước 3: Tạo ra initialState
var initialState = {
  isShowInputForm: false,
  listAccount: [],
};

// Bước 4: Tạo ra Action
var action_IsShowInputForm = {
  type: "SHOW_INPUT_FORM",
};

//  Bước 2: Tạo reducer

var reducer = (state = initialState, action) => {
  // Khai Switch Case vì trong reducer phải xử lý nhiều action
  switch (action.type) {
    case "SHOW_INPUT_FORM": // dùng để xử lý action Showinputform
      let isShowInputForm; // khai báo biến mới để trả về
      isShowInputForm = !state.isShowInputForm; // gán biến isShowInputForm là giá trị !state.isShowInputForm;
      return {
        ...state, // Copy lại state cũ
        isShowInputForm: isShowInputForm,
      };
    // trả về 1 state mới sau khi reducer xửu lý xong
    case "ADD_ACCOUNT": // dùng để xử lý action Showinputform
      let account = action.account; //Lấy account truyền vào
      let listAccount_new = [];
      listAccount_new = state.listAccount;
      listAccount_new.push(account);
      console.log("List account sau khi add thêm account", listAccount_new);
      return {
        ...state,
        listAccount: listAccount_new,
      };
    default:
      return state; // Chú ý cần return về state mặc định nếu không sẽ gặp lỗi.
  }
};

//  Bước 1: Tạo ra Store Redux,
const store = createStore(reducer);

//  Bước 5: Sau khi khai báo xong redux, thực hiện gọi các action đê thay đổi state.
console.log("State ban đầu :", store.getState()); // Hàm getState() trả về các state của Store quản lý

store.dispatch(action_IsShowInputForm); // gửi action đến reducer redux để xử lý thông qua dispatcher
console.log("State sau khi thay đổi bởi redux: ", store.getState());

// Bước 6: Khai báo thêm action để thêm mới Account vào List

var action_addAccount = {
  type: "ADD_ACCOUNT",
  account: {
    id: 1,
    name: "tuananh",
  },
};
// Gọi Action để Reducer thực thi.
store.dispatch(action_addAccount);
console.log("BƯỚC 6: Sau khi khi gọi action_addAccount", store.getState());
