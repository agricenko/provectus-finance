package com.provectus.taxmanagement.client.ui.presenter.layout;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * User: unconsionable
 * Date: 09.07.2015
 */
public class FullScreenLayoutPresenter extends Presenter<FullScreenLayoutPresenter.IView, FullScreenLayoutPresenter.IProxy> {

    public static final PermanentSlot<HeaderPresenterWidget> HEADER_SLOT = new PermanentSlot<>();
    public static final NestedSlot MAIN_SLOT = new NestedSlot();

    @Inject
    HeaderPresenterWidget headerPresenterWidget;


    @Inject
    public FullScreenLayoutPresenter(EventBus eventBus, IView view, IProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }

    @Override
    protected void onBind() {
        setInSlot(HEADER_SLOT, headerPresenterWidget);
    }

    @ProxyStandard
    public interface IProxy extends Proxy<FullScreenLayoutPresenter> {
    }

    public interface IView extends View {
    }
}
