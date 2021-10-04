import React, { Component } from "react";

export default class LifeCycle extends Component {
  constructor(props) {
    super(props);
    this.state = {
      message: "Hello VTI",
    };
    console.log("Bước 1: Gọi hàm Constructor");
  }
  changeState = () => {
    this.setState({
      message: "Hello TuanAnh",
    });
    console.log(
      "Bước 1: Sau khi click nút Change thì gọi tới phương thức: Change State"
    );
  };
  render() {
    console.log("Bước 2: Gọi hàm Render");
    return (
      <div>
        <h3>{this.state.message}</h3>
        <button onClick={this.changeState}>Change State</button>
      </div>
    );
  }

  componentDidMount() {
    console.log("Bước 3: Gọi tới hàm ComponentDidMount");
  }

  shouldComponentUpdate(newProps, newState) {
    console.log("newProps", newProps);
    console.log("newState", newState);
    console.log(
      "Bước 2: Gọi tới ShouldComponentUpdate, Nếu kết quả là true thì thực hiện tiếp bước bên dưới để thực hiện render lại: " +
        true
    );
    if (newState.message === this.state.message) {
      return false;
    } else {
      return true;
    }
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("prevProps", prevProps);
    console.log("prevState", prevState);
    console.log("Bước 4: Gọi tới componentDidUpdate");
  }
  componentWillUnmount() {
    console.log("Gọi componentWillUnmount trước khi Component bị Unmount");
  }
}
