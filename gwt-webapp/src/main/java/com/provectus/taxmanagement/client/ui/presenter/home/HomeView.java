package com.provectus.taxmanagement.client.ui.presenter.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Button;

/**
 * User: unconsionable
 * Date: 30.05.2015
 */
public class HomeView extends ViewImpl implements HomePresenter.MyView {

    @UiField
    SimplePanel contentPanel;

    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        bindSlot(HomePresenter.CONTENT_SLOT, contentPanel);
    }

    interface Binder extends UiBinder<Widget, HomeView> {
    }
}
