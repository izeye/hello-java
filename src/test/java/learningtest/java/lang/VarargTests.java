package learningtest.java.lang;

import org.junit.jupiter.api.Test;

/**
 * Tests for vararg.
 *
 * @author Johnny Lim
 */
class VarargTests {

    @Test
    void testNull() {
        print(null);
        print((Object) null);
        print((Object[]) null);
    }

    void print(Object value) {
        System.out.println("value: " + value);
    }

    void print(Object... values) {
        System.out.println("values: " + values);
    }

}
