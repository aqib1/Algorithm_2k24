package org.algorithms.io.wise.currencyExchange.exchange.exception;

public class ExchangeNotFoundException extends RuntimeException {
    public ExchangeNotFoundException(String message) {
        super(message);
    }
}
