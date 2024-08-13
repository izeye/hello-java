package learningtest.java.net;

import org.junit.jupiter.api.Test;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link URLDecoder}.
 *
 * @author Johnny Lim
 */
class URLDecoderTests {

    @Test
    void decode() {
        assertThat(URLDecoder.decode("+", StandardCharsets.UTF_8)).isEqualTo(" ");
        assertThat(URLDecoder.decode("%20", StandardCharsets.UTF_8)).isEqualTo(" ");
    }

}
