package com.provectus.taxmanagement.client.application;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class ApplicationPlaceManager {

    @Inject
    private PlaceManager placeManager;

    public void revealHome() {
        reveal(NameTokens.HOME);
    }

    public void revealEmployeeList() {
        reveal(NameTokens.EMPLOYEE_LIST);
    }

    public void revealPaymentHistory() {
        reveal(NameTokens.PAYMENT_HISTORY);
    }

    public void reveal(String nameToken) {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(nameToken).build());
    }

}