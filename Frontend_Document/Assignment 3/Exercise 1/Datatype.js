function Department(DepartmentID, DepartmentName) {
    this.DepartmentID = DepartmentID;
    this.DepartmentName = DepartmentName;
}
var department1 = new Department(1, "Sale");
var department2 = new Department(2, "Marketing")
var department3 = new Department(3, "IT");

function Position (PositionID,PositionName) {
    this.PositionID = PositionID;
    this.PositionaName = PositionName;
}
var position1 = new Position(1,"Manager");
var position2 = new Position(2,"Tester");
var position3= new Position(3,"Dev");
function Account (AccountID, Email,Username,FullName,Department,Position,CreateDate){
    this.AccountID = AccountID;
    this.Email = Email;
    this.Username = Username;
    this.FullName = FullName;
    this.Department = Department;
    this.Position = Position;
    this.CreateDate = CreateDate;
}
var account1 = new Account(1,"tuananh28@gmail.com","tuananhbui","Bùi Tuấn Anh",department3,position1,"2021-07-15");
var account1 = new Account(2,"hoamai98@gmail.com","hoamaibui","Bùi Thị Hoa Mai",department2,position2,"2021-07-15");
var account1 = new Account(3,"phamdien@gmail.com","phamdien","Phạm Ngọc Diễn",department1,position3,"2021-07-15");
if(account1.Department == null && account1.Department == undefined){
    console.log("Nhân viên này chưa có phòng ban");
}else{
    console.log("Phòng ban của nhân viên này là : "+account1.Department.DepartmentName);
}


