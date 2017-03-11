package com.provectus.taxmanagement.service;

import com.provectus.taxmanagement.entity.Employee;
import org.springframework.stereotype.Service;

/**
 * Created by alexey on 10.03.17.
 */
@Service
public interface TaxService {
    Double calcTaxSum(Employee employee, String period);

    Double calcSalarySum(Employee employee, String period);
}
