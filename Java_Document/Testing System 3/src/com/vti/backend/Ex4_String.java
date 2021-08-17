package com.vti.backend;

import java.util.Scanner;

public class Ex4_String {
	public static Scanner scanner = new Scanner(System.in);
	static int x =1 ;
		
	public static void main(String[] args) {
		//Question1();
		// Question2();
		// Question3();
		// Question4();
		// Question5();
		// Question6();
		// Question7();
		// Question8();
		// Question9();
		// Question10();
		// Question11();
		// Question12();
		// Question13();
		// Question14();
		// Question15();
		// Question16();
		Question17();
	}

	private static void Question17() {
		
	}

	public static void Question1() {
		/*
		 * Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể
		 * cách nhau bằng nhiều khoảng trắng );
		 */
		System.out.print("Mời bạn nhập xâu ký tự : ");
		String s = scanner.nextLine();
		s = s.replaceAll("\\s+", " ");
		System.out.println("Số ký tự : " + s.length());
	}

	public static void Question2() {
		// Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
		System.out.print("Mời bạn nhập xâu s1 : ");
		String s1 = scanner.nextLine();
		System.out.print("Mời bạn nhập xâu s2 : ");
		String s2 = scanner.nextLine();
		System.out.println("Nối xâu : " + s1 + " " + s2);
	}

	public static void Question3() {
		/*
		 * Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư viết
		 * hoa chữ cái đầu thì viết hoa lên
		 */
		System.out.print("Mời bạn nhập Họ tên : ");
		String name = scanner.nextLine();
		name = name.replaceAll("\\s+", " ");
		String[] words = name.split(" ");
		StringBuilder word = new StringBuilder();
		for (String x : words) {
			word.append(x.substring(0, 1).toUpperCase()).append(x.substring(1));
			word.append(" ");
		}
		System.out.println("Kết quả : " + word);

	}

	public static void Question4() {
		/*
		 * Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của
		 * người dùng ra VD: Người dùng nhập vào "Nam", hệ thống sẽ in ra
		 * "Ký tự thứ 1 là: N" "Ký tự thứ 1 là: A" "Ký tự thứ 1 là: M"
		 */
		System.out.print("Mời nhập tên của bạn : ");
		String name = scanner.nextLine();
		for (int i = 0; i < name.length(); i++) {
			System.out.println("Ký tự thứ " + (i + 1) + " là : " + name.charAt(i));
		}
	}

	public static void Question5() {
		/*
		 * Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập
		 * vào tên và hệ thống sẽ in ra họ và tên đầy đủ
		 */
		System.out.print("Mời bạn nhập Họ : ");
		String FistName = scanner.nextLine();
		System.out.println("Mời bạn nhập tên :");
		String LastName = scanner.nextLine();
		System.out.println("Tên đầy đủ của bạn là : " + FistName + " " + LastName);
	}

	public static void Question6() {
		/*
		 * Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ
		 * thống sẽ tách ra họ, tên , tên đệm VD: Người dùng nhập vào "Nguyễn Văn Nam"
		 * Hệ thống sẽ in ra "Họ là: Nguyễn" "Tên đệm là: Văn" "Tên là: Nam"
		 */
		String fullName;
		String lastName;
		StringBuilder middleName = new StringBuilder();
		String firstName;
		System.out.print("Nhập họ tên đầy đủ : ");
		fullName = scanner.nextLine();

		fullName = fullName.trim();
		String[] words = fullName.split(" ");
		lastName = words[0];
		firstName = words[words.length - 1];
		for (int i = 1; i <= words.length - 2; i++) {
			middleName.append(words[i]).append(" ");
		}
		System.out.println("Họ là: " + lastName);
		System.out.println("Tên đệm là: " + middleName);
		System.out.println("Tên là: " + firstName);
	}

	public static void Question7() {
		/*
		 * Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa
		 * họ và tên của họ như sau: a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi
		 * người dùng nhập vào VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
		 * chuẩn hóa thành "nguyễn văn nam"
		 */
		String fullName;
		System.out.print("Nhập họ tên đầy đủ : ");
		fullName = scanner.nextLine().trim();
		fullName = fullName.replaceAll("\\s+", " ");
		System.out.println("test" + fullName);
		/*
		 * b) Viết hoa chữ cái mỗi từ của người dùng VD: Nếu người dùng nhập vào
		 * " nguyễn văn nam " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"
		 */
		String[] words = fullName.split(" ");
		fullName = "";
		for (String word : words) {
			String firstCharacter = word.substring(0, 1).toUpperCase();
			String leftCharacter = word.substring(1);
			word = firstCharacter + leftCharacter;
			fullName += word + " ";
		}
		System.out.println("Họ tên sau khi chuẩn hóa : " + fullName);
	}

