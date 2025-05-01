package org.algorithms.io.wise.currencyExchange.cache.impl;

import org.algorithms.io.wise.currencyExchange.cache.eviction.EvictionPolicy;
import org.algorithms.io.wise.currencyExchange.cache.record.CacheEntry;

import java.util.Map;

public final class InMemoryCache<K, V> implements Cache<K, V> {
    private final Map<K, CacheEntry<V>> cache;
    private final EvictionPolicy<K> evictionPolicy;

    public InMemoryCache(Map<K, CacheEntry<V>> cache, EvictionPolicy<K> evictionPolicy) {
        this.cache = cache;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public void put(K key, V value, long ttl) {
        cache.put(key, new CacheEntry<>(value, ttl));
        evictionPolicy.evict(key);
    }

    @Override
    public V get(K key) {
        var cacheEntry = cache.get(key);
        if (cacheEntry == null)
            return null;
        evictionPolicy.evict(key);
        return cacheEntry.getValue();
    }

    @Override
    public V remove(K key) {
        var cacheEntry = cache.remove(key);

        if (cacheEntry == null)
            return null;

        evictionPolicy.evict(key);
        return cacheEntry.getValue();
    }

    @Override
    public void clear() {
        cache.clear();
        evictionPolicy.clear();
    }

    @Override
    public boolean isEmpty() {
        return cache.isEmpty();
    }
}
