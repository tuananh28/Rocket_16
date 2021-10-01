import React, { Component } from "react";
import ComponentsTopChild from "./ComponentsTopChild";

export default class ComponentsTop extends Component {
  //	Demo lấy dữ liệu từ form nhập liệu trong ComponentTop.
  constructor(props) {
    super(props);
    this.state = {
      Input_Name: "", // Khai báo state này để lưu thông tin của ô Input Text
    };
  }
  //   Viết hàm onChange khi nhập liệu viết dưới dạng arrow function, không phải bind this.
  handleChange = (event) => {
    let name = event.target.name;
    let value = event.target.value;
    console.log(name);
    console.log(value);
    this.setState({
      [name]: value,
    });
  };
  // Viết hàm xử lý sự kiện khi click vào nút Sent Data, ở đây mới alert ra dữ liệu vừa nhập
  click = () => {
    // alert(this.state.Input_Name);
    // gọi lại props getData và truyền theo giá trị để gọi lại hàm Callback bên App
    // Dữ liệu cần truyền tới App: this.state.Input_Name
    this.props.getData(this.state.Input_Name);
  };
  render() {
    return (
      <div className="row">
        <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
          <div className="panel panel-primary">
            <div className="panel-heading">Components_Top</div>
            <div className="panel-body">
              <div className="row">
                <form method="" id="Main_Form_ID">
                  <div className="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                    <input
                      type="text"
                      // name="Input_Name"
                      id="input"
                      className="form-control"
                      // value=""
                      required="required"
                      pattern=""
                      title=""
                      placeholder="Input something here"
                      name="Input_Name"
                      value={this.state.Input_Name}
                      onChange={this.handleChange}
                    />
                  </div>
                  <div className="row">
                    <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                      <button
                        type="button"
                        className="btn btn-danger"
                        onClick={this.click}
                      >
                        Sent Data
                      </button>
                    </div>
                  </div>
                </form>
              </div>
              <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                  <ComponentsTopChild
                    dataToTopChild={this.props.dataToTopChild}
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
