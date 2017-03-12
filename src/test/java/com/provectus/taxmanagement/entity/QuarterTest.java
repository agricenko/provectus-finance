package com.provectus.taxmanagement.entity;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by alexey on 12.03.17.
 */
public class QuarterTest {
    @Test
    public void testQuarterCalculations() {
        Quarter quarter = new Quarter();
        quarter.setQuarterTitle("Q1 2017");

        TaxRecord taxRecord = new TaxRecord();
        taxRecord.setUahRevenue(100d);
        taxRecord.calculateVolumeForTaxInspection();
        taxRecord.calculateTaxValue();

        quarter.addQarter(taxRecord);

        quarter.calculateUahVolumeForTaxes();
        quarter.calculateTaxVolume();

        Double taxVolume = quarter.getTaxVolume();
        assertNotNull(taxVolume);
        assertEquals(taxVolume, new Double(5));

        Double uahVolumeForTaxes = quarter.getUahVolumeForTaxes();
        assertNotNull(uahVolumeForTaxes);
        assertEquals(uahVolumeForTaxes, new Double(100));
    }

    @Test
    public void testFindByQuarters() {
        Quarter quarter = new Quarter();
        String quarterTitle = "Q1 2017";
        quarter.setQuarterTitle(quarterTitle);

        Employee employee = new Employee();
        employee.addQuarter(quarter);

        Optional<Quarter> quarterByTitle = employee.getQuarterByTitle(quarterTitle);
        assertNotNull(quarterByTitle.get());
    }
}
