package com.agamin.cache;

public interface Cache<K,V> {
	
	public V getValue(K key);
	public void put(K key, V value);

}
