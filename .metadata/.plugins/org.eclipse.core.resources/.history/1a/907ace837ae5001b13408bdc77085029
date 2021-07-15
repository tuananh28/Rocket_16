package com.vti.backend;

import java.util.Random;
import java.util.Scanner;

public class Ex1_Datatype_Casting {
    private static Scanner scanner;

	public static void main(String[] args) {
        Question1();
        Question2();
        Question3();
        Question4();
    }

    public static void Question1() {
        /*Khai báo 2 số lương có kiểu dữ liệu là float.
		Khởi tạo Lương của Account 1 là 5240.5 $
		Khởi tạo Lương của Account 2 là 10970.055$
		Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
		Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra*/
        float salary1 = 5240.5f;
        float salary2 = 10970.055f;

        int Salary1 = (int) salary1;
        int Salary2 = (int) salary2;

        System.out.println("Lương Account 1 : " + Salary1);
        System.out.println("Lương Account 2 : " + Salary2);
    }

    public static void Question2() {
         /*Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
		có số 0 ở đầu cho đủ 5 chữ số)*/
        Random random = new Random();
        int number = random.nextInt(99999);
        if (number / 10000 == 0) {
            System.out.println("Number : 0" + number);
        } else if (number / 1000 == 0) {
            System.out.println("Number : 00" + number);
        } else if (number / 100 == 0) {
            System.out.println("Number : 000" + number);
        } else if (number / 10 == 0) {
            System.out.println("Number : 0000" + number);
        } else {
            System.out.println("Number : " + number);
        }
    }

    public static void Question3() {
        /*Lấy 2 số cuối của số ở Question 2 và in ra.
		 Gợi ý: 
		Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
		Cách 2: chia lấy dư số đó cho 100*/
        Random random = new Random();
        int number = random.nextInt(99999);
        if (number / 10000 == 0) {
            System.out.println("Number : 0" + number);
        } else if (number / 1000 == 0) {
            System.out.println("Number : 00" + number);
        } else if (number / 100 == 0) {
            System.out.println("Number : 000" + number);
        } else if (number / 10 == 0) {
            System.out.println("Number : 0000" + number);
        } else {
            System.out.println("Number : " + number);
        }
        //Cách 1
        String numberString = String.valueOf(number);
        System.out.println("2 Số cuối là  : " + numberString.substring(3));

        //Cách 2
        int newNumber = number % 100;
        System.out.println("2 Số cuối là  : " + newNumber);
    }

    public static void Question4() {
        scanner = new Scanner(System.in);
        float a;
        float b;
        System.out.print("Nhập a : ");
        a = scanner.nextFloat();
        do {
            System.out.print("Nhập b : ");
            b = scanner.nextFloat();
            if (b == 0) {
                System.out.println("Mời nhập số  b # 0");
            } else {
                System.out.println("Thương = " + (a / b));
            }
        } while (b == 0);
    }
}
