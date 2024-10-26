package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Tests for {@link Iterable} with generics.
 *
 * @author Johnny Lim
 */
class IterableGenericsTests {

    @Test
    void test() {
        List<Row<Double>> rows = List.of(Row.of(1d));
        List<Row<Double>> rowsWithCollectToList = List.of(Row.of(1d)).stream().collect(Collectors.toList());
        List<Row<Double>> rowsWithToList = List.of(Row.of(1d)).stream().toList();

        // This fails to compile with the following:
        // error: incompatible types: List<Row<Double>> cannot be converted to Iterable<Row<?>>
        // register(rows);
        register(List.of(Row.of(1d)));
        register(List.of(Row.of(1d)).stream().collect(Collectors.toList()));
        // This fails to compile with the following:
        // error: incompatible types: List<Row<Double>> cannot be converted to Iterable<Row<?>>
        // register(List.of(Row.of(1d)).stream().toList());

        registerWithExtends(rows);
        registerWithExtends(List.of(Row.of(1d)));
        registerWithExtends(List.of(Row.of(1d)).stream().collect(Collectors.toList()));
        registerWithExtends(List.of(Row.of(1d)).stream().toList());
    }

    void register(Iterable<Row<?>> rows) {
    }

    void registerWithExtends(Iterable<? extends Row<?>> rows) {
    }

    static class Row<T> {

        private Row(T value) {
        }

        static <T> Row<T> of(T value) {
            return new Row<>(value);
        }

    }

}
