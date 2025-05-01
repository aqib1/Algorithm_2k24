package org.algorithms.io.wise.rateLimiter;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowRateLimiter {
    private final RateLimiterConfig config;
    private final Queue<Long> timeWindow;
    public SlidingWindowRateLimiter(RateLimiterConfig config) {
        this.config = config;
        this.timeWindow = new LinkedList<>();
    }

    public boolean isCallPermitted() {
        long now = Instant.now().toEpochMilli();
        while(!timeWindow.isEmpty()
                && (now - timeWindow.peek()) >= config.timeWindowThreshold()) {
            timeWindow.poll();
        }

        if(timeWindow.size() <= config.allowedRequestThreshold()) {
            timeWindow.add(now);
            return true;
        }

        return false;
    }

    public void reset() {
        timeWindow.clear();
    }
}
