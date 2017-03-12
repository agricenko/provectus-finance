package com.provectus.taxmanagement.service;

import com.provectus.taxmanagement.entity.Employee;
import com.provectus.taxmanagement.entity.Quarter;
import com.provectus.taxmanagement.entity.TaxRecord;
import com.provectus.taxmanagement.integration.TestParent;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by alexey on 12.03.17.
 */
public class EmployeeServiceImplTest extends TestParent {

    @Test
    public void testService() {
        Employee employee = new Employee();
        employee.setFirstName("Sanya");
        employee.setLastName("Petrov");
        employee.setSecondName("Nikolaevich");

        Quarter quarter = new Quarter();
        quarter.setQuarterTitle("Q1 2017");

        TaxRecord taxRecord = new TaxRecord();
        taxRecord.setUsdRevenue(100d);
        taxRecord.setUahRevenue(50d);
        taxRecord.setExchRateUsdUahNBUatReceivingDate(5d);
        taxRecord.calculateAmountForTaxInspection();
        taxRecord.calculateTaxValue();

        quarter.addQarter(taxRecord);
        employee.addQuarter(quarter);

        Employee saved = employeeService.save(employee);
        assertNotNull(saved);

        Employee found = employeeRepository.findOne(saved.getId());
        assertNotNull(found);
        assertFalse(found.getQuartersList().isEmpty());
        assertFalse(found.getQuartersList().get(0).getTaxRecords().isEmpty());
    }
}
