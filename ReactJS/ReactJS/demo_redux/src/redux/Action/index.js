import * as types from "../Constants/ActionTypes";

export const action_IsShowInputForm = () => {
  return {
    type: types.SHOW_INPUT_FORM,
  };
};

// Hàm add account vào list
// Hàm này sẽ có đầu vào là 1 account cần Add vào listAccount

export const action_addAccount = (account) => {
  return {
    type: types.ADD_ACCOUNT,
    account: account, // Truyền tham số account
  };
};
