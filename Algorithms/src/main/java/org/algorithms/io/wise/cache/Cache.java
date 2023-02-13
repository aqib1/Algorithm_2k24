package org.algorithms.io.wise.cache;

public sealed interface Cache<K, V> permits InMemoryCache {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    void clear();
}
