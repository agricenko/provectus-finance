package com.provectus.taxmanagement.service;

import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.Date;

/**
 * Created by alexey on 10.03.17.
 */
@Service
public interface ExchangeRateService {
    Currency getRate(Date date, Currency currency);
}
