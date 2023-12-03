package ratelimiter;

public class Constants {
    public static final int tokensPerRefill = 10;
    public static final long timeBetweenRefills = 1_000;
    public static final int maxBucketSize = 20;
}
