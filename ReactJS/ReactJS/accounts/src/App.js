import "./App.css";
import React, { Component } from "react";
import InputForm from "./components/InputForm";
import ResultForm from "./components/ResultForm";
import SearchForm from "./components/SearchForm"; // Import searchForm
import AccountApi from "./Api/AccountApi";

class App extends Component {
  // hàm Constructor thực hiện khai báo các State
  constructor(props) {
    super(props);
    this.state = {
      listAccounts: [], // Tạo list này để lưu thông tin account trên hệ thống.
      isShowInputForm: false, // Tạo State đê lưu thông tin ẩn hiện Input Form, True: hiện form
      accountUpdate: null, // Tạo thêm 1 đối tượng State để lưu thông tin của Account cần update thông tin
      search_key: null, // State dùng trong tìm kiếm
    };
  }

  getlistAccounts = async () => {
    try {
      const response = await AccountApi.getAllAccounts();
      console.log("Thông tin asyn: response: ", response);
      let listAccounts_API = response;
      let listAccounts = [];
      for (let index = 0; index < listAccounts_API.length; index++) {
        let account = {
          ID: listAccounts_API[index].id,
          Email: listAccounts_API[index].email,
          Username: listAccounts_API[index].username,
          Fullname: listAccounts_API[index].fullname,
          Department: listAccounts_API[index].department,
          Position: listAccounts_API[index].position,
          Create_Date: listAccounts_API[index].createDate,
        };
        listAccounts.push(account); // đổ dữ liệu vào list
      }
      this.setState({
        listAccounts: listAccounts, // Đổ dữ liệu vào State đang lưu listAccounts.
      });
    } catch (error) {
      alert("Đã xảy ra lỗi khi load dữ liệu Account!!");
    }
  };

  // được gọi trong lần render đầu tiên, đoạn lệnh này sẽ load dữ liệu từ LocalStorage và set lại vào  listAccounts quả State
  componentWillMount() {
    console.log("will mound!!");
    // Comment đoạn lệnh này lại, do sử dụng DB không cần lưu dữ liệu trên LocalStorage nữa.
    // if (localStorage && localStorage.getItem('listAccounts')) {
    //   let listAccounts = JSON.parse(localStorage.getItem('listAccounts'));
    //   this.setState({
    //     listAccounts: listAccounts
    //   });
    // }
    this.getlistAccounts(); // Goi hàm khi Mount componet App.
  }

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

  onSaveForm = async (data) => {
    try {
      const body = {
        email: data.Email, // data.Email lấy theo state của InputForm
        username: data.Username, // data.Username lấy theo state của InputForm
        fullname: data.Fullname, // data.Fullname lấy theo state của InputForm
        departmentId: data.Department, // data.Department giá trị này được truyền theo value của thẻ select, ở đây đã trả ra depID
        positionId: data.Position, // data.Position giá trị này được truyền theo value của thẻ select, ở đây đã trả ra posID
      };
      await AccountApi.createAccount(body);
      this.getlistAccounts(); // gọi lại hàm này để cập nhật dữ liệu sau khi thêm mới thành công
    } catch (error) {
      alert("Đã xảy ra lỗi khi thêm mới Account vào hệ thống !!");
    }
  };

  // Hàm xử lý Delete dữ liệu
  onDeleteForm = async (id) => {
    try {
      await AccountApi.deleteAccount(id);
      this.getlistAccounts(); // gọi lại hàm này để cập nhật dữ liệu sau khi xóa thành công.
    } catch (error) {
      alert("Đã xảy ra lỗi khi xóa Account trên hệ thống !!");
    }
  };

