package org.algorithms.io.wise.circuitBreaker.core.record;

public record BreakerConfig(
        int failureThreshold,
        int halfOpenThreshold,
        long openStateThresholdMillis
) {
}
