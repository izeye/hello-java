package learningtest.java.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link HashMap}.
 *
 * @author Johnny Lim
 */
class HashMapTests {

    @Test
    void nullKey() {
        Map<String, Object> map = new HashMap<>();

        String nullValue = "nullValue";
        map.put(null, nullValue);

        assertThat(map.get(null)).isEqualTo(nullValue);
    }

}
