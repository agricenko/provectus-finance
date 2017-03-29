package com.provectus.taxmanagement.client.ui.presenter.common;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.*;

public class LoginView extends ViewImpl implements LoginPresenter.MyView {

    @UiField
    Button loginButton;

    @UiField
    TextBox login;
    @UiField
    Input password;

    @UiField
    Alert errorBlock;

    @Inject
    public LoginView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public Button getLoginButton() {
        return loginButton;
    }

    @Override
    public void setErrorMessage(String text) {
//        errorBlock.setVisible(text != null);
    }

    interface Binder extends UiBinder<Form, LoginView> {
    }
}
