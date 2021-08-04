
package com.vti.entity;

import com.vti.backend.MyMap;

public class Phone<K, V> extends MyMap<K, V> {

	public Phone(K key, V value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}

	public K getKey() {
		return super.getKey();
	}

	public V getPhoneNumber() {
		return super.getValue();
	}

	@Override
	public String toString() {
		return "Phone [Key = " + getKey() + ", PhoneNumber = " + getPhoneNumber() + "]";
	}
}
