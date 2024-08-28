package learningtest.java.util.regex;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;
import java.util.TreeSet;
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

    @Test
    void group() {
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)}");
        Matcher matcher = pattern.matcher("Hello, ${firstName} ${lastName}!");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    void printAllThymeleafVariables() throws IOException {
        String path = "src/test/resources/thymeleaf.html";

        Set<String> variables = getAllThymeleafVariables(path);
        variables.forEach(System.out::println);
    }

    @Test
    void matches() {
        Pattern pattern = Pattern.compile("[a-z]+");
        assertThat(pattern.matcher("abc").matches()).isTrue();
        assertThat(pattern.matcher("abc!").matches()).isFalse();
    }

    private static Set<String> getAllThymeleafVariables(String path) throws IOException {
        Set<String> variables = new TreeSet<>();
        String string = Files.readString(new File(path).toPath());
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)}");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            variables.add(matcher.group());
        }
        return variables;
    }

}
