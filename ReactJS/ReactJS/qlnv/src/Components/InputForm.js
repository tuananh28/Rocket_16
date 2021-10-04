import React, { Component } from "react";

export default class InputForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // Khai báo thêm các State để lưu trữ ở đây
      ID: "",
      Email: "",
      Username: "",
      Fullname: "",
      Department: "",
      Position: "",
      Create_Date: "",
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
    let account = {
      ID: this.state.ID,
      Email: this.state.Email,
      Username: this.state.Username,
      Fullname: this.state.Fullname,
      Department: this.state.Department,
      Position: this.state.Position,
      Cretate_Date: this.state.Create_Date,
    };
    this.props.onSaveForm(account);

    event.preventDefault(); // Hàm này để ngăn reddicrect đến trang khác
  }

  // Hàm xử lý sự kiện onShowForm.
  onShowForm = () => {
    this.props.onShowForm();
  };
  render() {
    return (
      <div className="form">
        <h3>Quản lý nhân viên</h3>
        <form method="" id="Main_Form_ID">
          <div className="form-group">
            <label htmlFor="">ID: </label>
            <input
              type="number"
              required="true"
              className="form-control"
              id="ID_ID"
              placeholder="Enter Id"
              name="ID"
              value={this.state.ID}
              onChange={this.handleChange}
            ></input>
          </div>
          <div className="form-group">
            <label htmlFor="">Email: </label>
            <input
              type="email"
              required="true"
              className="form-control"
              id="Email_ID"
              placeholder="Enter Email"
              name="Email"
              value={this.state.Email}
              onChange={this.handleChange}
            ></input>
          </div>
          <div className="form-group">
            <label htmlFor="">Username: </label>
            <input
              type="text"
              required="true"
              className="form-control"
              id="Username_ID"
              placeholder="Enter Username"
              name="Username"
              value={this.state.Username}
              onChange={this.handleChange}
            ></input>
          </div>
          <div className="form-group">
            <label htmlFor="">Fullname: </label>
            <input
              type="text"
              required="true"
              className="form-control"
              id="Fullname_ID"
              placeholder="Enter Fullname"
              name="Fullname"
              value={this.state.Fullname}
              onChange={this.handleChange}
            ></input>
          </div>
          <div className="form-group">
            <label htmlFor="sel1">Select a Department:</label>
            <select
              className="form-control"
              id="Department_ID"
              name="Department"
              value={this.state.Department}
              onChange={this.handleChange}
            >
              <option>--Select a Department--</option>
              <option>Accounting</option>
              <option>Business Development</option>
              <option>Engineering</option>
              <option>Human Resources</option>
              <option>Research and Development</option>
            </select>
          </div>
          <div className="form-group">
            <label htmlFor="sel1">Select a Position:</label>
            <select
              className="form-control"
              id="Position_ID"
              name="Position"
              value={this.state.Position}
              onChange={this.handleChange}
            >
              <option>--Select a Position--</option>
              <option>Developer</option>
              <option>Tester</option>
              <option>Scrum Master</option>
              <option>PM</option>
            </select>
          </div>
          <div className="form-group">
            <label htmlFor="">Cretate Date: </label>
            <input
              type="date"
              required="true"
              className="form-control"
              id="Cretate_Date_ID"
              name="Create_Date"
              value={this.state.Create_Date}
              onChange={this.handleChange}
            ></input>
          </div>
          <div className="form-group">
            <input
              type="submit"
              className="btn btn-success"
              value="Save"
              onClick={this.handleSubmit}
            ></input>
            <input
              type="button"
              className="btn btn-success"
              id="update_btn"
              value="Update"
            ></input>
            <input
              type="button"
              className="btn btn-success"
              id="reset_btn"
              value="Reset"
            ></input>
            {/* Bổ xung thêm nút Close khi render, và sự kiện onClick, hàm xử lý sự kiên onShowForm */}
            <input
              type="button"
              class="btn btn-danger"
              value="Close"
              onClick={this.onShowForm}
            ></input>
          </div>
        </form>
      </div>
    );
  }
}
