package learningtest;

import org.junit.jupiter.api.Test;

/**
 * Tests for inheritance with default constructors.
 *
 * @author Johnny Lim
 */
class InheritanceDefaultConstructorTests {

    @Test
    void test() {
        new Child();
    }

    static class Parent {

        Parent() {
            System.out.println("Parent constructor is invoked.");
        }

    }

    static class Child extends Parent {

        Child() {
            System.out.println("Child constructor is invoked.");
        }

    }

}
