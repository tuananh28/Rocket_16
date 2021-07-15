import java.time.LocalDate;

public class Ex1_Flow_Control {
    public static void main(String[] args) {
        // Create group
        Group group1 = new Group();
        group1.GroupID = 1;
        group1.GroupName = "Java Fresher";
        group1.CreateDate = LocalDate.of(2021, 9, 21);

        Group group2 = new Group();
        group2.GroupID = 2;
        group2.GroupName = "DB Fresher";
        group2.CreateDate = LocalDate.of(2020, 5, 21);

        Group group3 = new Group();
        group3.GroupID = 3;
        group3.GroupName = "C++ Fresher";
        group3.CreateDate = LocalDate.of(2020, 4, 16);

        // Create Deparment
        Department department1 = new Department();
        department1.DepartmentID = 1;
        department1.DepartmentName = "Sale";

        Department department2 = new Department();
        department2.DepartmentID = 2;
        department2.DepartmentName = "Marketting";

        Department department3 = new Department();
        department3.DepartmentID = 3;
        department3.DepartmentName = "HR";

        // Create Position
        Position position1 = new Position();
        position1.PositionID = 1;
        position1.PositionName = PositionName.TEST;

        Position position2 = new Position();
        position2.PositionID = 2;
        position2.PositionName = PositionName.DEV;

        Position position3 = new Position();
        position3.PositionID = 3;
        position3.PositionName = PositionName.PM;

        // Create account
        Account account1 = new Account();
        account1.AccountID = 1;
        account1.CreateDate = LocalDate.of(2020, 3, 17);
        account1.Department = department1;
        account1.Email = "An@gmail.com";
        account1.FullName = "Bùi Tuấn Anh";
        account1.Position = position1;
        account1.Username = "an.nguyenvan";

        Account account2 = new Account();
        account2.AccountID = 2;
        account2.CreateDate = LocalDate.of(2020, 1, 9);
        account2.Department = department1;
        account2.Email = "Linh@gmail.com";
        account2.FullName = "Nguyễn Thùy Linh";
        account2.Position = position3;
        account2.Username = "Linh.nguyenhoai";

        Account account3 = new Account();
        account3.AccountID = 3;
        account3.CreateDate = LocalDate.of(2020, 3, 19);
        account3.Department = department2;
        account3.Email = "ha@gmail.com";
        account3.FullName = "Pham Hai Ha";
        account3.Position = position1;
        account3.Username = "Ha.phamhai";

        Account account4 = new Account();
        account4.AccountID = 4;
        account4.CreateDate = LocalDate.of(2020, 6, 19);
        account4.Department = department3;
        account4.Email = "lepham@gmail.com";
        account4.FullName = "Lê Thị Na";
        account4.Position = position3;
        account4.Username = "Lenana";

        // add group to account
        account1.groups = new Group[]{group1};

        account2.groups = new Group[]{group3};

        account3.groups = new Group[]{group1};

        // add account to group
        group1.accounts = new Account[]{account1, account2, account3};

        //FOR
        /* Question 1:
        Kiểm tra account thứ 2
        Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
        "Nhân viên này chưa có phòng ban"
        Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …" */
        System.out.println("\n\t--- Question 1 ---");
        if (account2.Department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else
            System.out.println("Phòng ban của nhân viên này là : " + account2.Department.DepartmentName);

        /* Question 2:
        Kiểm tra account thứ 2
        Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
        Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
        này là Java Fresher, C# Fresher"
        Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
        quan trọng, tham gia nhiều group"
        Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
        người hóng chuyện, tham gia tất cả các group" */

        System.out.println("\n\t--- Question 2 ---");
        
        if (account2.groups == null) {
            System.out.println("Nhân viên này không có group. ");
        } else {
            int countGroup = account2.groups.length;
            if (countGroup == 1 || countGroup == 2) {
                System.out.println("Group của nhân viên này là : " + account2.groups[0].GroupName);
            }
            if (countGroup == 3) {
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
            }
            if (countGroup >= 4) {
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
            }
        }
        // Question 3 Sử dụng toán tử ternary để làm Question 1
        System.out.println("\n\t--- Question 3 ---");
        System.out.println(account2.Department == null ? "Nhân viên này không có group." : "Phòng ban của nhân viên này là : " + account2.Department.DepartmentName);
        /* Question 4:
        Sử dụng toán tử ternary để làm yêu cầu sau:
        Kiểm tra Position của account thứ 1
        Nếu Position = Dev thì in ra text "Đây là Developer"
        Nếu không phải thì in ra text "Người này không phải là Developer" */
        System.out.println("\n\t--- Question 4 ---");
        System.out.println(account1.Position.PositionName == PositionName.DEV ? "Đây là Developer" : "Người này không phải là Developer");

        // SWITCH CASE
        /*Question 5:
        Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
        Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
        Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
        Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
        Còn lại in ra "Nhóm có nhiều thành viên"*/

        System.out.println("\n\t--- Question 5 ---");
        if (group1.accounts == null) {
            System.out.println("Nhóm không có account nào");
        } else {
            int CountAccount = group1.accounts.length;
            switch (CountAccount) {
                case 1:
                    System.out.println("Nhóm có một thành viên");
                    break;
                case 2:
                    System.out.println("Nhóm có hai thành viên");
                    break;
                case 3:
                    System.out.println("Nhóm có ba thành viên");
                    break;
                default:
                    System.out.println("Nhóm có nhiều thành viên");
                    break;
            }
        }
        //Question 6: Sử dụng switch case để làm lại Question 2
        System.out.println("\n\t--- Question 6 ---");
        int CheckAccount2 = account2.groups.length;
        switch (CheckAccount2) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
                System.out.println("Group của nhân viên này là : " + account2.groups[0].GroupName);
                break;
            case 2:
                System.out.println("Group của nhân viên này là : " + account2.groups[0].GroupName + "," + account2.groups[1].GroupName);
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                break;
        }
        //Question 7: Sử dụng switch case để làm lại Question 4
        System.out.println("\n\t--- Question 7 ---");
        switch (account1.Position.PositionName) {
            case DEV:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải Developer");
                break;
        }
        // FOREACH
        // Question 8: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
        System.out.println("\n\t--- Question 8 ---");
        Account[] accounts = {account1, account2, account3};
        int i = 0;
        for (Account account : accounts) {
            System.out.println("\nThông tin Account Thứ " + (i + 1));
            System.out.println("Email : " + account.Email);
            System.out.println("FullName :  " + account.FullName);
            System.out.println("Department : " + account.Department.DepartmentName);
            i++;
        }
        //Question 9: In ra thông tin các phòng ban bao gồm: id và name
        System.out.println("\n\t--- Question 9 ---");
        Department[] departments = {department1, department2, department3};
        for (Department department : departments) {
            System.out.println("\n Thông tin Department thứ " + (i + 1));
            System.out.println("DepartmentID : " + department.DepartmentID);
            System.out.println("DepartmentName : " + department.DepartmentName);
            i++;

        }
        // FOR
        /*Question 10:
        In ra thông tin các account bao gồm:Email, FullName và tên phòng ban của
        họ theo định dạng như sau:
        Thông tin account thứ 1 là:
        Email: NguyenVanA @gmail.com
        Full name: Nguyễn Văn A
        Phòng ban: Sale
        Thông tin account thứ 2 là:
        Email: NguyenVanB @gmail.com
        Full name: Nguyễn Văn B
        Phòng ban: Marketting */
        System.out.println("\n\t--- Question 10 ---");
        for (i = 0; i < accounts.length; i++) {
            System.out.println("\nThông tin account thứ " + (i + 1) + " là : ");
            System.out.println("Email : " + accounts[i].Email);
            System.out.println("FullName : " + accounts[i].FullName);
            System.out.println("Department : " + accounts[i].Department.DepartmentName);
        }
        /* Question 11:
        In ra thông tin các phòng ban bao gồm:
        id và name theo định dạng sau:
        Thông tin department thứ 1 là:
        Id: 1
        Name: Sale
        Thông tin department thứ 2 là:
        Id: 2
        Name: Marketing */
        System.out.println("\n\t--- Question 11 ---");
        for (i = 0; i < departments.length; i++) {
            System.out.println("\nThông tin department thứ " + (i + 1) + " là : ");
            System.out.println("DepartmentID : " + departments[i].DepartmentID);
            System.out.println("DepartmentName : " + departments[i].DepartmentName);
        }
        // Question 12 : Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
        System.out.println("\n\t--- Question 12 ---");
        for (i = 0; i < departments.length; i++) {
            if (i < 2) {
                System.out.println("\nThông tin department thứ " + (i + 1) + " là : ");
                System.out.println("DepartmentID : " + departments[i].DepartmentID);
                System.out.println("DepartmentName : " + departments[i].DepartmentName);
            }
        }
        // Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2
        System.out.println("\n\t--- Question 13 ---");
        for (i=0;i<accounts.length;i++){
            if (i!=1)
            {
                System.out.println("\nThông tin account thứ " + (i + 1) + " là : ");
                System.out.println("Email : " + accounts[i].Email);
                System.out.println("FullName : " + accounts[i].FullName);
                System.out.println("Department : " + accounts[i].Department.DepartmentName);
            }
        }
        // Question 14: In ra thông tin tất cả các account có id <4
        System.out.println("\n\t--- Question 14 ---");
        for (i=0;i<accounts.length;i++){
            if(accounts[i].AccountID < 4){
                System.out.println("\nThông tin account thứ " + (i + 1) + " là : ");
                System.out.println("Email : " + accounts[i].Email);
                System.out.println("FullName : " + accounts[i].FullName);
                System.out.println("Department : " + accounts[i].Department.DepartmentName);
            }
        }
        // Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20
        System.out.println("\n\t--- Question 15 ---");
        for (i=0 ; i <= 20 ;i++){
            if(i%2 == 0){
                System.out.println(i);
            }

        }
        // WHILE
        // Question 16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break,continue
        System.out.println("\n\t--- Question 16 -10 ---");
        i=0;
        while (i<accounts.length)
        {
            System.out.println("\nThông tin account thứ " + (i + 1) + " là : ");
            System.out.println("Email : " + accounts[i].Email);
            System.out.println("FullName : " + accounts[i].FullName);
            System.out.println("Department : " + accounts[i].Department.DepartmentName);
            i++;
        }
        System.out.println("\n\t--- Question 16 -11 ---");
        i=0;
        while (i<accounts.length)
        {
            System.out.println("\nThông tin department thứ " + (i + 1) + " là : ");
            System.out.println("DepartmentID : " + departments[i].DepartmentID);
            System.out.println("DepartmentName : " + departments[i].DepartmentName);
            i++;
        }
        System.out.println("\n\t--- Question 16 -12 ---");
        i=0;
        while (i<2)
        {
                System.out.println("\nThông tin department thứ " + (i + 1) + " là : ");
                System.out.println("DepartmentID : " + departments[i].DepartmentID);
                System.out.println("DepartmentName : " + departments[i].DepartmentName);
                i++;
        }
        System.out.println("\n\t--- Question 16 -13 ---");
        i = 0;
        while (i<accounts.length)
        {
            if (i != 1)
            {
                System.out.println("\nThông tin department thứ " + (i + 1) + " là : ");
                System.out.println("DepartmentID : " + departments[i].DepartmentID);
                System.out.println("DepartmentName : " + departments[i].DepartmentName);
            }
            i++;
        }
        System.out.println("\n\t--- Question 16 -14 ---");
        i = 0;
        while (i < accounts.length)
        {
            if (accounts[i].AccountID < 4) {
                System.out.println("\nThông tin account thứ " + (i + 1) + " là : ");
                System.out.println("Email : " + accounts[i].Email);
                System.out.println("FullName : " + accounts[i].FullName);
                System.out.println("Department : " + accounts[i].Department.DepartmentName);
            }
            i++;
        }

        System.out.println("\n\t--- Question 16 -15 ---");
        i=0;
        while (i <= 20)
        {
            if(i%2 == 0)
            {
                System.out.println(i);
            }
            i++;
        }
        // DO -WHILE
        // Question 17: Làm lại các Question ở phần FOR bằng cách sử dụng DO -WHILE kết hợp với lệnh break,continue
        System.out.println("\n\t--- Question 17-10 ---");
        i=0;
        do {
            System.out.println("\nThông tin account thứ " + (i + 1) + " là : ");
            System.out.println("Email : " + accounts[i].Email);
            System.out.println("FullName : " + accounts[i].FullName);
            System.out.println("Department : " + accounts[i].Department.DepartmentName);
            i++;
        }while (i<accounts.length);

        System.out.println("\n\t--- Question 17-11 ---");
        i=0;
        do {
            System.out.println("\nThông tin department thứ " + (i + 1) + " là : ");
            System.out.println("DepartmentID : " + departments[i].DepartmentID);
            System.out.println("DepartmentName : " + departments[i].DepartmentName);
            i++;
        }while (i<accounts.length);
        System.out.println("\n\t--- Question 17-12 ---");
        i =0;
        do {
            System.out.println("\nThông tin account thứ " + (i + 1) + " là : ");
            System.out.println("Email : " + accounts[i].Email);
            System.out.println("FullName : " + accounts[i].FullName);
            System.out.println("Department : " + accounts[i].Department.DepartmentName);
            i++;
        }while (i < 2);
        System.out.println("\n\t--- Question 17-13 ---");
        i=0;
        do {
            if (i!=1)
            {
                System.out.println("\nThông tin account thứ " + (i + 1) + " là : ");
                System.out.println("Email : " + accounts[i].Email);
                System.out.println("FullName : " + accounts[i].FullName);
                System.out.println("Department : " + accounts[i].Department.DepartmentName);
            }
            i++;
        }while (i<accounts.length);
        System.out.println("\n\t--- Question 17-14 ---");
        i=0;
        do {
            if(accounts[i].AccountID < 4)
            {
                System.out.println("\nThông tin account thứ " + (i + 1) + " là : ");
                System.out.println("Email : " + accounts[i].Email);
                System.out.println("FullName : " + accounts[i].FullName);
                System.out.println("Department : " + accounts[i].Department.DepartmentName);
            }
            i++;
        }while (i<accounts.length);
        System.out.println("\n\t--- Question 17-15 ---");
        i=0;
        do {
            if (i%2==0)
            {
                System.out.println(i);
            }
            i++;
        }while (i<=20);
    }
}
