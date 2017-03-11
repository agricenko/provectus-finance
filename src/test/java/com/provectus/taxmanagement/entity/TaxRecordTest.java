package com.provectus.taxmanagement.entity;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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
        assertEquals(total, 2500d);

        taxRecord = new TaxRecord();
        taxRecord.setUahRevenue(1000d);
        total = taxRecord.calculateAmountForTaxInspection();
        assertEquals(total, 1000d);

        taxRecord = new TaxRecord();
        taxRecord.setExchRateUsdUahNBUatReceivingDate(8d);
        taxRecord.setUsdRevenue(50d);
        taxRecord.setUahRevenue(500d);
        total = taxRecord.calculateAmountForTaxInspection();
        assertEquals(total, 900d);
    }

    @Test
    public void testTaxValue() {
        TaxRecord taxRecord = new TaxRecord();
        taxRecord.setExchRateUsdUahNBUatReceivingDate(25d);
        taxRecord.setUsdRevenue(100d);
        taxRecord.calculateAmountForTaxInspection();
        Double taxValue = taxRecord.calculateTaxValue();
        assertEquals(taxValue, 125d);


        taxRecord = new TaxRecord();
        taxRecord.setUahRevenue(1000d);
        taxRecord.calculateAmountForTaxInspection();
        taxValue = taxRecord.calculateTaxValue();
        assertEquals(taxValue, 50d);

        taxRecord = new TaxRecord();
        taxRecord.setExchRateUsdUahNBUatReceivingDate(10d);
        taxRecord.setUsdRevenue(50d);
        taxRecord.setUahRevenue(500d);
        taxRecord.calculateAmountForTaxInspection();
        taxValue = taxRecord.calculateTaxValue();
        assertEquals(taxValue, 50d);
    }
}
