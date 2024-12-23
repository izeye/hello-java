package learningtest.java.util.concurrent.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link AtomicInteger}.
 *
 * @author Johnny Lim
 */
class AtomicIntegerTests {

    @Test
    void incrementAndGetWhenOverflow() {
        AtomicInteger value = new AtomicInteger(Integer.MAX_VALUE);
        assertThat(value.get()).isEqualTo(Integer.MAX_VALUE);
        assertThat(value.incrementAndGet()).isEqualTo(Integer.MIN_VALUE);
    }

}
