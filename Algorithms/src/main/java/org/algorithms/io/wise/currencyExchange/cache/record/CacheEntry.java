package org.algorithms.io.wise.currencyExchange.cache.record;

import java.time.Instant;

public class CacheEntry<V> {
    private final V value;
    private final Instant creationTime;
    private final long ttl;

    public CacheEntry(V value, long ttl) {
        this.value = value;
        this.ttl = ttl;
        this.creationTime = Instant.now();
    }

    public V getValue() {
        return value;
    }

    public boolean isExpired() {
        return Instant.now().isAfter(creationTime.plusMillis(ttl));
    }
}
