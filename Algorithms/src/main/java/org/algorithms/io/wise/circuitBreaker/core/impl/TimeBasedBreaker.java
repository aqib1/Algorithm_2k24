package org.algorithms.io.wise.circuitBreaker.core.impl;

import org.algorithms.io.wise.circuitBreaker.core.record.BreakerConfig;

public final class TimeBasedBreaker implements IBreaker {
    private final BreakerConfig config;
    public TimeBasedBreaker(BreakerConfig config) {
        this.config = config;
    }
    @Override
    public boolean isCallPermitted() {
        return false;
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }

    @Override
    public BreakerStatus getStatus() {
        return null;
    }
}
