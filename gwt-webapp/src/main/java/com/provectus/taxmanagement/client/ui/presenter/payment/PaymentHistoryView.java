package com.provectus.taxmanagement.client.ui.presenter.payment;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewImpl;
import com.provectus.taxmanagement.client.ui.widget.employee.EmployeeList;
import com.provectus.taxmanagement.client.ui.widget.payment.QuarterViewPresenterWidget;
import com.provectus.taxmanagement.shared.model.Quarter;

import java.util.List;

public class PaymentHistoryView extends ViewImpl implements PaymentHistoryPresenter.ViewImpl {

    @UiField
    HTMLPanel quarterPayments;
    @UiField
    EmployeeList employeeList;

    @Inject
    Provider<QuarterViewPresenterWidget> quarterWidgetProvider;

    @Inject
    PaymentHistoryView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public EmployeeList getEmployeeList() {
        return employeeList;
    }

    @Override
    public void setQuarters(List<Quarter> quarters) {
        quarterPayments.clear();
        for (Quarter quarter: quarters) {
            QuarterViewPresenterWidget quarterViewPresenterWidget = quarterWidgetProvider.get();
            quarterPayments.add(quarterViewPresenterWidget.getView());
        }
    }

    interface Binder extends UiBinder<Widget, PaymentHistoryView> {
    }
}