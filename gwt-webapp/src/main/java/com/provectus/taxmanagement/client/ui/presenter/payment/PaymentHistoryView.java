package com.provectus.taxmanagement.client.ui.presenter.payment;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.ViewImpl;
import com.provectus.taxmanagement.client.ui.widget.payment.QuarterPaymentPresenterWidget;
import com.provectus.taxmanagement.client.ui.widget.table.EmployeeTable;
import com.provectus.taxmanagement.shared.model.Quarter;
import org.gwtbootstrap3.client.ui.Button;

import java.util.List;

public class PaymentHistoryView extends ViewImpl implements PaymentHistoryPresenter.ViewImpl {

    @UiField
    HTMLPanel quarterPayments;

    @Inject
    Provider<QuarterPaymentPresenterWidget> quarterWidgetProvider;

    @Inject
    PaymentHistoryView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setQuarters(List<Quarter> quarters) {
        quarterPayments.clear();
        for (Quarter quarter: quarters) {
            QuarterPaymentPresenterWidget quarterPaymentPresenterWidget = quarterWidgetProvider.get();
            quarterPayments.add(quarterPaymentPresenterWidget.getView());
        }
    }

    interface Binder extends UiBinder<Widget, PaymentHistoryView> {
    }
}