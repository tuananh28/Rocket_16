import * as types from "../Constants/ActionTypes";

var initialState = {
  listAccounts: [],
};

var reducer = (state = initialState, action) => {
  if (action.type === types.ADD_ACCOUNT) {
    let account = action.account;
    let listAccounts_new = [];
    listAccounts_new = state.listAccounts;
    listAccounts_new.push(account);
    return {
      ...state,
      listAccounts: listAccounts_new,
    };
  } else {
    return state;
  }
};
export default reducer;
