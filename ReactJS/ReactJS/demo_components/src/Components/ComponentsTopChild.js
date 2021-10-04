import React, { Component } from "react";

// Import context để sử dụng
import DataContext from "../Context/DataContext";


export default class ComponentsTopChild extends Component {
  render() {
    // return  <h3>Dữ liệu nhận được từ App: {this.props.dataToTopChild} </h3>;
    return (
      <div>
        <DataContext.Consumer>
          {(data) => <h3>Dữ liệu nhận được từ App:{data}</h3>}
        </DataContext.Consumer>
      </div>
    );
  }
}
