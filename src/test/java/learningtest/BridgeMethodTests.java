package learningtest;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * Tests for bridge methods.
 *
 * @author Johnny Lim
 */
class BridgeMethodTests {

    @Test
    void test() {
        Method[] methods = StringBox.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method + ": " + method.isBridge());
        }
    }

    private interface Box<T> {

        T get();

    }

    private static class StringBox implements Box<String> {

        @Override
        public String get() {
            return "string";
        }

    }

}
