package learningtest.errorprone;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for CollectionUndefinedEquality from Error Prone.
 *
 * See https://errorprone.info/bugpattern/CollectionUndefinedEquality
 *
 * @author Johnny Lim
 */
class CollectionUndefinedEqualityTests {

    @Test
    void setAndList() {
        List<Collection<Integer>> collectionsOfIntegers = List.of(Set.of(1, 2), Set.of(3, 4));
        assertThat(collectionsOfIntegers.contains(Set.of(1, 2))).isTrue();
        assertThat(collectionsOfIntegers.contains(List.of(1, 2))).isFalse();
    }

    @Test
    void charSequence() {
        assertThat(containsTest(List.of(new StringBuilder("test")))).isFalse();
    }

    @Test
    void charSequenceFixed() {
        assertThat(containsTestFixed(List.of(new StringBuilder("test")))).isTrue();
    }

    private boolean containsTest(Collection<CharSequence> charSequences) {
        return charSequences.contains("test");
    }

    private boolean containsTestFixed(Collection<CharSequence> charSequences) {
        return charSequences.stream().anyMatch("test"::contentEquals);
    }

}
