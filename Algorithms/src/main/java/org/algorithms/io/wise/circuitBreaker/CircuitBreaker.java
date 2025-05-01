package org.algorithms.io.wise.circuitBreaker;

import org.algorithms.io.wise.circuitBreaker.core.impl.IBreaker;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public class CircuitBreaker<T> {
    public final Supplier<T> execution;
    private final IBreaker breaker;
    private final Lock lock;

    public CircuitBreaker(
            IBreaker breaker,
            Supplier<T> execution
    ) {
        this.breaker = breaker;
        this.execution = execution;
        this.lock = new ReentrantLock();
    }

    public T execute(Supplier<T> fallback) {
        lock.lock();
        if(!breaker.isCallPermitted()) {
            return fallback.get();
        }
        try {
            var exec = execution.get();
            breaker.onSuccess();
            return exec;
        } catch (Exception exception) {
            exception.printStackTrace();
            breaker.onFailure();
            return fallback.get();
        } finally {
            lock.unlock();
        }
    }
}
