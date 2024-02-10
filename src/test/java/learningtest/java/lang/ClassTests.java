package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Class}.
 *
 * @author Johnny Lim
 */
class ClassTests {

    @Test
    void getCanonicalName() {
        SomeClass someClass = new SomeClass();
        assertThat(someClass.getClass().getCanonicalName())
                .isEqualTo("learningtest.java.lang.ClassTests.SomeClass");

        Runnable lambdaRunnable = () -> {};
        assertThat(lambdaRunnable.getClass().getCanonicalName()).isNull();

        Runnable anonymousClassRunnable = new Runnable() {
            @Override
            public void run() {
            }
        };
        assertThat(anonymousClassRunnable.getClass().getCanonicalName()).isNull();
    }

    static class SomeClass {
    }

}
