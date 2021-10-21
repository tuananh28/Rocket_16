import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import RootReducer from "./reducers/RootReducer"; // Import reducer đã khai báo bên trên
import { Provider } from "react-redux"; // Import Provider.
import { createStore } from "redux"; // Import createStore.

const store = createStore(RootReducer);

ReactDOM.render(
  // <React.StrictMode>
  //   <App />
  // </React.StrictMode>,
  // Khai báo ra provider để cung cấp store
  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById("root")
);
