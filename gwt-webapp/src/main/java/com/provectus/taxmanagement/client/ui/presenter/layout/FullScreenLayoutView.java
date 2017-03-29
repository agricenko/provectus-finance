package com.provectus.taxmanagement.client.ui.presenter.layout;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * User: unconsionable
 * Date: 09.07.2015
 */
public class FullScreenLayoutView extends ViewImpl implements FullScreenLayoutPresenter.IView {

    @UiField
    SimplePanel contentPanel;
    @UiField
    SimplePanel headerPanel;

    @Inject
    FullScreenLayoutView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        bindSlot(FullScreenLayoutPresenter.MAIN_SLOT, contentPanel);
        bindSlot(FullScreenLayoutPresenter.HEADER_SLOT, headerPanel);
    }

    interface Binder extends UiBinder<Widget, FullScreenLayoutView> {
    }
}
