package com.provectus.taxmanagement.client.ui.presenter.employee;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.provectus.taxmanagement.client.validation.ClientValidationFactory;
import com.provectus.taxmanagement.shared.model.Employee;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.IntegerBox;
import org.gwtbootstrap3.client.ui.TextBox;

import javax.validation.ConstraintViolation;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.Set;

public class EmployeeView extends com.gwtplatform.mvp.client.ViewImpl implements EmployeePresenter.ViewImpl, Editor<Employee> {

    private EmployeeDriver employeeDriver;

    @UiField
    TextBox firstName;
    @UiField
    TextBox lastName;
    @UiField
    TextBox secondName;
    @UiField
    TextBox email;
    @UiField
    TextBox department;
    @UiField
    TextBox comment;
    @UiField
    IntegerBox taxPercentage;
//    @UiField
//    TextBox kved;

    @UiField
    Button saveButton;
    @UiField
    Button cancelButton;

    @Inject
    EmployeeView(Binder uiBinder, EmployeeDriver employeeDriver) {
        initWidget(uiBinder.createAndBindUi(this));

        this.employeeDriver = employeeDriver;

        employeeDriver.initialize(this);
        employeeDriver.edit(new Employee());
    }

    @Override
    public Employee getEmployee() {
        Employee employee = employeeDriver.flush();

        Set<ConstraintViolation<Employee>> errors = ClientValidationFactory.validate(employee, Default.class);
        if (!errors.isEmpty()) {
            employeeDriver.setConstraintViolations(new ArrayList<>(errors));

            return null;
        }

        return employee;
    }

    @Override
    public Button getSaveButton() {
        return saveButton;
    }

    @Override
    public Button getCancelButton() {
        return cancelButton;
    }

    interface Binder extends UiBinder<Widget, EmployeeView> {
    }

    interface EmployeeDriver extends SimpleBeanEditorDriver<Employee, EmployeeView> {
    }
}
