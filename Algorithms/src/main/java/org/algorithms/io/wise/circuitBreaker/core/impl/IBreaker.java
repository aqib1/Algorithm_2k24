package org.algorithms.io.wise.circuitBreaker.core.impl;

public sealed interface IBreaker
        permits TimeBasedBreaker {
    boolean isCallPermitted();
    void onSuccess();
    void onFailure();
    BreakerStatus getStatus();
}
