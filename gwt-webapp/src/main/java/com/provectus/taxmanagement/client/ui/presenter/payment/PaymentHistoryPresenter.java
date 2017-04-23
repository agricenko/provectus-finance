package com.provectus.taxmanagement.client.ui.presenter.payment;

import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.provectus.taxmanagement.client.application.ApplicationPlaceManager;
import com.provectus.taxmanagement.client.application.LoggedInGatekeeper;
import com.provectus.taxmanagement.client.application.NameTokens;
import com.provectus.taxmanagement.client.ui.presenter.layout.FullScreenLayoutPresenter;
import com.provectus.taxmanagement.client.ui.widget.employee.EmployeeList;
import com.provectus.taxmanagement.shared.model.Employee;
import com.provectus.taxmanagement.shared.model.Quarter;

import java.util.ArrayList;
import java.util.List;

public class PaymentHistoryPresenter extends Presenter<PaymentHistoryPresenter.ViewImpl, PaymentHistoryPresenter.Proxy> {

    @Inject
    ApplicationPlaceManager applicationPlaceManager;

    @Inject
    public PaymentHistoryPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy, FullScreenLayoutPresenter.MAIN_SLOT);
    }

    @Override
    protected void onReset() {
        reloadEmployeeTable();
        List<Quarter> quarters = new ArrayList<>();
        quarters.add(new Quarter());
        quarters.add(new Quarter());
        quarters.add(new Quarter());
        quarters.add(new Quarter());
        quarters.add(new Quarter());
        getView().setQuarters(quarters);
    }

    @Override
    protected void onBind() {
        getView().getEmployeeList().addSelectionHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent selectionChangeEvent) {
                Employee selected = getView().getEmployeeList().getSelected();
                applicationPlaceManager.revealPaymentHistory(selected.getId());
            }
        });
    }

    public void reloadEmployeeTable() {
        //TODO reload data from Rest Service
    }

    public interface ViewImpl extends View {

        EmployeeList getEmployeeList();

        void setQuarters(List<Quarter> quarters);
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @NameToken(NameTokens.PAYMENT_HISTORY)
    public interface Proxy extends ProxyPlace<PaymentHistoryPresenter> {
    }
}