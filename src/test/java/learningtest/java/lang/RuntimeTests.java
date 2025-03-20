package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Runnable}.
 *
 * @author Johnny Lim
 */
class RuntimeTests {

    @Test
    void availableProcessors() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
        assertThat(availableProcessors).isPositive();
    }

}
