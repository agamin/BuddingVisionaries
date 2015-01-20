package com.agamin.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;

public class AgaminCache<K,V> {
	
	private Cache cache;
	
	public AgaminCache(Cache cache) {
		this.cache = cache;
	}
	
	@SuppressWarnings("unchecked")
	public V get(K k) {
		ValueWrapper value = cache.get(k);
		if(value != null) {
			return (V)value.get();
		}
		return null;
	}

	public void put(K k, V v) {
		cache.put(k, v);
	}

}
