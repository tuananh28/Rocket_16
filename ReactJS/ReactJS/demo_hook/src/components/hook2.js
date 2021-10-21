import React, { Component } from "react";

class Hook2 extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
    };
  }
  setCount = () => {
    let count = this.state.count;
    count = count + 1;
    this.setState({
      count: count,
    });
  };
  render() {
    return (
      <div className="row">
        <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
          <button
            type="button"
            className="btn btn-success"
            onClick={this.setCount}
          >
            Click
          </button>
        </div>
        <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
          <p style={{ fontSize: "50" }}>Bạn đã click {this.state.count} lần.</p>
        </div>
      </div>
    );
  }
}
export default Hook2;
