package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Math}.
 *
 * @author Johnny Lim
 */
class MathTests {

    @Test
    void abs() {
        assertThat(Math.abs(Integer.MIN_VALUE)).isNegative().isEqualTo(Integer.MIN_VALUE);
        assertThat(Math.abs(Long.MIN_VALUE)).isNegative().isEqualTo(Long.MIN_VALUE);
    }

}
