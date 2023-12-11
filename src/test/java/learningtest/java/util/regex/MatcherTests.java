package learningtest.java.util.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class MatcherTests {

    @Test
    void results() {
        Pattern pattern = Pattern.compile("abc");
        Matcher matcher = pattern.matcher("abc123abc456abc");
        assertThat(matcher.results().count()).isEqualTo(3);
    }

}
