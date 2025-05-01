package org.algorithms.io.wise.currencyExchange.exchange.service;

import org.algorithms.io.wise.currencyExchange.cache.impl.Cache;
import org.algorithms.io.wise.currencyExchange.exchange.exception.ExchangeNotFoundException;
import org.algorithms.io.wise.currencyExchange.exchange.record.CurrencyExchange;

import java.util.Objects;

public class CurrencyExchangeService {
    private final Cache<String, CurrencyExchange> cache;

    public CurrencyExchangeService(Cache<String, CurrencyExchange> cache) {
        this.cache = cache;
    }

    public void saveCurrencyExchange(
            CurrencyExchange exchange,
            long ttl
    ) {
        this.cache.put(exchange.generateKey(), exchange, ttl);
    }

    public CurrencyExchange getCurrencyExchange(
            CurrencyExchange exchange
    ) {
        var key = exchange.generateKey();
        var exchangeFromCache = cache.get(key);
        if (Objects.isNull(exchangeFromCache)) {
            throw new ExchangeNotFoundException(String.format(
                    "Exchange not found against key %s",
                    key
            ));
        }

        return exchangeFromCache;
    }
}
