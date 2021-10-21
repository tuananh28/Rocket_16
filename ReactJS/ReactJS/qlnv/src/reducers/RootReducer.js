import { combineReducers } from "redux";
import account_reducer from "./account_reducer";
const RootReducer = combineReducers({
  listAccounts: account_reducer, // Định nghĩa ra state trả về
});

export default RootReducer;
