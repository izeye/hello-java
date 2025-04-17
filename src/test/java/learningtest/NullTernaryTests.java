package learningtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatException;

/**
 * Tests for <a href="https://errorprone.info/bugpattern/NullTernary">NullTernary from Error Prone</a>.
 *
 * @author Johnny Lim
 */
class NullTernaryTests {

    @Test
    void test() {
        assertThatException().isThrownBy(() -> tryNullTernary())
                .isExactlyInstanceOf(NullPointerException.class);
    }

    void tryNullTernary() {
        boolean flag = false;
        int foo = 0;
        int x = flag ? foo : null;
    }

}
