package org.algorithms.io.wise.rateLimiter;

public record RateLimiterConfig(
        long timeWindowThreshold,
        int allowedRequestThreshold,
        int tokenThreshold,
        int tokenRefillPerSecond
) {
}
