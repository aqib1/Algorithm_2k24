package org.algorithms.io.wise.currencyExchange.exchange.record;

import org.algorithms.io.wise.currencyExchange.exchange.exception.InvalidRateException;

import java.math.BigDecimal;

public record CurrencyExchange(
        String fromCurrency,
        String toCurrency,
        BigDecimal rate
) {
    public CurrencyExchange {
        if (rate == null || rate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidRateException(String.format(
                    "Invalid rate %s defined for currency exchange from %s to %s",
                    rate,
                    fromCurrency,
                    toCurrency
            ));
        }
    }

    public String generateKey() {
        return fromCurrency
                .concat("->")
                .concat(toCurrency);
    }
}
