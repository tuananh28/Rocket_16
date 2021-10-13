import React, { Component } from "react";

class ResultForm_Item extends Component {
  constructor(props) {
    super(props);
    this.Create_Date = "22/06/2021";
    // this.onDeleteForm = this.onDeleteForm.bind(this);
  }
  // Xử lý sự kiện khi click nút delete
  onDeleteForm1 = (id) => {
    // console.log(id); // sử dụng id để lấy lại giá trị truyền vào
    this.props.onDeleteForm(id);
  };
  // Xử lý sự kiện khi click nút Update
  onDUpdateForm = (id) => {
    // console.log(id); // sử dụng id để lấy lại giá trị truyền vào
    this.props.onDUpdateForm(id);
  };
  render() {
    let listAccounts = this.props.listAccounts;
    const rows = listAccounts.map((row, index) => {
      return (
        // <React.Fragment>
        <>
          <tr>
            <td>{row.ID}</td>
            <td>{row.Email}</td>
            <td>{row.Username}</td>
            <td>{row.Fullname}</td>
            <td>{row.Department}</td>
            <td>{row.Position}</td>
            <td>{row.Create_Date}</td>
            <td>
              <button
                className="btn btn-warning"
                onClick={() => this.onDUpdateForm(row.ID)}
              >
                Update
              </button>
            </td>
            <td>
              <button
                className="btn btn-warning"
                onClick={() => this.onDeleteForm1(row.ID)}
              >
                Delete
              </button>
            </td>
            {/* Viết thêm sự kiện onClick, thêm hàm xử lý onDeleteForm
                            Chú ý viết hàm arror function và truyền vào row.ID trong tham số đê truyền theo ID dùng xóa dữ liệu
                        */}
          </tr>
        </>
        // </React.Fragment >
      );
    });
    return rows;
  }
}

export default ResultForm_Item;
