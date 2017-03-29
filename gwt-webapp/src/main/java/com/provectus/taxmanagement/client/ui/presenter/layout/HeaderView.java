package com.provectus.taxmanagement.client.ui.presenter.layout;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Label;

public class HeaderView extends ViewImpl implements HeaderPresenterWidget.HeaderView {

    @UiField
    Label login;

    @UiField
    HTMLPanel navigation;

    @UiField
    Button logoutButton;

    @Inject
    HeaderView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        bindSlot(HeaderPresenterWidget.NAVIGATION_SLOT, navigation);
    }

    @Override
    public Button getLogoutButton() {
        return logoutButton;
    }

    interface Binder extends UiBinder<Widget, HeaderView> {
    }
}