  // Hàm xử lý onDUpdateForm dữ liệu
  onDUpdateForm = (id) => {
    console.log("ID của Account cần update: ", id);
    let listAccounts = this.state.listAccounts;
    let indexAccountUpdate = listAccounts.findIndex(
      (account) => account.ID === id
    );
    if (indexAccountUpdate !== -1) {
      // let isShowInputForm = this.state.isShowInputForm;
      // isShowInputForm = true;
      this.setState({
        isShowInputForm: true,
      });

      console.log("Index của Account cần update: ", indexAccountUpdate);
      let accountUpdate = listAccounts[indexAccountUpdate];
      console.log("Thông tin Account cần update: ", accountUpdate);
      // Set lại State cho accountUpdate
      this.setState({
        accountUpdate: accountUpdate,
      });
    }
  };
  // Hàm xử lý update dữ liệu vào list
  update_Account_Button = async (data) => {
    try {
      let id = data.ID;
      const body = {
        fullname: data.Fullname, // data.Fullname lấy theo state của InputForm
        departmentId: data.Department, // data.Department giá trị này được truyền theo value của thẻ select, ở đây đã trả ra depID
        positionId: data.Position, // data.Position giá trị này được truyền theo value của thẻ select, ở đây đã trả ra posID
      };
      await AccountApi.updateAccount(id, body);
      this.getlistAccounts(); // gọi lại hàm này để cập nhật dữ liệu sau khi thêm mới thành công
    } catch (error) {
      alert("Đã xảy ra lỗi khi update Account trên hệ thống !!");
    }
  };

  // Xử lý search dữ liệu
  onSearchForm = (data) => {
    console.log("Dữ liệu search từ APP: ", data);
    this.setState({
      search_key: data,
    });
  };
  render() {
    let listAccounts = this.state.listAccounts;
    // Khai báo biến để lấy lại State isShowInputForm dùng show form
    let isShowInputForm = this.state.isShowInputForm;
    // Khai báo biến để render inputForm
    let inputForm_Element;
    // Kiểm tra điều kiện và render Form
    let accountUpdate = this.state.accountUpdate; // lấy lại  accountUpdate để truyền xuống InputForm

    if (isShowInputForm) {
      inputForm_Element = 
        <InputForm
          onshowForm={this.onshowForm}
          onSaveForm={this.onSaveForm}
          accountUpdate={accountUpdate}
          update_Account_Button={this.update_Account_Button}
        />
    } else {
      inputForm_Element = '';
    }
    // Xử lý render cho search
    let search_key = this.state.search_key;

    if (search_key) {
      let listAccounts_filter = [];
      for (let index = 0; index < listAccounts.length; index++) {
        // Sử dụng hàm includes để so sánh chuỗi, if chuỗi cha bao gồm chuỗi con sẽ trả về true, https://www.w3schools.com/jsref/jsref_includes.asp
        if (
          // listAccounts[index].ID.toLowerCase().includes(
          //   search_key.toLowerCase()
          // ) ||
          listAccounts[index].Email.toLowerCase().includes(
            search_key.toLowerCase()
          ) ||
          listAccounts[index].Username.toLowerCase().includes(
            search_key.toLowerCase()
          ) ||
          listAccounts[index].Fullname.toLowerCase().includes(
            search_key.toLowerCase()
          ) ||
          listAccounts[index].Department.toLowerCase().includes(
            search_key.toLowerCase()
          ) ||
          listAccounts[index].Position.toLowerCase().includes(
            search_key.toLowerCase()
          ) ||
          listAccounts[index].Create_Date.toLowerCase().includes(
            search_key.toLowerCase()
          )
        ) {
          listAccounts_filter.push(listAccounts[index]); // Lấy các phần tử thỏa mãn đk search_key lưu vào listAccounts_filter trung gian
        }
      }
      listAccounts = listAccounts_filter;
    }
    //
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
          {inputForm_Element}
          {/* ô search dữ liệu */}
          <SearchForm onSearchForm={this.onSearchForm} />
          {/*  */}
          <ResultForm
            listAccounts={listAccounts}
            onDeleteForm={this.onDeleteForm}
            onDUpdateForm={this.onDUpdateForm}
          />
        </div>
      </div>
    );
  }
}

export default App;
