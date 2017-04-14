package com.provectus.taxmanagement.client.ui.presenter.common;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.provectus.taxmanagement.client.application.ApplicationPlaceManager;
import com.provectus.taxmanagement.shared.UserSession;
import org.gwtbootstrap3.client.ui.Button;

public class LoginPresenter extends PresenterWidget<LoginPresenter.MyView> {

    @Inject
    private ApplicationPlaceManager placeManager;
    @Inject
    UserSession userSession;

    @Inject
    public LoginPresenter(EventBus eventBus, MyView view) {
        super(eventBus, view);
    }

    @Override
    protected void onBind() {
        getView().getLoginButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                placeManager.revealEmployeeList();
            }
        });
    }

    public interface MyView extends View {

        Button getLoginButton();

        void setErrorMessage(String text);
    }
}
