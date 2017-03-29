package com.provectus.taxmanagement.client.ui.widget.payment;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.provectus.taxmanagement.client.application.ApplicationPlaceManager;
import com.provectus.taxmanagement.shared.model.Quarter;

public class QuarterPaymentPresenterWidget extends PresenterWidget<QuarterPaymentPresenterWidget.ViewI> {

    @Inject
    ApplicationPlaceManager placeManager;

    private Quarter quarter;

    @Inject
    public QuarterPaymentPresenterWidget(EventBus eventBus, ViewI view) {
        super(eventBus, view);
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public interface ViewI extends View {

        void setQuarter(Quarter quarter);
    }
}
