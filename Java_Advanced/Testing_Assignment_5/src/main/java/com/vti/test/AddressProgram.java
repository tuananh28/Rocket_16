package com.vti.test;

import java.util.List;

import com.vti.entity.Address;
import com.vti.repository.AddressRepository;

public class AddressProgram {
	public static void main(String[] args) {
		AddressRepository repository = new AddressRepository();
		System.out.println("--------------- GET ALL ADDRESS ---------------");
		List<Address> list = repository.getAllAddresses();
		for (Address address : list) {
			System.out.println(address);
		}
	}
}
