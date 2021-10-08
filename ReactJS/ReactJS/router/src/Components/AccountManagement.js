import React, { Component } from "react";
import { Redirect } from "react-router-dom";
import Swal from "sweetalert2";

export default class AccountManagement extends Component {
  listAccounts = [
    {
      ID: "1",
      Email: "Email1@gmail.com",
    },
    {
      ID: "2",
      Email: "Email2@gmail.com",
    },
    {
      ID: "3",
      Email: "Email3@gmail.com",
    },
    {
      ID: "4",
      Email: "Email4@gmail.com",
    },
  ];

  render() {
    const location = this.props.location;
    console.log("Thông tin location", location);
    var user_login = JSON.parse(localStorage.getItem("user.login"));
    if (!user_login) {
      Swal.fire({
        title: "Error",
        icon: "warning",
        text: "Hãy đăng nhập hệ thống để xem nội dung này.",
      });
      return <Redirect to="/Login" />;
    }
    // Khai báo biến để in ra các row trong bảng
    const row_Account = this.listAccounts.map((account, index) => {
      return (
        <>
          <tr>
            <td>{account.ID}</td>
            <td>{account.Email}</td>
          </tr>
        </>
      );
    });
    return (
      <div className="row">
        <h3>Thông tin Account</h3>
        <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
          <table className="table table-hover">
            <thead>
              <tr>
                <td>ID</td>
                <td>Email</td>
              </tr>
            </thead>
            <tbody>
              {/* In các row */}
              {row_Account}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}
