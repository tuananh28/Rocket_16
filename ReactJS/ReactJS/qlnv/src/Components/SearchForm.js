import React, { Component } from "react";
class SearchForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      search_key: "", // Khai báo State này để lưu giá trị cần tìm kiếm
    };
  }
  // Xử lý khi search_key thay đổi khi nhập liệu, lấy lại State lưu lại
  onChange = (event) => {
    let name = event.target.name;
    let value = event.target.value;
    this.setState({
      [name]: value,
    });
  };
  // Xử lý sự kiện khi onClick vào nút Search, truyền lại giá trị State: search_key ra bên App.js để xử lý
  handleSearch = () => {
    // console.log(this.state.search_key)
    this.props.onSearchForm(this.state.search_key);
  };
  render() {
    var search_key = this.state.search_key;
    return (
      <div className="row">
        <div className="input-group">
          <input
            type="search"
            className="form-control rounded"
            id="input-search-department"
            placeholder="Search by Email, FullName, Department"
            aria-label="Search"
            aria-describedby="search-addon"
            name="search_key"
            value={search_key}
            onChange={this.onChange}
          ></input>
          <button
            type="button"
            className="btn btn-outline-primary"
            onClick={this.handleSearch}
          >
            search
          </button>
        </div>
      </div>
    );
  }
}
export default SearchForm;
