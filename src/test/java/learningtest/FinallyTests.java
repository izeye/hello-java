package learningtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests with <a href="https://errorprone.info/bugpattern/Finally">Finally</a> from Error Prone.
 *
 * @author Johnny Lim
 */
class FinallyTests {

    @Test
    void finallyWinsWithReturn() {
        assertThat(getString()).isEqualTo("from finally");
    }

    @Test
    void finallyWinsWithThrow() {
        assertThatThrownBy(() -> throwException()).hasMessage("from finally");
    }

    private String getString() {
        try {
            return "from try";
        }
        finally {
            return "from finally";
        }
    }

    private void throwException() {
        try {
            throw new RuntimeException("from try");
        }
        catch (RuntimeException ex) {
            throw new RuntimeException("from catch");
        }
        finally {
            throw new RuntimeException("from finally");
        }
    }

}
