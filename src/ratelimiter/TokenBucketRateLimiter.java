package ratelimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucketRateLimiter {
    private final Object lock = new Object();
    private final int tokensPerRefill;
    private final long timeBetweenRefills;
    private final int maxBucketSize;
    private final AtomicInteger tokensAvailable;
    private long lastRefillTime;


    public TokenBucketRateLimiter(int maxBucketSize, int tokensPerRefill, long timeBetweenRefills) {
        this.timeBetweenRefills = timeBetweenRefills;
        this.maxBucketSize = maxBucketSize;
        this.tokensPerRefill = tokensPerRefill;
        this.tokensAvailable = new AtomicInteger(0);
    }

    public static TokenBucketRateLimiter ofDefault(){
        return new TokenBucketRateLimiter(
                Constants.maxBucketSize, Constants.tokensPerRefill, Constants.timeBetweenRefills
        );
    }

    public boolean tryConsumeToken() {
        synchronized (lock) {
            refill();
            if (tokensAvailable.get() > 0) {
                tokensAvailable.decrementAndGet();
                return true;
            }
        }
        return false;

    }


    private void refill() {
        synchronized (lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((currentTimeMillis - lastRefillTime) > timeBetweenRefills) {
                lastRefillTime = currentTimeMillis;
                tokensAvailable.updateAndGet(
                        current ->
                                Math.min(
                                        maxBucketSize, current + tokensPerRefill
                                ));
            }
        }
    }
}
