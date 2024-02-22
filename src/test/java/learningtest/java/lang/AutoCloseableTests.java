package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/**
 * Tests for {@link AutoCloseable}.
 *
 * @author Johnny Lim
 */
class AutoCloseableTests {

    @Test
    void tryWithResources() {
        try (MyResource resource = getResource()) {
            fail("Unreachable.");
        }
        catch (RuntimeException ex) {
            assertThat(ex).withFailMessage("getResource() failed.");
        }
    }

    static MyResource getResource() {
        throw new RuntimeException("getResource() failed.");
    }

    static class MyResource implements AutoCloseable {

        @Override
        public void close() {
        }

    }

}
