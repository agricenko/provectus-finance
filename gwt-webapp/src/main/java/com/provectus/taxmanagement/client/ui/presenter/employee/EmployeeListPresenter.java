package com.provectus.taxmanagement.client.ui.presenter.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.provectus.taxmanagement.client.ui.widget.table.EmployeeTable;
import org.gwtbootstrap3.client.ui.Button;

public class EmployeeListPresenter extends Presenter<EmployeeListPresenter.ViewImpl, EmployeeListPresenter.Proxy> {

    @Inject
    ApplicationPlaceManager applicationPlaceManager;

    @Inject
    public EmployeeListPresenter(
            final EventBus eventBus,
            final ViewImpl view,
            final Proxy proxy) {
        super(eventBus, view, proxy, FullScreenLayoutPresenter.MAIN_SLOT);
    }

    @Override
    protected void onReset() {
        reloadEmployeeTable();
    }

    @Override
    protected void onBind() {
        getView().getRefreshTable().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                reloadEmployeeTable();
            }
        });
    }

    public void reloadEmployeeTable() {
        //TODO reload data from Rest Service
    }

    public interface ViewImpl extends View {

        EmployeeTable getEmployeeTable();

        Button getAddEmployeeButton();

        Button getEditEmployeeButton();

        Button getRefreshTable();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @NameToken(NameTokens.EMPLOYEE_LIST)
    public interface Proxy extends ProxyPlace<EmployeeListPresenter> {
    }
}