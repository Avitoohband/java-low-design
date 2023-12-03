package test.ratelimiter;

import ratelimiter.Constants;
import ratelimiter.TokenBucketRateLimiter;

public class Main {
    public static void main(String[] args) {
        TokenBucketRateLimiter tokenBucketRateLimiter = new TokenBucketRateLimiter(
                Constants.maxBucketSize, Constants.tokensPerRefill, Constants.timeBetweenRefills
                );

        int numberOfSuccessfulConsumes = 0;
        long numberOfUnsuccessfulConsumes = 0;

        long startTimeMillis = System.currentTimeMillis();

        while((System.currentTimeMillis() - startTimeMillis) <= 10_000L){
            boolean isSucceed = tokenBucketRateLimiter.tryConsumeToken();

            if(isSucceed){
                System.out.println("Consume Succeed");
                numberOfSuccessfulConsumes++;
            }else {
                numberOfUnsuccessfulConsumes++;
                if(numberOfUnsuccessfulConsumes % 100_000_000 == 0){
                    System.out.println(numberOfUnsuccessfulConsumes + ": requests have been blocked.");

                }
            }
        }

        long endTimeMillis = System.currentTimeMillis();

        System.out.println();
        System.out.println("The time the process took: " + (endTimeMillis - startTimeMillis));
        System.out.println("Number of successful consumes: " + numberOfSuccessfulConsumes);
        System.out.println("Number of expected consumes: " + Constants.tokensPerRefill * 10);
        System.out.println("A total of: " + numberOfUnsuccessfulConsumes + " requests have been blocked.");




    }




}
