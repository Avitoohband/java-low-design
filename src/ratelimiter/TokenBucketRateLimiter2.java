package ratelimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucketRateLimiter2 {
    private final Object lock = new Object();

    private final int bucketMaxSize;
    private final long timeBetweenRefills;
    private final int tokensPerRefill;
    private long lastTimeRefilled;


    private final AtomicInteger tokensAvailable;

    public TokenBucketRateLimiter2() {
        bucketMaxSize = 30;
        timeBetweenRefills = 1_000;
        tokensPerRefill = 10;
        lastTimeRefilled = System.currentTimeMillis();
        this.tokensAvailable = new AtomicInteger(bucketMaxSize);

    }

    public boolean tryConsume() {
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
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - lastTimeRefilled) > timeBetweenRefills) {
            lastTimeRefilled = currentTimeMillis;
            tokensAvailable.updateAndGet(current ->
                    Math.min(
                            bucketMaxSize,
                            current + tokensPerRefill));
        }
    }
}
