import java.time.LocalDate;
import java.util.Scanner;

public class Ex6_Method {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Question1();
		Question2();
		Question3();
	}

	private static void Question1() {
		// Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
		System.out.println("\t --- Question 1 --- \t");
		System.out.print("Các số chẵn nguyên dương nhỏ hơn 10 là : ");
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0 && i > 0)
				System.out.print(i + " ");
		}
	}

	public static void Question2() {
		// Tạo method để in thông tin các account
		System.out.println("\n\t --- Question 2 --- \t");
		 // Create account
        Account account1 = new Account();
        account1.AccountID = 1;
        account1.Email = "tuananh28@gmail.com";
        account1.FullName = "Bùi Tuấn Anh";
        account1.Username = "tuananh";
        account1.CreateDate = LocalDate.of(2020, 3, 17);
        
        System.out.println("AccountID : "+account1.AccountID);
        System.out.println("Email : "+account1.Email);
        System.out.println("FullName : "+account1.FullName);
        System.out.println("Username : "+account1.Username);
        System.out.println("CreateDate : "+account1.CreateDate);
        	
	}

	private static void Question3() {
		// Tạo method để in ra các số nguyên dương nhỏ hơn 10
		System.out.println("\t --- Question 3 --- \t");
		System.out.print("Các số nguyên dương nhỏ hơn 10 là : ");
		for (int i = 0; i < 10; i++) {
			System.out.print(i+ " ");
		}
	}
}
