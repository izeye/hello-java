package learningtest.java.net;

import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link URLEncoder}.
 *
 * @author Johnny Lim
 */
class URLEncoderTests {

    @Test
    void encode() {
        assertThat(URLEncoder.encode(" ", StandardCharsets.UTF_8)).isEqualTo("+");
        assertThat(URLEncoder.encode("+", StandardCharsets.UTF_8)).isEqualTo("%2B");
        assertThat(URLEncoder.encode("|", StandardCharsets.UTF_8)).isEqualTo("%7C");
    }

}
