package org.algorithms.io.wise.rateLimiter;

import java.time.Instant;

public class FixedWindowRateLimiter {
    private int requestCount;
    private final RateLimiterConfig config;
    private long currentStartWindow;

    public FixedWindowRateLimiter(RateLimiterConfig config) {
        this.config = config;
        this.currentStartWindow = Instant.now().toEpochMilli();
    }

    public boolean isCallPermitted() {
        long now = Instant.now().toEpochMilli();
        if((now - currentStartWindow) >= config.timeWindowThreshold()) {
            requestCount = 0;
            currentStartWindow = now;
        }

        if(requestCount <= config.allowedRequestThreshold()) {
            requestCount++;
            return true;
        }
        return false;
    }


    public void reset() {
        requestCount = 0;
        currentStartWindow = Instant.now().toEpochMilli();
    }
}
