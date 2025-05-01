package org.algorithms.io.wise.currencyExchange.cache.eviction.tasks;

import org.algorithms.io.wise.currencyExchange.cache.record.EvictionConfig;

public class CleanupTask<K, V> implements Runnable {
    private final EvictionConfig<K, V> config;

    public CleanupTask(EvictionConfig<K, V> config) {
        this.config = config;
    }

    @Override
    public void run() {
        var keys = config.cache().keySet();
        for(var key: keys) {
            if(config.cache().get(key).isExpired()) {
                config.cache().remove(key);
            }
        }
    }
}
