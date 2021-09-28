import "./App.css";

function App() {
  return (
    <div className="App">
      <div className="container">
        <div className="form">
          <h3>Quản lý nhân viên</h3>
          <form method="POST" id="Main_Form_ID">
            <div className="form-group">
              <label htmlFor="">ID: </label>
              <input
                type="number"
                required="true"
                className="form-control"
                id="ID_ID"
                value=""
                placeholder="Enter Id"
              ></input>
            </div>
            <div className="form-group">
              <label htmlFor="">Email: </label>
              <input
                type="email"
                required="true"
                className="form-control"
                id="Email_ID"
                value=""
                placeholder="Enter Email"
              ></input>
            </div>
            <div className="form-group">
              <label htmlFor="">Username: </label>
              <input
                type="text"
                required="true"
                className="form-control"
                id="Username_ID"
                value=""
                placeholder="Enter Username"
              ></input>
            </div>
            <div className="form-group">
              <label htmlFor="">Fullname: </label>
              <input
                type="text"
                required="true"
                className="form-control"
                id="Fullname_ID"
                value=""
                placeholder="Enter Fullname"
              ></input>
            </div>
            <div className="form-group">
              <label htmlFor="sel1">Select a Department:</label>
              <select className="form-control" id="Department_ID">
                <option>--Select a Department--</option>
                <option>Accounting</option>
                <option>Business Development</option>
                <option>Engineering</option>
                <option>Human Resources</option>
                <option>Research and Development</option>
              </select>
            </div>
            <div className="form-group">
              <label htmlFor="sel1">Select a Position:</label>
              <select className="form-control" id="Position_ID">
                <option>--Select a Position--</option>
                <option>Developer</option>
                <option>Tester</option>
                <option>Scrum Master</option>
                <option>PM</option>
              </select>
            </div>
            <div className="form-group">
              <label htmlFor="">Cretate Date: </label>
              <input
                type="date"
                required="true"
                className="form-control"
                id="Cretate_Date_ID"
                value=""
              ></input>
            </div>
            <div className="form-group">
              <input
                type="submit"
                className="btn btn-success"
                value="Save"
              ></input>
              <input
                type="button"
                className="btn btn-success"
                id="update_btn"
                value="Update"
              ></input>
              <input
                type="button"
                className="btn btn-success"
                id="reset_btn"
                value="Reset"
              ></input>
            </div>
          </form>
        </div>

        <div className="container">
          <div className="form">
            <h3>Thông tin nhân viên trên hệ thống</h3>
            <table className="table table-hover" id="Detail_Staff_ID">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Email</th>
                  <th>Username</th>
                  <th>Fullname</th>
                  <th>Department</th>
                  <th>Position</th>
                  <th>Cretate Date</th>
                  <th>Edit</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody id="Result_TB"></tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
