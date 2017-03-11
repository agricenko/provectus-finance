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
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setId(String.valueOf("1"));
        employee.setFirstName("Alex1");
        employee.setLastName("Ivanov");
        employee.setPatronymic("Ivanovich");

        Employee record = employeeRepository.save(employee);
        assertNotNull(record);

        Employee one = employeeRepository.findOne(String.valueOf("1"));
        assertEquals(one, record);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setId(String.valueOf("2"));
        employee.setFirstName("Alex2");
        employee.setLastName("Ivanov");
        employee.setPatronymic("Ivanovich");
        Employee record = employeeRepository.save(employee);
        assertNotNull(record);
        Employee one = employeeRepository.findOne(String.valueOf("2"));
        assertEquals(one, record);

        record.setLastName("Ivanov2");
        Employee updatedEmployee = employeeRepository.save(record);

        Employee updatedFromDB = employeeRepository.findOne(updatedEmployee.getId());
        assertEquals(record, updatedFromDB);
    }

    @Test
    public void testSaveDefaultIdEmppoyee() {
        Employee employee = new Employee();
        employee.setFirstName("Alex");
        employee.setLastName("Ivanov");
        employee.setPatronymic("Ivanovich");

        Employee record = employeeRepository.save(employee);
        assertNotNull(record);

    }
}
