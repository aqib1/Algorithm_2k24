package org.algorithms.io.wise.currencyExchange.cache.eviction;

public sealed interface EvictionPolicy<K>
        permits LRUEviction, ScheduleEvictionPolicy {
    default void evict(K k) {}
    default void clear() {}
    default void shutdown() {}
}
