package com.provectus.taxmanagement.client.ui.presenter.employee;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.provectus.taxmanagement.client.ui.widget.employee.EmployeeTable;
import org.gwtbootstrap3.client.ui.Button;

public class EmployeeListView extends com.gwtplatform.mvp.client.ViewImpl implements EmployeeListPresenter.ViewImpl {

    @UiField
    EmployeeTable employeeTable;

    @UiField
    Button addEmployeeButton;
    @UiField
    Button editEmployeeButton;
    @UiField
    Button refreshButton;

    @Inject
    EmployeeListView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public EmployeeTable getEmployeeTable() {
        return employeeTable;
    }

    @Override
    public Button getAddEmployeeButton() {
        return addEmployeeButton;
    }

    @Override
    public Button getEditEmployeeButton() {
        return editEmployeeButton;
    }

    @Override
    public Button getRefreshTable() {
        return refreshButton;
    }

    interface Binder extends UiBinder<Widget, EmployeeListView> {
    }
}