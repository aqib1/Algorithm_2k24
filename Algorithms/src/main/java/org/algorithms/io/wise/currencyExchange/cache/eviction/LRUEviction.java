package org.algorithms.io.wise.currencyExchange.cache.eviction;

import org.algorithms.io.wise.currencyExchange.cache.record.EvictionConfig;

import java.util.LinkedHashSet;

public final class LRUEviction<K, V> implements EvictionPolicy<K> {
    private final LinkedHashSet<K> orderedKeys;
    private final EvictionConfig<K, V> config;

    public LRUEviction(EvictionConfig<K, V> config) {
        this.config = config;
        this.orderedKeys = new LinkedHashSet<>(config.cache().keySet());
    }

    @Override
    public synchronized void evict(K k) {
        refreshKey(k);
        removeLeastUsedKeyIfSizeExceed();
    }

    private void removeLeastUsedKeyIfSizeExceed() {
        if(config.cache().size() >= config.maxSize()) {
            config.cache().remove(orderedKeys.removeFirst());
        }
    }

    private void refreshKey(K k) {
        this.orderedKeys.remove(k);
        if(config.cache().containsKey(k)) {
            this.orderedKeys.add(k);
        }
    }

    @Override
    public void clear() {
        this.orderedKeys.clear();
    }
}
