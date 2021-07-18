import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ex2_System_out_printf {

	public static void main(String[] args) {
		// Question
		Question1();
		Question2();
		Question3();
		Question4();
		Question5();
		Question6();

	}

	private static void Question1() {
		// Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
		// nguyên đó
		System.out.println("\t --- Question 1 --- \t");
		int i = 5;
		System.out.printf("%d %n", i);

	}

	private static void Question2() {
		// Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
		// ra số nguyên đó thành định dạng như sau: 100,000,000
		System.out.println("\t --- Question 2 --- \t");
		int i = 100000000;
		System.out.printf("%,d %n", i);

	}

	private static void Question3() {
		// Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
		// thực đó chỉ bao gồm 4 số đằng sau
		System.out.println("\t --- Question 3 --- \t");
		float i = 5.567098f;
		System.out.printf("%.4f %n", i);

	}

	private static void Question4() {
		// Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
		// dạng như sau:
		// Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
		// Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		System.out.println("\t --- Question 4 --- \t");
		String name = "Nguyễn Văn A";
		System.out.printf("%s %s %s %n", "Tên tôi là", name, "và tôi đang độc thân");

	}

	private static void Question5() {
		// Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020 11h:16p:20s
		System.out.println("\t --- Question 5 --- \t");
		LocalDate date = LocalDate.now();
		LocalDateTime datetime = LocalDateTime.now();
		System.out.printf("%td/%<tm/%<tY %tHh:%<tMp:%<tSs %n", date, datetime);

	}

	private static void Question6() {
		// In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
		// table (giống trong Database)
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
		account1.Email = "account1@gmail.com";
		account1.FullName = "Fullname1";
		account1.Position = position1;
		account1.Username = "Account1";

		Account account2 = new Account();
		account2.AccountID = 2;
		account2.CreateDate = LocalDate.of(2020, 1, 9);
		account2.Department = department1;
		account2.Email = "account2@gmail.com";
		account2.FullName = "Fullname2";
		account2.Position = position3;
		account2.Username = "Account2";

		Account account3 = new Account();
		account3.AccountID = 3;
		account3.CreateDate = LocalDate.of(2020, 3, 19);
		account3.Department = department2;
		account3.Email = "account3@gmail.com";
		account3.FullName = "Fullname3";
		account3.Position = position1;
		account3.Username = "Account3";

		Account account4 = new Account();
		account4.AccountID = 4;
		account4.CreateDate = LocalDate.of(2020, 6, 19);
		account4.Department = department3;
		account4.Email = "account4@gmail.com";
		account4.FullName = "Fullname4";
		account4.Position = position3;
		account4.Username = "Account4";

		// add group to account
		account1.groups = new Group[] { group1 };

		account2.groups = new Group[] { group3 };

		account3.groups = new Group[] { group1 };

		// add account to group
		group1.accounts = new Account[] { account1, account2, account3 };
		System.out.println("\t --- Question 6 --- \t");
		String[] email = new String[] { account1.Email, account2.Email, account3.Email };
		String[] fullName = new String[] { account1.FullName, account2.FullName, account3.FullName };
		String[] department = new String[] { account1.Department.DepartmentName, account2.Department.DepartmentName,
				account3.Department.DepartmentName };
		System.out.print(" _______________________________________________\n");
		System.out.printf("|%3s |%-18s |%-5s |%-10s |%n", "STT", "Email", "Full Name", "Department");
		System.out.print("|_______________________________________________|\n");
		for (int i = 0; i < email.length; i++) {
			System.out.printf("|%3d |%5s |%5s |%10s |%n", (i + 1), email[i], fullName[i], department[i]);
		}
		System.out.print("|_______________________________________________|\n");

	}

}
