package com.provectus.taxmanagement.service;

import java.util.Currency;
import java.util.Date;

/**
 * Created by alexey on 10.03.17.
 */
public interface ExchangeRateService {
    Currency getRate(Date date, Currency currency);
}
