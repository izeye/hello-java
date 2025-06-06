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
    void splitWithTab() {
        String string = "1\t2\t3";

        assertThat(string.split("\t")).containsExactly("1", "2", "3");
        assertThat(string.split("\\t")).containsExactly("1", "2", "3");
        assertThat(string.split("\\\t")).containsExactly("1", "2", "3");
        assertThat(string.split("\\\\t")).containsExactly(string);
    }

    @Test
    void valueOf() {
        assertThat(String.valueOf((String) null)).isEqualTo("null");
    }

    @Test
    void unicodeEscapeSequence() {
        assertThat("\u0026").isEqualTo("&");
    }

    @Test
    void replaceAll() {
        assertThat("aaa_bbb111-ccc222 ddd_eee333-fff444".replaceAll("([a-z]+_[a-z0-9]{6})-[a-z0-9]{6}", "$1")).isEqualTo("aaa_bbb111 ddd_eee333");
    }

}
