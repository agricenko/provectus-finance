package com.provectus.taxmanagement.controller;

import com.provectus.taxmanagement.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexey on 14.03.17.
 */
public class EmployeeController {

    /**
     * get employee by fist name, second name or last name
     * method GET
     *
     * @param firstName
     * @param secondName
     * @param lastName
     * @return
     */
    public List<Employee> findByFirstNameOrSecondNameOrLastName(String firstName, String secondName, String lastName) {
        return new ArrayList<>();
    }

    /**
     * method GET
     *
     * @param id
     * @return
     */
    public Employee findById(String id) {
        return null;
    }

    /**
     * method POST
     *
     * @param employee
     * @return
     */
    public Employee create(Employee employee) {
        return employee;
    }

    /**
     * method PUT
     *
     * @param id
     * @return
     */
    public Employee update(String id) {
        return null;
    }

    /**
     *
     * @param id
     */
    public void delete(String id) {

    }
}
