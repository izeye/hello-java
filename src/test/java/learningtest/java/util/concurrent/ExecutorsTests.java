package learningtest.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Executors}.
 *
 * @author Johnny Lim
 */
class ExecutorsTests {

    @Test
    void newVirtualThreadPerTaskExecutor() throws ExecutionException, InterruptedException {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            assertThat(executorService.submit(() -> Thread.currentThread().getClass().getName()).get())
                    .isEqualTo("java.lang.VirtualThread");
        }
    }

    @Test
    void createVirtualThreadsMoreThanCarrierThreads() {
        ThreadFactory threadFactory = Thread.ofVirtual().name("my-virtual-thread-", 0).factory();
        try (ExecutorService executorService = Executors.newThreadPerTaskExecutor(threadFactory)) {
            IntStream.range(0, Runtime.getRuntime().availableProcessors() + 1).forEach((i) -> executorService.submit(() -> {
                System.out.println(Thread.currentThread() + ": " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }
    }

}
