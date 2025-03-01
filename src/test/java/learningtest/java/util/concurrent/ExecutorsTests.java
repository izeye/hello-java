package learningtest.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

}
