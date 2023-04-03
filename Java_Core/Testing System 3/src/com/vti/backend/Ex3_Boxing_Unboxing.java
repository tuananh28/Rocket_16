package com.vti.backend;

public class Ex3_Boxing_Unboxing {
    public static void main(String[] args) {
        Question1();
        Question2();
        Question3();
    }

    private static void Question1() {
        /*Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
        Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
        float có 2 số sau dấu thập phân)*/
        System.out.println("---Question 1: ----");
        Integer luong = 5000;
        Float Salary = (float) luong;
        System.out.printf("%.2f %n", Salary);

    }
    private static void Question2() {
         /*Khai báo 1 String có value = "1234567"
        Hãy convert String đó ra số int*/
        System.out.println("---Question 2: ----");
        String value = "1234567";
        int Convert = Integer.parseInt(value);
        System.out.println(Convert);
    }
    private static void Question3() {
          /*Khởi tạo 1 số Integer có value là chữ "1234567"
        Sau đó convert số trên thành datatype int*/
        System.out.println("---Question 3: ----");
        Integer value = 1234567;
        int Convert =value.intValue();
        System.out.println(Convert);

    }
}
