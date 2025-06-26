package learningtest;

import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;

/**
 * Tests for <a href="https://errorprone.info/bugpattern/ModifyCollectionInEnhancedForLoop">ModifyCollectionInEnhancedForLoop</a> from Error Prone.
 *
 * @author Johnny Lim
 */
class ModifyCollectionInEnhancedForLoopTests {

    @Test
    void removeWithHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        assertThatThrownBy(() -> removeEntry(map)).isInstanceOf(ConcurrentModificationException.class);
    }

    @Test
    void removeWithConcurrentHashMap() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        removeEntry(map);
        assertThat(map).containsExactly(entry("a", 1), entry("c", 3));
    }

    private void removeEntry(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                map.remove(entry.getKey());
            }
        }
    }

}
