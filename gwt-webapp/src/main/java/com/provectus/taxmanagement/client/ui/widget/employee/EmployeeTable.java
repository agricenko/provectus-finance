package com.provectus.taxmanagement.client.ui.widget.employee;

import com.google.gwt.user.cellview.client.TextColumn;
import com.provectus.taxmanagement.client.ui.widget.common.AbstractAsyncTable;
import com.provectus.taxmanagement.shared.model.Employee;

public class EmployeeTable extends AbstractAsyncTable<Employee> {

    @Override
    protected void initTableColumns() {
        TextColumn<Employee> nameColumn = new TextColumn<Employee>() {
            @Override
            public String getValue(Employee object) {
                return object.getFirstName() + " " + object.getLastName() + " " + object.getSecondName();
            }
        };

        TextColumn<Employee> departmentColumn = new TextColumn<Employee>() {
            @Override
            public String getValue(Employee object) {
                return object.getDepartment();
            }
        };

        TextColumn<Employee> emailColumn = new TextColumn<Employee>() {
            @Override
            public String getValue(Employee object) {
                return object.getEmail();
            }
        };

        TextColumn<Employee> createdColumn = new TextColumn<Employee>() {
            @Override
            public String getValue(Employee object) {
                return String.valueOf(object.getCreatedDate());
            }
        };

        table.addColumn(nameColumn, "Name");
        table.addColumn(departmentColumn, "Department");
        table.addColumn(emailColumn, "Email");
        table.addColumn(createdColumn, "Created");
    }
}
