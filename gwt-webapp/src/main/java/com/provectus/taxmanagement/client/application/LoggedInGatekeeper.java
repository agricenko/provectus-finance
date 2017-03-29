package com.provectus.taxmanagement.client.application;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.GatekeeperWithParams;
import com.provectus.taxmanagement.shared.UserSession;

/**
 * Created by unconsionable on 19.03.2017.
 */
public class LoggedInGatekeeper implements GatekeeperWithParams {

    @Inject
    UserSession userSession;

    @Override
    public GatekeeperWithParams withParams(String[] params) {
        return null;
    }

    @Override
    public boolean canReveal() {
        return true;
    }
}
