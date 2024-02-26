package virtual_threads;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VirtualThreadsMagic {
    public static void main(String[] args) throws InterruptedException {
        var maxThreads = 10_000_000;
        var counter = new AtomicInteger();
        var start = System.nanoTime();

        List<Thread> threads = IntStream.range(0, maxThreads)
                .mapToObj(value -> Thread.ofVirtual().unstarted(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        throw new AssertionError(e);
                    }
                    counter.incrementAndGet();
                })).toList();

        for (var thread : threads) {
            thread.start();
        }

        for (var thread : threads) {
            thread.join();
        }

        var end = System.nanoTime();

        System.out.printf("Total number of seconds: %s", (end - start) / 1_000_000_000);
        System.out.printf("Counter is: " + counter.get());
    }
}
