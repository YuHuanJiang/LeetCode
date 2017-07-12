package lruCache;

import java.util.LinkedHashMap;

public class LRUCache {
	private CacheMap cache;
	
	public LRUCache(int capacity) {
        cache = new CacheMap(capacity);
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
        	int value = cache.remove(key);
        	put(key, value);
        	return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) cache.remove(key);
        cache.put(key, value);
    }
}

class CacheMap extends LinkedHashMap<Integer, Integer> {
	private static final long serialVersionUID = 1L;
	private int capacity;
	
	public CacheMap(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(
			java.util.Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}
