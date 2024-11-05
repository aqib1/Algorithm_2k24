package org.algorithms.io.cache;

import java.util.HashMap;
import java.util.Map;

// O(N) Space complexity
public class TimeLimitedCache {
    static class CacheEntry {
        private final int value;
        private final long duration;
        public CacheEntry(int value, long duration) {
            this.value = value;
            this.duration = duration;
        }
    }

    private final Map<Integer, CacheEntry> cache;
    public TimeLimitedCache() {
        this.cache = new HashMap<>();
    }

    // O(1) Time complexity
    public boolean set(int key, int value, int duration){
        long now = System.currentTimeMillis();
        long expiry = now + duration;
        var res = isKeyNotExpired(key, now);
        cleanCache(res, key);

        this.cache.put(
                key,
                new CacheEntry(value, expiry)
        );
        return res;
    }

    // O(1) Time complexity
    private void cleanCache(boolean notExpired, int key) {
        if(!notExpired)
            cache.remove(key);
    }

    // O(1) Time complexity
    private boolean isKeyNotExpired(int key, long now) {
        return this.cache.containsKey(key) &&
                this.cache.get(key).duration > now;
    }
  
    // O(1) Time complexity
    public int get(int key) {
        var keyNotExpired = isKeyNotExpired(key, System.currentTimeMillis());
        cleanCache(keyNotExpired, key);

        return keyNotExpired ? cache.get(key).value : -1;
    }

    // O(N) Time complexity where is number of keys of cache.
    private int count() {
        gcOnCache();
        return cache.size();
    }

    private void gcOnCache() {
        var keys = cache.entrySet()
                .stream()
                .filter(entry -> entry.getValue().duration < System.currentTimeMillis())
                .map(Map.Entry::getKey)
                .toList();

        for(int key: keys)
            cache.remove(key);
    }
}
