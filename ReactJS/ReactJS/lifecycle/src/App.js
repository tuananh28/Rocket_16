import React, { Component } from "react";
import LifeCycle from "./Components/LifeCycle";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      show: true,
    };
  }
  deleteComponent = () => {
    this.setState({
      show: false,
    });
  };
  render() {
    let component_show = "";
    if (this.state.show) {
      component_show = <LifeCycle />;
    }
    return (
      <div className="App">
        {component_show}
        <button
          type="button"
          className="btn btn-danger"
          onClick={this.deleteComponent}
        >
          Delete Component
        </button>
      </div>
    );
  }
}

export default App;
