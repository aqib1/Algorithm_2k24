package org.algorithms.io.wise.currencyExchange.cache.record;

import org.algorithms.io.wise.cache.Cache;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public record EvictionConfig<K, V>(
        Map<K, CacheEntry<V>> cache,
        int maxSize,
        int corePoolSize,
        int initialDelay,
        int period,
        TimeUnit timeUnit
) {
}