	public static void Question8() {
		// In ra tất cả các group có chứa chữ "Java"
		String[] groupNames = { "Java Core", "Java Web", "Ruby", "Python" };
		for (String groupName : groupNames) {
			if (groupName.contains("Java")) {
				System.out.println(groupName);
			}
		}
	}

	public static void Question9() {
		// In ra tất cả các group "Java"
		String[] groupNames = { "Java", "C#", "C++" };
		for (String groupName : groupNames) {
			if (groupName.equals("Java")) {
				System.out.println(groupName);
			}
		}
	}

	public static void Question10() {
		/*
		 * (Optional): Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không. Nếu có xuất
		 * ra “OK” ngược lại “KO”. Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
		 */
		String s1, s2, reverseS1 = "";
		System.out.print("Nhập chuỗi 1 : ");
		s1 = scanner.nextLine();
		System.out.print("Nhập chuỗi 2 : ");
		s2 = scanner.nextLine();
		scanner.close();

		for (int i = s1.length() - 1; i >= 0; i--) {
			reverseS1 += s1.substring(i, i + 1);
		}
		if (s2.equals(reverseS1)) {
			System.out.println("Đây là chuỗi đảo ngược !");
		} else {
			System.out.println("Đây không phải chuỗi đảo ngược");
		}
	}

	public static void Question11() {
		// (Optional): Count special Character Tìm số lần xuất hiện ký tự "a" trong
		// chuỗi
		String str;
		System.out.print("Mời bạn nhập vào một chuỗi : ");
		str = scanner.nextLine();
		int dem = 0;
		for (int i = 0; i < str.length(); i++) {
			if ('a' == str.charAt(i)) {
				dem++;
			}
		}
		System.out.println(dem);
	}

	public static void Question12() {
		// (Optional): Reverse String Đảo ngược chuỗi sử dụng vòng lặp
		String s1, reverseS1 = "";
		System.out.print("Nhập chuỗi : ");
		s1 = scanner.nextLine();

		for (int i = s1.length() - 1; i >= 0; i--) {
			reverseS1 += s1.charAt(i);
		}
		System.out.println(reverseS1);
	}

	public static void Question13() {
		/*
		 * (Optional): String not contains digit Kiểm tra một chuỗi có chứa chữ số hay
		 * không, nếu có in ra false ngược lại true. Ví dụ: "abc" => true "1abc",
		 * "abc1", "123", "a1bc", null => false
		 */
		Scanner scanner = new Scanner(System.in);
		String str;
		System.out.print("Nhập chuỗi: ");
		str = scanner.nextLine();
		scanner.close();
		for (int i = 0; i < str.length(); i++) {
			if (checkKeyNumber(str.charAt(i))) {
				System.out.println("False");
				return;
			}
		}
		System.out.println("True");
	}

	public static boolean checkKeyNumber(char check) {
		if (check >= '0' && check <= '9') {
			return true;
		}
		return false;
	}

	public static void Question14() {
		/*
		 * (Optional): Replace character Cho một chuỗi str, chuyển các ký tự được chỉ
		 * định sang một ký tự khác cho trước. Ví dụ: "VTI Academy" chuyển ký tự 'e'
		 * sang '*' kết quả " VTI Academy"
		 */
		String str;
		char ch1, ch2;
		System.out.print("Nhập chuỗi: ");
		str = scanner.nextLine();
		System.out.print("Nhập kí tự muốn chuyển: ");
		ch1 = scanner.nextLine().toCharArray()[0];

		System.out.print("Nhập kí tự sẽ chuyển: ");
		ch2 = scanner.nextLine().toCharArray()[0];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch1) {
				str = str.replace(ch1, ch2);
			}
		}
		System.out.println("Kết quả : " + str);
	}

	public static void Question15() {
		/*
		 * (Optional): Revert string by word Đảo ngược các ký tự của chuỗi cách nhau bởi
		 * dấu cách mà không dùng thư viện. Ví dụ: " I am developer " =>
		 * "developer am I". Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
		 * Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi
		 * theo dấu cách
		 */
		String str;
		System.out.print("Chuỗi : ");
		str = scanner.nextLine().trim();
		str = str.replaceAll("\\s+", " ");
		String[] words = str.split(" ");
		for (int i = words.length - 1; i >= 0; i--) {
			System.out.print(words[i] + " ");
		}
	}

	public static void Question16() {
		/*
		 * (Optional): Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các
		 * phần bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn hình
		 * “KO”.
		 */
		String str;
		int n;
		System.out.print("Chuỗi : ");
		str = scanner.nextLine();
		System.out.print("Nhập n : ");
		n = scanner.nextInt();
		
		if (str == null || str.isEmpty() || str.length() % n != 0) {
			System.out.println("KO");
			return;
		}
		for (int i = 0; i < str.length(); i += n) {
			System.out.println(str.substring(i, i + n));
		}
	}
}
