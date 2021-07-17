package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity. Access_Modifier.Account;
import com.vti.entity. Access_Modifier.Department;
import com.vti.entity. Access_Modifier.Group;
import com.vti.entity. Access_Modifier.Position;
import com.vti.entity. Access_Modifier.PositionName;

public class Ex1_Constructor {
	
	public void Question1() {
		
		// a) không có parameters

		Department department = new Department();
		System.out.println(department.toString());

		// b) Có 1 parameter là nameDepartment và default id của Department = 0

		Department department1 = new Department(0, "IT");
		System.out.println("\n" + department1.toString());
	}

	public void Question2() {
		// a) Không có parameters

		Account accounta = new Account();
		System.out.println(accounta.toString());

		// b) Có các parameter là id, Email, Username, FirstName,
		// LastName (với FullName = FirstName + LastName)

		Account accountb = new Account(1, "tuananh@gmail.com", "tuananh28", "Bùi", "Tuấn Anh");
		System.out.println("\n" + accountb.toString());

		/*
		 * c) Có các parameter là id, Email, Username, FirstName, LastName (với FullName
		 * = FirstName + LastName) và Position của User, default createDate = now
		 */

		Position position1 = new Position(1, PositionName.DEV);
		Account accountc = new Account(2, "hoamai@gmail.com", "hoamaizz", "Bùi Thị", "Hoa Mai", position1,
				LocalDate.now());
		System.out.println("\n" + accountc.toString());

		/*
		 * d) Có các parameter là id, Email, Username, FirstName, LastName (với FullName
		 * = FirstName + LastName) và Position của User, createDate
		 */

		Position position2 = new Position(1, PositionName.TEST);
		Account accountd = new Account(3, "dien22@gmail.com", "dienz", "Nguyễn", "Văn Diễn", position2,
				LocalDate.of(2020, 10, 05));
		System.out.println("\n" + accountd.toString());

	}

	public void Question3() {
		// a) không có parameters

		Group groupa = new Group();
		System.out.println("--- Câu a ---" + groupa.toString());

		// b) Có các parameter là GroupName, Creator, array Account[]
		// accounts, CreateDate

		Account creator = new Account(1, "tuananh@gmail.com", "tuananh28", "Bùi", "Tuấn Anh");
		Account account2 = new Account(2, "hoamai@gmail.com", "hoamaizz", "Bùi Thị", "Hoa Mai");
		Account account3 = new Account(3, "dienzz@gmail.com", "dienzz", "Nguyễn", "Ngoc Diễn");
		Account[] accounts = { creator, account2, account3 };
		Group group1 = new Group(1, "LonDon", creator, accounts, LocalDate.of(2020, 10, 10));
		System.out.println("\n--- Câu b ---" + group1);

		/*
		 * c) Có các parameter là GroupName, Creator, array String[] usernames ,
		 * CreateDate Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
		 * username, các thông tin còn lại = null).
		 */

		String[] usernames = { "tuananh28", "hoamaizz", "dienzz" };
		System.out.println(group1);
		Group group2 = new Group(2, "Boss of Director", creator, usernames, LocalDate.parse("2020-05-15"));
		System.out.println("\n -- Câu c ---" + group2);
	}
}
