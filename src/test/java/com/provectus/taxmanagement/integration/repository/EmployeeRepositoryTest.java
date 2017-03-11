package com.provectus.taxmanagement.integration.repository;

import com.provectus.taxmanagement.entity.Employee;
import com.provectus.taxmanagement.integration.TestParent;
import org.junit.Test;
import org.springframework.dao.OptimisticLockingFailureException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        assertEquals(updatedFromDB.getVersion(), new Long(1));
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

    @Test(expected = OptimisticLockingFailureException.class)
    public void testOptimisticLocking() {
        Employee employee = new Employee();
        employee.setFirstName("Vasya");

        Employee savedRecord = employeeRepository.save(employee);
        Employee foundRecord = employeeRepository.findOne(savedRecord.getId());

        savedRecord.setLastName("Ivanov");
        foundRecord.setLastName("Petrov");

        employeeRepository.save(savedRecord);
        employeeRepository.save(foundRecord);
    }
}
