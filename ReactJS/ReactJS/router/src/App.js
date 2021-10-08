import "./App.css";
// Import các thành phần để sử dụng trong project
import { Switch, Route, NavLink } from "react-router-dom";
import Home from "./Components/Home";
import About from "./Components/About";
import AccountManagement from "./Components/AccountManagement";
import DepartmentManagement from "./Components/DepartmentManagement";
import Login from "./Components/Login";
import SignUp from "./Components/SignUp";
import Error from "./Components/Error";

function App() {
  return (
    <div className="App">

      <div className="row">
        {/* Thay đổi lại menu thành font đen để nhìn rõ hơn */}
        <nav
          className="navbar navbar-inverse"
          style={{ backgroundColor: "black", color: "black" }}
        >
          <div className="container-fluid">
            <div className="navbar-header"></div>
            <ul class="nav navbar-nav">
              <li>
                <NavLink to="/" exact activeClassName="select">
                  VTI ACADEMY
                </NavLink>
              </li>
              <li>
                <NavLink to="/home" exact activeClassName="select">
                  Home
                </NavLink>
              </li>
              <li>
                <NavLink to="/about" activeClassName="select">
                  About
                </NavLink>
              </li>
              <li>
                <NavLink to="/AccountManagement" activeClassName="select">
                  AccountManagement
                </NavLink>
              </li>
              <li>
                <NavLink to="/DepartmentManagement" activeClassName="select">
                  DepartmentManagement
                </NavLink>
              </li>
            </ul>
            <ul className="nav navbar-nav navbar-right">
              <li>
                {/* <a href="#"> */}
                <NavLink to="/SignUp">
                  <span className="glyphicon glyphicon-user"></span> Sign Up
                </NavLink>
              </li>
              <li>
                {/* <a href="#"> */}
                <NavLink to="/Login">
                  <span className="glyphicon glyphicon-log-in"></span> Login
                </NavLink>
                {/* </a> */}
              </li>
            </ul>
          </div>
        </nav>
        {/* Khái báo đoạn Switch của router như bên dưới. */}
        <Switch>
          <Route path="/home" component={Home} exact />
          <Route path="/about" component={About} exact />
          <Route path="/AccountManagement" component={AccountManagement} />
          <Route
            path="/DepartmentManagement"
            component={DepartmentManagement}
          />
          <Route path="/Login" component={Login} />
          <Route path="/SignUp" component={SignUp} />
          <Route component={Error} />
        </Switch>
      </div>
    </div>
  );
}

export default App;
