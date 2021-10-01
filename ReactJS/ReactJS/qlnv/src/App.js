import "./App.css";
import InputForm from "./Components/InputForm";
import ResultForm from "./Components/ResultForm";

function App() {
  const listAccounts = [
    {
      ID: "1",
      Email: "tuananh@gmail.com",
      Username: "tuananh",
      Fullname: "Bùi Tuấn Anh",
      Department: "Accounting",
      Position: "Scrum Master",
    },
    {
      ID: "2",
      Email: "hoamai@gmail.com",
      Username: "hoamai",
      Fullname: "Bùi Thị Hoa Mai",
      Department: "Accounting",
      Position: "Scrum Master",
    },
  ];
  return (
    <div class="row">
      <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
        <div className="App">
          <div className="container">
            <InputForm />
            <ResultForm listAccounts={listAccounts} />
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
