import RootReducer from "./Reducers/index";
import { createStore } from "redux";
import { action_IsShowInputForm, action_addAccount } from "./Action/index";
const store = createStore(RootReducer);

console.log("Before Action: ", store.getState());
// Thực hiện action action_IsShoInputForm
store.dispatch(action_IsShowInputForm());
console.log("After Action: ", store.getState());
store.dispatch(action_addAccount({ id: 1, name: "tuananh" }));
// Thực hiện action
store.dispatch(action_addAccount({ id: 1, name: "tuananh" }));
console.log("After action_addAccount: ", store.getState());
