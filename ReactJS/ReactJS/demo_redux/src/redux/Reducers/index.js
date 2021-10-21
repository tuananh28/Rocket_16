import isShowInputForm from "./show_input_form";
import add_account from "./add_account";
// import add_account from "./add_account";
import { combineReducers } from "redux";

const RootReducer = combineReducers({
  isShowInputForm: isShowInputForm,
  listAccount: add_account,
});

export default RootReducer;
