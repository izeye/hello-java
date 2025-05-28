package learningtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

/**
 * Tests for modulo operator.
 */
class ModuloOperatorTests {

    @Test
    void test() {
        assertThat(-1 % 3).isEqualTo(-1);
        assertThat(-2 % 3).isEqualTo(-2);
        assertThat(-3 % 3).isEqualTo(0);
        assertThat(-4 % 3).isEqualTo(-1);

        assertThat(1.1 % 1).isEqualTo(0.1, withPrecision(1e-6));
        assertThat(1.0 % 1).isEqualTo(0);
    }

}
