import React, { Component } from "react";
import { Redirect } from "react-router-dom";
import Swal from "sweetalert2";
class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // Khai báo thêm các State để lưu trữ ở đây
      Email: "",
      Password: "",
      isRedirect: false, // Khai báo để lưu thông tin xem có redirect tới trang AccounManagemnent không sau khi login
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
    });
  }

  handleSubmit(event) {
    // name và value lấy theo các thuộc tính ở input
    // alert('Email: ' + this.state.Email);
    // alert('Password: ' + this.state.Password);
    var user = JSON.parse(localStorage.getItem("user")); // Lấy lại thông tin đã lưu ở localStorage sau khi đăng ký thành công.
    if (
      user.Email === this.state.Email &&
      user.Password === this.state.Password
    ) {
      Swal.fire({
        title: "Success",
        icon: "success",
        text: "Đăng nhập thành công.",
      });
      var user_login = {
        Email: this.state.Email,
        Password: this.state.Password,
      };
      var json = JSON.stringify(user_login);
      localStorage.setItem("user_login", json); // Nếu đăng nhập thành công thì thực hiện lưu thông tin user_login xuống localStorage để xử lý
      // Thực hiện set lại state cho isRedirect, chuyển thành true
      this.setState({
        isRedirect: true, // set lại state này bằng true để thực hiện redirect
      });
      // window.open('Home.html', '_self')
    } else {
      Swal.fire({
        title: "Info",
        icon: "warning",
        text: "Kiểm tra lại thông tin.",
      });
    }
  }

  render() {
    console.log(this.state.isRedirect);
    if (this.state.isRedirect) {
      return <Redirect to="/AccountManagement" />; // Nếu bằng True là đã login thì thực hiện redirect tới trang AccountManagement luôn.
    }
    var user_login = JSON.parse(localStorage.getItem("user_login")); // Lấy lại thông tin user_login đã lưu ở LocalStorage nếu tồn là đã login, nếu chưa có thì redirect tới trang login
    if (user_login) {
      const location = this.props.location;
      return (
        <Redirect
          to={{
            pathname: "/AccountManagement",
            state: {
              from: location,
            },
          }}
        />
      );
      // Khai báo "to" dưới dạng 1 đối tượng, trong đó sẽ truyền pathname: là trang đích
      // state: là state gửi kèm, ở đây là thông tin của component gốc.
      //'/AccountManagement' />;   // Thực hiện gửi kèm các thông tin tới AccountManagement
    }
    return (
      <div className="container" style={{ width: "70%" }}>
        <div className="row">
          <div className="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <br />
            <br />
            <br />
            <h3>LOGIN</h3>
            <br />
            <div className="form-group">
              <label for="Email">Email:</label>
              <input
                type="email"
                required="true"
                className="form-control"
                id="Email_Login_id"
                name="Email"
                value={this.state.Email}
                onChange={this.handleChange}
                placeholder="Enter email"
              />
            </div>
            <div className="form-group">
              <label for="Password">Password:</label>
              <input
                type="Password"
                required="true"
                className="form-control"
                id="Password_Login_id"
                name="Password"
                value={this.state.Password}
                onChange={this.handleChange}
                placeholder="Enter Password"
              />
            </div>
            <button
              type="submit"
              className="btn btn-info"
              onClick={this.handleSubmit}
            >
              Login
            </button>
          </div>
        </div>
      </div>
    );
  }
}

export default Login;
