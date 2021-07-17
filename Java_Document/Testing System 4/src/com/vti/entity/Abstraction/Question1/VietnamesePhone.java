package com.vti.entity.Abstraction.Question1;

import java.util.ArrayList;

public class VietnamesePhone extends Phone {

	private ArrayList<Contact> contactsList = new ArrayList<>();

	@Override
	public void insertContact(String name, String phone) {
		// TODO Auto-generated method stub
		Contact contact = new Contact(name, phone);
		contactsList.add(contact);
	}

	@Override
	public void removeContact(String name) {
		// TODO Auto-generated method stub
		contactsList.removeIf(contact -> contact.getName().equals(name));
	}

	@Override
	public void updateContact(String name, String newPhone) {
		// TODO Auto-generated method stub
		for (Contact contact : contactsList) {
			if (contact.getName().equals(name)) {
				contact.setPhone(newPhone);
			}
		}
	}

	@Override
	public void searchContact(String name) {
		// TODO Auto-generated method stub
		for (Contact contact : contactsList) {
			if (contact.equals(name)) {
				System.out.println(contact);
			}
		}
	}
	
	public void printContact() {
		for (Contact contact : contactsList) {
			System.out.println(contact);
		}
	}

}
