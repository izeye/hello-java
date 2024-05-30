package learningtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for vararg methods.
 *
 * @author Johnny Lim
 */
class VarargMethodTests {

    @Test
    void test() {
        assertThat(hello()).isEmpty();
        assertThat(hello(null)).isNull();
        assertThat(hello((String[]) null)).isNull();
        assertThat(hello((String) null)).singleElement().isNull();
    }

    static String[] hello(String... names) {
        return names;
    }

}
