package learningtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    }

}
