package com.provectus.taxmanagement.client.ui.presenter.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.provectus.taxmanagement.client.application.ApplicationPlaceManager;
import com.provectus.taxmanagement.client.application.NameTokens;
import com.provectus.taxmanagement.client.ui.presenter.common.LoginPresenter;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {

    @Inject
    private ApplicationPlaceManager placeManager;
    @Inject
    LoginPresenter loginPresenter;

    public static final PermanentSlot<LoginPresenter> CONTENT_SLOT = new PermanentSlot<>();

    @Inject
    public HomePresenter(
            final MyProxy proxy,
            final EventBus eventBus,
            final MyView view) {
        super(eventBus, view, proxy, RevealType.Root);
    }

    @Override
    protected void onBind() {
        setInSlot(CONTENT_SLOT, loginPresenter);
    }

    public interface MyView extends View {

    }

    @ProxyCodeSplit
    @NameToken(NameTokens.HOME_)
    public interface MyProxy extends ProxyPlace<HomePresenter> {
    }
}