import React, { Component } from "react";

export default class ResultForm_Item extends Component {
  // Cách khai báo biến Local
  // -	Trong trường hợp này, giả sử  Cretate_Date không dùng từ bên ngoài truyền vào mà sẽ tạo theo giá trị là ngày giờ mặc định của hệ thống, khi đó sẽ sử dụng Contructor để khai báo các biến mặc định.
  constructor(props) {
    super(props);
    this.Create_Date = "05/01/2021";
  }
  render() {
    // -	Tại component ResultForm_Item, thực hiện đón dữ liệu nhận được để xử lý, sử dụng vòng lặp map để gen dữ liệu, khai báo ra 1 rows kết quả, và return về rows này
    const { listAccounts } = this.props;
    const rows = listAccounts.map((row, index) => {
      return (
        //<React.Fragment>
        <>
        <tr>
          {/* <td>1</td>
          <td>tuananh@vti.com</td>
          <td>tuananh</td>
          <td>Bui Tuan Anh</td>
          <td>Developer</td>
          <td>Dev</td>
          <td>2021-10-01</td> */}

          {/*Khi sử dụng các biến này thì dùng cú pháp: this.Ten_bien (this.Cretate_Date}) chú ý bỏ props khi gọi. */}
          {/* <td>{this.props.ID}</td>
            <td>{this.props.Email}</td>
            <td>{this.props.Username}</td>
            <td>{this.props.Fullname}</td>
            <td>{this.props.Department}</td>
            <td>{this.props.Position}</td>
            <td>{this.Create_Date}</td> */}

          <td>{row.ID}</td>
          <td>{row.Email}</td>
          <td>{row.Username}</td>
          <td>{row.Fullname}</td>
          <td>{row.Department}</td>
          <td>{row.Position}</td>
          <td>{this.Create_Date}</td>
          <td>
            <button className="btn btn-warning" onclick="editAccount()">
              Edit
            </button>
          </td>
          <td>
            <button className="btn btn-warning" onclick="deleteAccount(})">
              Delete
            </button>
          </td>
        </tr>
        </>
        // </React.Fragment>
      );
    });
    return rows;
  }
}
