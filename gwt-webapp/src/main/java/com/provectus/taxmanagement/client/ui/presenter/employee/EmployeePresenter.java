package com.provectus.taxmanagement.client.ui.presenter.employee;

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
import com.provectus.taxmanagement.shared.model.Employee;
import org.gwtbootstrap3.client.ui.Button;

public class EmployeePresenter extends Presenter<EmployeePresenter.ViewImpl, EmployeePresenter.Proxy> {

    @Inject
    ApplicationPlaceManager applicationPlaceManager;

    @Inject
    public EmployeePresenter(
            final EventBus eventBus,
            final EmployeePresenter.ViewImpl view,
            final EmployeePresenter.Proxy proxy) {
        super(eventBus, view, proxy, FullScreenLayoutPresenter.MAIN_SLOT);
    }

    @Override
    protected void onBind() {
        getView().getCancelButton().addClickHandler(clickEvent -> {
            applicationPlaceManager.revealEmployeeList();
        });

        getView().getSaveButton().addClickHandler(clickEvent -> {
            Employee employee = getView().getEmployee();
            if (employee != null) {
                //TODO send request to server
                //if employee.id == null -> create new Employee
                //if employee.id != null -> edit Employee
            }
        });
    }

    @Override
    protected void onReset() {
    }

    public interface ViewImpl extends View {

        Employee getEmployee();

        Button getSaveButton();

        Button getCancelButton();
    }

    @ProxyCodeSplit
    @UseGatekeeper(LoggedInGatekeeper.class)
    @NameToken(NameTokens.EMPLOYEE)
    public interface Proxy extends ProxyPlace<EmployeePresenter> {
    }
}
