package com.provectus.taxmanagement.client.ui.widget.payment;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.gwtplatform.mvp.client.ViewImpl;
import com.provectus.taxmanagement.shared.model.Quarter;
import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Panel;
import org.gwtbootstrap3.client.ui.PanelCollapse;

public class QuarterPaymentView extends ViewImpl implements QuarterPaymentPresenterWidget.ViewI {

    @UiField
    Panel panel;

    @UiField
    Anchor anchor;
    @UiField
    Button saveButton;
    @UiField
    Button removeButton;

    @UiField
    PanelCollapse panelCollapse;

    public QuarterPaymentView() {
        Binder uiBinder = GWT.create(Binder.class);
        initWidget(uiBinder.createAndBindUi(this));

        anchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                panelCollapse.setIn(!panelCollapse.isIn());
            }
        });
    }

    @Override
    public void setQuarter(Quarter quarter) {
        anchor.setText(quarter.getDescription());
    }

    interface Binder extends UiBinder<Panel, QuarterPaymentView> {
    }
}
