package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    void getMethods() {
        assertThat(Arrays.stream(Child.class.getMethods()).map((method) -> method.getName()))
                .contains("getAlias")
                .contains("getName")
                .contains("toString");
    }

    @Test
    void getDeclaredMethods() {
        assertThat(Arrays.stream(Child.class.getDeclaredMethods()).map((method) -> method.getName())).containsExactly("getAlias");
    }

    @Test
    void isAssignableFrom() {
        assertThat(Map.class.isAssignableFrom(HashMap.class)).isTrue();
        assertThat(Map.class.isAssignableFrom(Map.class)).isTrue();
        assertThat(HashMap.class.isAssignableFrom(Map.class)).isFalse();
    }

    static class SomeClass {
    }

    public static class Parent {

        public String getName() {
            return "name";
        }

    }

    public static class Child extends Parent {

        public String getAlias() {
            return "alias";
        }

    }

}
