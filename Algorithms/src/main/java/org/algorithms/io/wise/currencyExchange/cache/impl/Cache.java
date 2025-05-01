package org.algorithms.io.wise.currencyExchange.cache.impl;

public sealed interface Cache <K, V> permits InMemoryCache {
    void put(K key, V value, long ttl);
    V get(K key);
    V remove(K key); // return removed value
    void clear();
    boolean isEmpty();
}
