package com.vti.backend;


import java.util.Scanner;

public class Ex4_String {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Question1();
        //Question2();
        //Question3();
        //Question4();
        //Question5();
        Question6();
        Question7();
        Question8();
        Question9();
        Question10();
        Question11();
        Question12();
        Question13();
        Question14();
        Question15();
        Question16();
    }

    public static void Question1() {
        /*Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
            thể cách nhau bằng nhiều khoảng trắng );*/
        System.out.print("Mời bạn nhập xâu ký tự : ");
        String s = scanner.nextLine();
        s = s.replaceAll("\\s+", " ");
        System.out.println("Số ký tự : " + s.length());
    }

    public static void Question2() {
        //Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
        System.out.print("Mời bạn nhập xâu s1 : ");
        String s1 = scanner.nextLine();
        System.out.print("Mời bạn nhập xâu s2 : ");
        String s2 = scanner.nextLine();
        System.out.println("Nối xâu : " + s1 + " " + s2);
    }

    public static void Question3() {
        /*Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
             viết hoa chữ cái đầu thì viết hoa lên*/
        System.out.print("Mời bạn nhập Họ tên : ");
        String name = scanner.nextLine();
        name = name.replaceAll("\\s+", " ");
        String[] words = name.split(" ");
        StringBuilder word = new StringBuilder();
        for (String x: words) {
            word.append(x.substring(0, 1).toUpperCase()).append(x.substring(1));
            word.append(" ");
        }
        System.out.println("Kết quả : "+word);

    }

    public static void Question4() {
           /*Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
             của người dùng ra
              VD:
                Người dùng nhập vào "Nam", hệ thống sẽ in ra
                "Ký tự thứ 1 là: N"
                "Ký tự thứ 1 là: A"
                 "Ký tự thứ 1 là: M"*/
        System.out.print("Mời nhập tên của bạn : ");
        String name = scanner.nextLine();
        for (int i = 0 ; i<name.length();i++){
            System.out.println("Ký tự thứ "+(i+1)+" là : "+name.charAt(i));
        }
    }

    public static void Question5() {
        /*Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
            dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ*/
        System.out.print("Mời bạn nhập Họ : ");
        String FistName = scanner.nextLine();
        System.out.println("Mời bạn nhập tên :");
        String LastName = scanner.nextLine();
        System.out.println("Tên đầy đủ của bạn là : "+ FistName +" "+ LastName);
    }

    public static void Question6() {
         /*Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
            sau đó hệ thống sẽ tách ra họ, tên , tên đệm
            VD:
            Người dùng nhập vào "Nguyễn Văn Nam"
            Hệ thống sẽ in ra
            "Họ là: Nguyễn"
            "Tên đệm là: Văn"
            "Tên là: Nam"*/
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
           /*Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
            chuẩn hóa họ và tên của họ như sau:
            a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
            VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
            chuẩn hóa thành "nguyễn văn nam"
            b) Viết hoa chữ cái mỗi từ của người dùng
            VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
            chuẩn hóa thành "Nguyễn Văn Nam"*/
    }

    public static void Question8() {
        //In ra tất cả các group có chứa chữ "Java"
    }

    public static void Question9() {
        //In ra tất cả các group "Java"
    }

    public static void Question10() {
        /*(Optional):
            Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
            Nếu có xuất ra “OK” ngược lại “KO”.
            Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.*/
    }

    public static void Question11() {
        //(Optional): Count special Character Tìm số lần xuất hiện ký tự "a" trong chuỗi
    }

    public static void Question12() {
        //(Optional): Reverse String Đảo ngược chuỗi sử dụng vòng lặp
    }

    public static void Question13() {
        /*(Optional): String not contains digit
            Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
            lại true.
            Ví dụ:
            "abc" => true
            "1abc", "abc1", "123", "a1bc", null => false*/
    }

    public static void Question14() {
        /*(Optional): Replace character
             Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
            cho trước.
            Ví dụ:
            "VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Academy"*/
    }

    public static void Question15() {
         /*(Optional): Revert string by word
            Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng thư viện.
            Ví dụ: " I am developer " => "developer am I".
            Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
            Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt
            chuỗi theo dấu cách*/
    }

    public static void Question16() {
        /*(Optional):
            Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
            bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
            hình “KO”.*/
    }

}
