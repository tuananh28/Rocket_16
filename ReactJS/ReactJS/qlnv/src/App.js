import "./App.css";
import React, { Component } from "react";
import InputForm from "./Components/InputForm";
import ResultForm from "./Components/ResultForm";

class App extends Component {
  // hàm Constructor thực hiện khai báo các State
  constructor(props) {
    super(props);
    this.state = {
      listAccounts: [], // Tạo list này để lưu thông tin account trên hệ thống.
      isShowInputForm: false, //Tạo State đê lưu thông tin ẩn hiện Input Form, True: hiện form
    };
  }
  // được gọi trong lần render đầu tiên, đoạn lệnh này sẽ load dữ liệu từ LocalStorage và set lại vào  listAccounts quả State

  componentDidMount() {
    console.log("will mount !!");
    if (localStorage && localStorage.getItem("listAccounts")) {
      let listAccounts = JSON.parse(localStorage.getItem("listAccounts"));
      this.setState({
        listAccounts: listAccounts,
      });
    }
  }
  // // Hàm xử lý sự kiện OnClick: sẽ thực hiện tạo 1 ListAccont tĩnh, lưu dữ liệu vào State và LocalStorage.
  // createData = () => {
  //   let listAccounts = [
  //     {
  //       ID: "1",
  //       Email: "Email1@gmail.com",
  //       Username: "Username1",
  //       Fullname: "Fullname1",
  //       Department: "Sale",
  //       Position: "Scrum Master",
  //     },
  //     {
  //       ID: "2",
  //       Email: "Email2@gmail.com",
  //       Username: "Username2",
  //       Fullname: "Fullname2",
  //       Department: "Sale",
  //       Position: "Scrum Master",
  //     },
  //     {
  //       ID: "3",
  //       Email: "Email3@gmail.com",
  //       Username: "Username3",
  //       Fullname: "Fullname3",
  //       Department: "Accounting",
  //       Position: "Scrum Master",
  //     },
  //   ];
  //   // Thực hiện setState khi nhấn vào nút createData
  //   this.setState({
  //     listAccounts: listAccounts,
  //   });
  //   // Lưu dữ liệu listAccounts vào localStorage
  //   localStorage.setItem("listAccounts", JSON.stringify(listAccounts));
  // };
  // thực hiện set lại trạng thái ẩn hiện form khi click vào nút này.
  showInputForm = () => {
    this.setState({
      isShowInputForm: !this.state.isShowInputForm,
    });
  };
  // Khai báo hàm để nhận lại dữ liệu từ InputForm truyền về.
  onShowForm = () => {
    console.log("On Show This Form");
    this.setState({
      isShowInputForm: !this.showInputForm,
    });
  };
  onSaveForm = (data) => {
    console.log(data); // Kiểm tra lại dữ liệu nhận được từ InputForm
    let listAccounts = this.state.listAccounts;
    listAccounts.push(data); // push dữ liệu vào listAccount hiện tại
    this.setState({
      listAccounts: listAccounts,// Thực hiện set lại State
    });
    // Thực hiện lưu dữ liệu vào LocalStorage
    localStorage.setItem("listAccounts", JSON.stringify(listAccounts));
  };
  render() {
    let listAccounts = this.state.listAccounts;
    // Khai báo biến để lấy lại State isShowInputForm dùng show form
    let isShowInputForm = this.state.isShowInputForm;
    // Khai báo biến để render inputForm
    let inputForm_Element;
    // Kiểm tra điều kiện và render Form
    if (isShowInputForm) {
      inputForm_Element = <InputForm onShowForm={this.onShowForm} onSaveForm={this.onSaveForm} />; // Bổ sung thêm Props cho InputForm khi truyền đi
    } else {
      inputForm_Element = "";
    }
    return (
      <div className="App">
        <div className="container">
          <input
            type="button"
            className="btn btn-success"
            id="Create_btn"
            value="Create Account"
            onClick={this.showInputForm}
          ></input>
          {/* Tạo thêm nút Create Data và sự kiện  onClick để generate dữ liệu trong lần đầu tiên
            Tạo thêm hàm arror createData để xử lý sự kiện cho nút Submit
        */}
          {/* <input
            type="button"
            className="btn btn-success"
            id="Create_btn"
            value="Create Data"
            onClick={this.createData}
          ></input> */}
          {inputForm_Element}
          <ResultForm listAccounts={listAccounts} />
        </div>
      </div>
    );
  }
}

export default App;
