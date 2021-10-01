/* eslint-disable react/jsx-pascal-case */
import React, { Component } from "react";
import ResultForm_Item from "./ResultForm_item";

export default class ResultForm extends Component {
  render() {
    const { listAccounts } = this.props;
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
                <th>Cretate Date</th>
                <th>Edit</th>
                <th>Delete</th>
              </tr>
            </thead>
            <tbody id="Result_TB">
              {/* <ResultForm_Item /> */}

              <ResultForm_Item listAccounts={listAccounts} />
              
              {/* <ResultForm_Item
                ID="1"
                Email="tuananh@gmail.com"
                Username="tuananh"
                Fullname="Bùi Tuấn Anh"
                Department="Accounting"
                Position="Scrum Master"
                Create_Date="01/10/2021"
              />
              <ResultForm_Item
                ID="2"
                Email="hoamai@gmail.com"
                Username="hoamai"
                Fullname="Bùi Thị Hoa Mai"
                Department="Engineering"
                Position="Developer"
                Create_Date="03/06/2021"
              />    */}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}
