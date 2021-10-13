import React, { Component } from "react";
import ResultForm_Item from "./ResultForm_Item"
class ResultForm extends Component {
  render() {
    const { listAccounts } = this.props;
    // {console.log(listAccounts)}
    return (
      <div className="container">
        <div className="form">
          <h3>Thông tin nhân viên trên hệ thống</h3>
          <table className="table table-hover" id="Detail_Staff_ID">
            <thead>
              <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Username</th>
                <th>Fullname</th>
                <th>Department</th>
                <th>Position</th>
                <th>Create Date</th>
                <th>Edit</th>
                <th>Delete</th>
              </tr>
            </thead>
            <tbody id="Result_TB">
              <ResultForm_Item
                listAccounts={listAccounts}
                onDeleteForm={this.props.onDeleteForm} // Nhận Props từ App và truyền tiếp xuống cho ResultForm_Item
                onDUpdateForm={this.props.onDUpdateForm} // Nhận Props từ App và truyền tiếp xuống cho ResultForm_Item
              />  
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ResultForm;
