import "./App.css";
import React, { Component } from "react";
import InputForm from "./Components/InputForm";
import ResultForm from "./Components/ResultForm";
import SearchForm from "./Components/SearchForm";

class App extends Component {
  // hàm Constructor thực hiện khai báo các State
  constructor(props) {
    super(props);
    this.state = {
      listAccounts: [], // Tạo list này để lưu thông tin account trên hệ thống.
      isShowInputForm: false, // Tạo State đê lưu thông tin ẩn hiện Input Form, True: hiện form
      accountUpdate: null, // Tạo thêm 1 đối tượng State để lưu thông tin của Account cần update thông tin
      search_key: null,
    };
  }
  // được gọi trong lần render đầu tiên, đoạn lệnh này sẽ load dữ liệu từ LocalStorage và set lại vào  listAccounts quả State
  componentWillMount() {
    console.log("will mound!!");
    if (localStorage && localStorage.getItem("listAccounts")) {
      let listAccounts = JSON.parse(localStorage.getItem("listAccounts"));
      this.setState({
        listAccounts: listAccounts,
      });
    }
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

  onSaveForm = (data) => {
    console.log(data); // Kiểm tra lại dữ liệu nhận được từ InputForm
    let listAccounts = this.state.listAccounts;
    listAccounts.push(data); // push dữ liệu vào listAccount hiện tại
    this.setState({
      listAccounts: listAccounts, // Thực hiện set lại State
    });
    // Thực hiện lưu dữ liệu vào LocalStorage
    localStorage.setItem("listAccounts", JSON.stringify(listAccounts));
  };
  // Hàm xử lý Delete dữ liệu
  onDeleteForm = (id) => {
    // console.log("this is App: " + id) // Kiểm tra giá trị id nhận được từ ResultForm_Item
    let listAccounts = this.state.listAccounts;
    let indexAccountDel = listAccounts.findIndex(
      (account) => account.ID === id
    );
    // dùng để lấy index của phần tử trong mảng cần xóa, chú ý ID phải map với tên trường khi tạo list.
    console.log(indexAccountDel);
    // indexAccountDel != -1 là đã tìm thấy bản ghi
    if (indexAccountDel !== -1) {
      listAccounts.splice(indexAccountDel, 1);
      this.setState({
        listAccounts: listAccounts,
      });
      localStorage.setItem("listAccounts", JSON.stringify(listAccounts));
    }
  };

  // Hàm xử lý onDUpdateForm dữ liệu
  onDUpdateForm = (id) => {
    // console.log("this is App: " + id) // Kiểm tra giá trị id nhận được từ ResultForm_Item
    let listAccounts = this.state.listAccounts;
    let indexAccountUpdate = listAccounts.findIndex(
      (account) => account.ID === id
    );
    // dùng để lấy index của phần tử trong mảng cần Update, chú ý ID phải map với tên trường khi tạo list.
    console.log(indexAccountUpdate);
    // indexAccountDel != -1 là đã tìm thấy bản ghi
    if (indexAccountUpdate !== -1) {
      // listAccounts[indexAccountUpdate]
      // Thực hiện showform input để hiển thị thông tin bằng cách set state cho isShowInputForm = true
      let isShowInputForm = this.state.isShowInputForm;
      isShowInputForm = true;
      this.setState({
        isShowInputForm: isShowInputForm,
      });
      // gán giá trị cho accountUpdate để truyền đi
      let accountUpdate = listAccounts[indexAccountUpdate];
      this.setState({
        accountUpdate: accountUpdate,
      });
    }
  };

  // Xử lý sự kiện khi nhấn nút Update trong InputForm.
  update_Account_Button = (data) => {
    console.log(data);
    let listAccounts = this.state.listAccounts;
    let indexAccount_Update = listAccounts.findIndex(
      (account) => account.ID === data.ID
    );
    if (indexAccount_Update !== -1) {
      console.log(data);
      listAccounts[indexAccount_Update] = data; // Thực hiện sửa lại Account theo data nhận được
      this.setState({
        listAccounts: listAccounts,
      });
    }
  };

  // SEARCH
  onSearchForm = (search_key) => {
    console.log("App Search : " + search_key);
    this.setState({
      search_key: search_key,
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
      inputForm_Element = (
        <InputForm
          onshowForm={this.onShowForm} // Truyền Props xuống inputForm
          onSaveForm={this.onSaveForm}
          accountUpdate={accountUpdate} // Truyền dữ liệu xuống InputForm
          update_Account_Button={this.update_Account_Button}
        />
      ); // Bổ xung thêm Props cho InputForm khi truyền đi
    } else {
      inputForm_Element = "";
    }
    // Xử lý render khi có search_key, sẽ giới hạn lại list trả về cho ResultForm trong listAccounts bằng hàm fillter
    // Khai báo để lấy giá trị của search_key
    let search_key = this.state.search_key;
    if (search_key) {
      // Sử dụng hàm fillter để lọc các giá trị phần tử của mảng
      // listAccounts =  listAccounts.filter((account) =>{
      //   return account.Username.toLowerCase().indexOf(search_key.toLowerCase()) !==-1;
      // });

      let listAccounts_filter = []; // khai báo list dùng để chưa các giá trị sau khi filter.
      for (let index = 0; index < listAccounts.length; index++) {
        // Sử dụng hàm includes để so sánh chuỗi, if chuỗi cha bao gồm chuỗi con sẽ trả về true, https://www.w3schools.com/jsref/jsref_includes.asp
        if (
          listAccounts[index].ID.toLowerCase().includes(
            search_key.toLowerCase()
          ) ||
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
          ) // ) ||
          // listAccounts[index].Create_Date.toLowerCase().includes(
          //   search_key.toLowerCase()
          // )
        ) {
          listAccounts_filter.push(listAccounts[index]); // Lấy các phần tử thỏa mãn đk search_key lưu vào listAccounts_filter trung gian
        }
      }
      listAccounts = listAccounts_filter; // gán lại giá trị sau khi đã filter cho listAccounts.
    }
    return (
      <div className="App">
        <div className="container">
          {/* Hàm OnClick sẽ thực hiện xử lý việc ẩn hiện Form */}
          <input
            type="button"
            className="btn btn-success"
            id="Create_btn"
            value="Create Account"
            onClick={this.showInputForm}
          ></input>
          {inputForm_Element}
          <SearchForm onSearchForm={this.onSearchForm}></SearchForm>
          <ResultForm
            listAccounts={listAccounts}
            onDeleteForm={this.onDeleteForm} // Truyền Props xuống ResultForm
            onDUpdateForm={this.onDUpdateForm} // Truyền Props xuống ResultForm
          />
        </div>
      </div>
    );
  }
}

export default App;
