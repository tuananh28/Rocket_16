import React, { Component } from "react";

export default class ComponentsTop extends Component {
  //-- Demo State ---//
  constructor(props) {
    super(props);
    this.state = {
      click_number: 0, //Khai báo State để lưu trữ thông tin số lần click vào nút Sent Data, khởi tạo = 0
    };
  }
  // Viết hàm xử lý sự kiện khi click vào nút Sent Data
  click = () => {
    this.setState({ 
      click_number: (this.state.click_number + 1 ) // Mỗi lần click sẽ tăng click_Number lên 1 ==> State thay đổi ==> thực hiện render lại
    });
  };
  render() {
    return (
      <div className="row">
        <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
          <div className="panel panel-primary">
            <div className="panel-heading">{this.props.heading_panel}</div>
            <div className="panel-body">
              <div className="row">
                <form method="" id="Main_Form_ID">
                  <div className="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                    <input
                      type="text"
                      name="Input_Name"
                      id="input"
                      className="form-control"
                      value={this.state.click_number}
                      required="required"
                      pattern=""
                      title=""
                      placeholder="Input something here"
                    />
                  </div>
                  <div className="row">
                    <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                      <button type="button" className="btn btn-danger" onClick = {this.click}>
                        Sent Data
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
