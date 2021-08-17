package com.vti.test;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class AccountProgram {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();
		System.out.println("---------------- GET ALL ACCOUNTS ----------------");
		List<Account> list = repository.getAllAccounts();
		for (Account account : list) {
			System.out.println(account);
		}
		System.out.println("---------------- CREATE ACCOUNTS -----------------");
		Account account= new Account();
		account.setEmail("tuananh@gmail.com");
		account.setUserName("tuananhbui");
		account.setFirstName("Bùi");
		account.setLastName("Tuấn Anh");
		account.setCreateDate(null);
		repository.createAccount(account);
	}
}
