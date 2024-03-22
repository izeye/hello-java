package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link String}.
 *
 * @author Johnny Lim
 */
class StringTests {

    @Test
    void format() {
        assertThat(String.format("%.1f", 1.23)).isEqualTo("1.2");
        assertThat(String.format("%.1f", 1.25)).isEqualTo("1.3");
        assertThat(String.format(Locale.US, "%.1f", 1.25)).isEqualTo("1.3");
        assertThat(String.format(Locale.FRANCE, "%.1f", 1.25)).isEqualTo("1,3");
    }

    @Test
    void split() {
        assertThat("a,b,c,d".split(","))
                .hasSize(4)
                .containsExactly("a", "b", "c", "d");

        assertThat("a,b,c,d".split(",", 4))
                .hasSize(4)
                .containsExactly("a", "b", "c", "d");

        assertThat("a,b,c,d".split(",", 3))
                .hasSize(3)
                .containsExactly("a", "b", "c,d");

        assertThat("a,b,c,d".split(",", 5))
                .hasSize(4)
                .containsExactly("a", "b", "c", "d");

        assertThat(",,,".split(","))
                .isEmpty();

        assertThat(",,,".split(",", 4))
                .hasSize(4)
                .allSatisfy((e) -> assertThat(e).isEmpty());
    }

    @Test
    void valueOf() {
        assertThat(String.valueOf((String) null)).isEqualTo("null");
    }

}
