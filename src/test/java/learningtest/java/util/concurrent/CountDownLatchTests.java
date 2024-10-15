package learningtest.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link CountDownLatch}.
 *
 * @author Johnny Lim
 */
class CountDownLatchTests {

    @Test
    void awaitWithoutCountDown() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(latch.await(1, TimeUnit.SECONDS)).isFalse();
    }

    @Test
    void awaitWithCountDown() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        latch.countDown();
        assertThat(latch.await(1, TimeUnit.SECONDS)).isTrue();
    }

}
