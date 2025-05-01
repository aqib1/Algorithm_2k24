package org.algorithms.io.wise.currencyExchange.cache.eviction;

import org.algorithms.io.wise.currencyExchange.cache.eviction.tasks.CleanupTask;
import org.algorithms.io.wise.currencyExchange.cache.record.EvictionConfig;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class ScheduleEvictionPolicy<K, V> implements EvictionPolicy<K> {
    private final ScheduledExecutorService scheduleExecutor;
    public ScheduleEvictionPolicy(EvictionConfig<K, V> config) {
        CleanupTask<K, V> cleanupTask = new CleanupTask<>(config);
        this.scheduleExecutor = Executors.newScheduledThreadPool(
                config.corePoolSize()
        );

        this.scheduleExecutor.scheduleAtFixedRate(
                cleanupTask,
                config.initialDelay(),
                config.period(),
                config.timeUnit()
        );
    }

    @Override
    public void shutdown() {
        if(scheduleExecutor != null && !scheduleExecutor.isShutdown()) {
            scheduleExecutor.shutdown();
        }
    }
}
