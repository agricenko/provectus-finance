package com.provectus.taxmanagement.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alexey on 11.03.17.
 */
public class TaxRecordTest {

    @Test
    public void testUahAmountForTaxInspection() {
        TaxRecord taxRecord = new TaxRecord();
        taxRecord.setExchRateUsdUahNBUatReceivingDate(25d);
        taxRecord.setUsdRevenue(100d);
        Double total = taxRecord.calculateAmountForTaxInspection();
        assertEquals(total, new Double(2500));

        taxRecord = new TaxRecord();
        taxRecord.setUahRevenue(1000d);
        total = taxRecord.calculateAmountForTaxInspection();
        assertEquals(total, new Double(1000));

        taxRecord = new TaxRecord();
        taxRecord.setExchRateUsdUahNBUatReceivingDate(8d);
        taxRecord.setUsdRevenue(50d);
        taxRecord.setUahRevenue(500d);
        total = taxRecord.calculateAmountForTaxInspection();
        assertEquals(total, new Double(900));
    }

    @Test
    public void testTaxValue() {
        TaxRecord taxRecord = new TaxRecord();
        taxRecord.setExchRateUsdUahNBUatReceivingDate(25d);
        taxRecord.setUsdRevenue(100d);
        taxRecord.calculateAmountForTaxInspection();
        Double taxValue = taxRecord.calculateTaxValue();
        assertEquals(taxValue, new Double(125));


        taxRecord = new TaxRecord();
        taxRecord.setUahRevenue(1000d);
        taxRecord.calculateAmountForTaxInspection();
        taxValue = taxRecord.calculateTaxValue();
        assertEquals(taxValue, new Double(50));

        taxRecord = new TaxRecord();
        taxRecord.setExchRateUsdUahNBUatReceivingDate(10d);
        taxRecord.setUsdRevenue(50d);
        taxRecord.setUahRevenue(500d);
        taxRecord.calculateAmountForTaxInspection();
        taxValue = taxRecord.calculateTaxValue();
        assertEquals(taxValue, new Double(50));
    }
}
