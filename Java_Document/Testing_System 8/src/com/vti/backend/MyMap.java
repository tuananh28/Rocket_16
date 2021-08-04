package com.vti.backend;

public class MyMap<K, V> {
	private K key;
	private V value;

	public MyMap(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyMap [key=" + key + ", value=" + value + "]";
	}

}
