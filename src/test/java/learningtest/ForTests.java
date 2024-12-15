package learningtest;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@code for} statements.
 *
 * @author Johnny Lim
 */
class ForTests {

    @Test
    void test() {
        for (int i = 0; i < size(); i++) {
            System.out.println(i);
        }
    }

    private int size() {
        System.out.println("size() called.");
        return 10;
    }

}
