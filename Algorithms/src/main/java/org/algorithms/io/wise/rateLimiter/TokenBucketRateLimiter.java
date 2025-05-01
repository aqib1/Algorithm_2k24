package org.algorithms.io.wise.rateLimiter;


import java.time.Instant;

public class TokenBucketRateLimiter {
    private final RateLimiterConfig config;
    private long lastRefillMillis;
    private int token;
    public TokenBucketRateLimiter(RateLimiterConfig config) {
        this.config = config;
        this.token = config.tokenThreshold();
        this.lastRefillMillis = Instant.now().toEpochMilli();
    }

    public boolean isCallPermitted() {
        refill();
        if(token >= 1) {
            token--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = Instant.now().toEpochMilli();
        int tokenPerSecond = (int) ((now - lastRefillMillis) / 1000) * config.tokenRefillPerSecond();
        token = Math.min(config.tokenThreshold(), token + tokenPerSecond);
        lastRefillMillis= now;
    }
}
