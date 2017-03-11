package com.provectus.taxmanagement.repository;

import com.provectus.taxmanagement.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by alexey on 10.03.17.
 */
public interface EmployeeRepository extends MongoRepository<Employee, Long> {
}
