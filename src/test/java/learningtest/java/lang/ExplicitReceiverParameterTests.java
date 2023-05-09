package learningtest.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for explicit receiver parameters.
 *
 * @author Johnny Lim
 */
class ExplicitReceiverParameterTests {

    @Test
    void test() {
        String currencyCode = "USD";
        Currency currency = new Currency(currencyCode);
        assertThat(currency.getCode()).isEqualTo(currencyCode);
    }

    static class Currency {

        private final String code;

        Currency(String code) {
            this.code = code;
        }

        String getCode(Currency this) {
            return this.code;
        }

    }

}
