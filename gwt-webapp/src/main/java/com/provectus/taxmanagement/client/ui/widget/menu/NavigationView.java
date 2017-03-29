package com.provectus.taxmanagement.client.ui.widget.menu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.provectus.taxmanagement.client.application.NameTokens;
import org.gwtbootstrap3.client.ui.Button;

public class NavigationView extends ViewImpl implements NavigationPresenterWidget.NavigationBarView {

    @UiField
    Button employeeButton;
    @UiField
    Button paymentHistoryButton;

    @Inject
    public NavigationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public Button getEmployeeButton() {
        return employeeButton;
    }

    @Override
    public Button getPaymentHistoryButton() {
        return paymentHistoryButton;
    }

    interface Binder extends UiBinder<Widget, NavigationView> {
    }
}