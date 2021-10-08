import React, { Component } from "react";

class About extends Component {
  render() {
    const location = this.props.location;
    console.log("Thông tin location", location);
    return (
      <div>
        <h2>This is About Page</h2>
      </div>
    );
  }
}

export default About;
