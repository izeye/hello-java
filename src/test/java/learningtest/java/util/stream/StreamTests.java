package learningtest.java.util.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

/**
 * Tests for {@link Stream}.
 *
 * @author Johnny Lim
 */
class StreamTests {

    @Test
    void limit() {
        assertThat(Stream.of(1, 2, 3, 4, 5).limit(3)).containsExactly(1, 2, 3);
    }

    @Test
    void nullElement() {
        assertThat(Stream.of((String) null)).containsExactly((String) null);
        assertThatNullPointerException().isThrownBy(() -> Stream.of((String) null).findFirst());
    }

}
