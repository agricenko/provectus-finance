package com.provectus.taxmanagement.client.ui.presenter.layout;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.provectus.taxmanagement.client.application.ApplicationPlaceManager;
import com.provectus.taxmanagement.client.ui.widget.menu.NavigationPresenterWidget;
import org.gwtbootstrap3.client.ui.Button;

public class HeaderPresenterWidget extends PresenterWidget<HeaderPresenterWidget.HeaderView> {

    public static final PermanentSlot<NavigationPresenterWidget> NAVIGATION_SLOT = new PermanentSlot<>();

    @Inject
    private ApplicationPlaceManager placeManager;
    @Inject
    NavigationPresenterWidget navigationPresenterWidget;

    @Inject
    public HeaderPresenterWidget(EventBus eventBus, HeaderView view) {
        super(eventBus, view);
    }

    @Override
    protected void onBind() {
        setInSlot(NAVIGATION_SLOT, navigationPresenterWidget);

        getView().getLogoutButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                placeManager.revealEmployeeList();
            }
        });
    }

    public interface HeaderView extends View {

        Button getLogoutButton();
    }
}