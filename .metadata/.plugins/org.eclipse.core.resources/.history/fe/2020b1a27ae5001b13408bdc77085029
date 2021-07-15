package com.vti.backend;

import com.vti.entity.Account;

import java.time.LocalDate;

public class Ex2_Default_value {
    public static void main(String[] args) {
        Question1();
       /* Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
        tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
           Email: "Email 1"
           Username: "User name 1"
           FullName: "Full name 1"
           CreateDate: now*/

    }

    public static void Question1() {
        Account[] accounts = new Account[5];

        for (int i = 0; i < accounts.length; i++) {
            Account account = new Account();
            account.Email = "Email : " + (i + 1);
            account.Username = "Username : " + (i + 1);
            account.FullName = "Fullname : " + (i + 1);
            account.CreateDate = LocalDate.now();
            accounts[i] = account;
        }

        for (Account account : accounts) {
            System.out.println("\nEmail : " + account.Email);
            System.out.println("Username : " + account.Username);
            System.out.println("Fullname : " + account.FullName);
            System.out.println("CreateDate : " + account.CreateDate);
        }
    }

}
