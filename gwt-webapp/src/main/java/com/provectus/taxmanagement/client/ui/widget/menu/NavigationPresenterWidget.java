package com.provectus.taxmanagement.client.ui.widget.menu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.provectus.taxmanagement.client.application.ApplicationPlaceManager;
import org.gwtbootstrap3.client.ui.Button;

public class NavigationPresenterWidget extends PresenterWidget<NavigationPresenterWidget.NavigationBarView> {

    @Inject
    ApplicationPlaceManager placeManager;

    @Inject
    public NavigationPresenterWidget(EventBus eventBus, NavigationBarView view) {
        super(eventBus, view);
    }

    @Override
    protected void onBind() {
        getView().getEmployeeButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                placeManager.revealEmployeeList();
            }
        });

        getView().getPaymentHistoryButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                placeManager.revealPaymentHistory();
            }
        });

        getView().getReportsButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                placeManager.revealReports();
            }
        });
    }

    public interface NavigationBarView extends View {

        Button getEmployeeButton();

        Button getPaymentHistoryButton();

        Button getReportsButton();
    }
}
