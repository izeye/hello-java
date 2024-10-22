package com.izeye.helloworld.util;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

/**
 * Tests for {@link UrlUtils}.
 *
 * @author Johnny Lim
 */
class UrlUtilsTests {

    @Test
    void extractQueryParameters() {
        Map<String, String> queryParameters = UrlUtils.extractQueryParameters("https://www.example.com/api/v1/search?param1=value1&param2=%ED%85%8C%EC%8A%A4%ED%8A%B8");
        assertThat(queryParameters).containsExactly(entry("param1", "value1"), entry("param2", "테스트"));
    }

}
