package com.provectus.service;

import com.provectus.entity.Employee;

/**
 * Created by alexey on 10.03.17.
 */
public interface TaxService {
    Double calcTaxSum(Employee employee, String period);

    Double calcSalarySum(Employee employee, String period);
}
