import "./App.css";
import ComponentsBottom from "./Components/ComponentsBottom";
import ComponentsTop from "./Components/ComponentsTop";
import React, { Component } from "react";
// Tạo ra 1 đối tượng dataContext để sử dụng
import DataContext from "./Context/DataContext";


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: "", // Khai báo thêm State data để lưu dữ liệu
    };
  }
  getDataFromComponentTop = (data) => {
    // Khi nhận được dữ liệu từ ComponentTop thực hiện lưu lại vào state data
    this.setState({
      data: data,
    });
  };
  // Viết hàm callback để nhận lại dữ liệu từ ComponentTop
  // let getDataFromComponentTop = (data) => {
  //   console.log("data App : ",data);
  //   alert("Dữ liệu App nhận được từ ComponentTop: " + data);
  // }
  render() {
    let data = this.state.data; // Khai báo biến data lấy dữ liệu state của component
    return (
      <div className="App">
        <DataContext.Provider value={"This is data From App to Top_Child"}>
        <ComponentsTop 
        getData={this.getDataFromComponentTop} 
        dataToTopChild={"This is data From App to Top_Child"}
        />
        </DataContext.Provider>
        {/* // Gửi kèm props là 1 hàm tới ComponentTop */}
        <ComponentsBottom data={data} />
      </div>
    );
  }
}
export default App;
