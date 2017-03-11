package com.provectus.taxmanagement.integration.repository;

import com.provectus.taxmanagement.entity.Employee;
import com.provectus.taxmanagement.integration.TestParent;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by alexey on 11.03.17.
 */
public class EmployeeRepositoryTest extends TestParent {

    @Test
    public void testRepositoriesNotNull() {
        assertNotNull(employeeRepository);
        assertNotNull(taxRepository);
    }

    @Test
    public void testSaveEmppoyee() {
        Employee employee = new Employee();
        employee.setId(1l);
        employee.setFirstName("Alex");
        employee.setLastName("Ivanov");
        employee.setPatronymic("Ivanovich");

        Employee record = employeeRepository.save(employee);
        assertNotNull(record);

        Employee one = employeeRepository.findOne(1l);
        assertEquals(one, record);
    }
}
