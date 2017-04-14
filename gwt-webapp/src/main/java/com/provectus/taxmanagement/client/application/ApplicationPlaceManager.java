package com.provectus.taxmanagement.client.application;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class ApplicationPlaceManager {

    @Inject
    private PlaceManager placeManager;

    public void revealHome() {
        reveal(NameTokens.HOME_);
    }

    public void revealEmployeeList() {
        reveal(NameTokens.EMPLOYEE_LIST_);
    }

    public void revealPaymentHistory() {
        reveal(NameTokens.PAYMENT_HISTORY_);
    }

    public void reveal(String nameToken) {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(nameToken).build());
    }

}