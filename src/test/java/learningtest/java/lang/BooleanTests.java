package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Boolean}.
 *
 * @author Johnny Lim
 */
class BooleanTests {

    @Test
    void parseBoolean() {
        assertThat(Boolean.parseBoolean(null)).isFalse();
    }

}
