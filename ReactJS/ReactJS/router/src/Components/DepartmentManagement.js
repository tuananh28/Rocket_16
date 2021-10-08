import React, { Component } from "react";
import {Redirect} from "react-router-dom";
import Swal from 'sweetalert2'

export default class DepartmentManagement extends Component {
  render() {
    var user_login = JSON.parse(localStorage.getItem("user.login"));
    if (!user_login) {
      Swal.fire({
        title: "Error",
        icon: 'warning',
        text: "Hãy đăng nhập hệ thống để xem nội dung này.",
      });
      return <Redirect to="/Login" />;
    }
    return (
      <div>
        <h2>This is Department Management Page</h2>
      </div>
    );
  }
}
