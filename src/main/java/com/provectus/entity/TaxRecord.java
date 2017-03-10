package com.provectus.entity;

import java.util.Date;

/**
 * Stupid name, please rename
 * Created by alexey on 10.03.17.
 */
public class TaxRecord {
    private Long id;
    private String counterpartyName;
    private Date receivingDate;
    private Double uahAmount;
    private Double usdAmount;
    private Double exchangeRateNBUatReceivingDate;
    private Double uahAmountForTaxInspection;//usdAmount * exchangeRateNBUatReceivingDate + uahAmount
    private String taxPeriod;//like Q1 2017, Q4 2016
    private Double taxAmount;
}
