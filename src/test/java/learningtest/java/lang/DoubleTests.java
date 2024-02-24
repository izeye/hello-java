package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Double}.
 *
 * @author Johnny Lim
 */
class DoubleTests {

    @Test
    void nan() {
        assertThat(Double.NaN < 1024).isFalse();
        assertThat(Double.NaN >= 1024).isFalse();
        assertThat(Double.NaN == Double.NaN).isFalse();

        Double nan1 = Double.valueOf(Double.NaN);
        Double nan2 = Double.valueOf(Double.NaN);
        assertThat(nan1).isNaN();
        assertThat(nan2).isNaN();
        assertThat(nan1).isNotSameAs(nan2);
        assertThat(nan1).isEqualTo(nan2);
    }

}
