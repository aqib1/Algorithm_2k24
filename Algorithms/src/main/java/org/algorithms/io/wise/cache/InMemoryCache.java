package org.algorithms.io.wise.cache;

import java.util.HashMap;
import java.util.Map;

public non-sealed class InMemoryCache<K, V> implements Cache<K, V> {
    private final Map<K, V> cache;

    public InMemoryCache() {
        this.cache = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        this.cache.put(key, value);
    }

    @Override
    public V get(K key) {
        return this.cache.get(key);
    }

    @Override
    public void remove(K key) {
        this.cache.remove(key);
    }

    @Override
    public void clear() {
        this.cache.clear();
    }
}
