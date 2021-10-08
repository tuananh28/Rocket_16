import React, { Component } from "react";
import { Prompt } from "react-router-dom";
import Swal from "sweetalert2";
export default class SignUp extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // Khai báo thêm các State để lưu trữ ở đây
      Full_Name: "",
      Email: "",
      Password: "",
      Re_Password: "",
      Birthday: "",
      isBlocking: false,
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    // name và value lấy theo các thuộc tính ở input
    let name = event.target.name;
    let value = event.target.value;
    // Thực hiện setState theo name và value lấy được
    this.setState({
      [name]: value,
      isBlocking: event.target.value.length > 0, // Trả về true nếu form nhập liệu có dữ liệu, false nếu không có dữ liệu
    });
  }

  handleSubmit(event) {
    var user = {
      FullName: this.state.Full_Name,
      Email: this.state.Email,
      Password: this.state.Password,
      Birthday: this.state.Birthday,
    };
    Swal.fire({
      title: "Success",
      icon: 'success',
      text: "Đăng ký thành công.",
    });
    var json = JSON.stringify(user);
    localStorage.setItem("user", json);
  }
  render() {
    return (
      <div className="container">
        <Prompt
          when={this.state.isBlocking} // Nếu false sẽ mặc định cho thoát, nếu bằng true sẽ thực hiện hiện thông báo confirm trước khi thoát, nhấn OK mưới thoát
          message={(location) => "Bạn có chắc chắn muốn thoát không?"} // Hiện alert thông báo trước khi thoát.
        />

        <div className="row">
          <div className="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <h3>Register System</h3>

            <div className="form-group">
              <label for="">Full Name: </label>
              <input
                type="text"
                required="true"
                className="form-control"
                id="Full_Name_ID"
                name="Full_Name"
                value={this.state.Full_Name}
                onChange={this.handleChange}
                placeholder="Enter Fullname"
              />
            </div>
            <div className="form-group">
              <label for="">Email: </label>
              <input
                type="email"
                required="true"
                className="form-control"
                id="Email_ID"
                name="Email"
                value={this.state.Email}
                onChange={this.handleChange}
                placeholder="Enter Email"
              />
            </div>
            <div className="form-group">
              <label for="">Password: </label>
              <input
                type="password"
                required="true"
                className="form-control"
                id="Password_ID"
                name="Password"
                value={this.state.Password}
                onChange={this.handleChange}
                placeholder="Enter Password"
              />
            </div>
            <div className="form-group">
              <label for="">Confirmation Password: </label>
              <input
                type="password"
                required="true"
                className="form-control"
                id="Re_Password_ID"
                name="Re_Password"
                value={this.state.Re_Password}
                onChange={this.handleChange}
                placeholder="Enter Password"
              />
            </div>
            <div className="form-group">
              <label for="">Birthday: </label>
              <input
                type="date"
                required="true"
                className="form-control"
                id="Birthday_ID"
                name="Birthday"
                value={this.state.Birthday}
                onChange={this.handleChange}
                placeholder="Choose Birthday"
              />
            </div>
            <div className="form-group">
              <input
                type="submit"
                className="btn btn-success"
                onClick={this.handleSubmit}
                value="Register"
              />
            </div>
          </div>
        </div>
      </div>
    );
  }
}
