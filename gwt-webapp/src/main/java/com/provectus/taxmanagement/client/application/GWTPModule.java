package com.provectus.taxmanagement.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;
import com.provectus.taxmanagement.client.resource.ImageBundle;

/**
 * Created by unconsionable on 19.03.2017.
 */
public class GWTPModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule
                .Builder()
                .tokenFormatter(RouteTokenFormatter.class)
                .defaultPlace(NameTokens.HOME_)
                .errorPlace(NameTokens.HOME_)
                .unauthorizedPlace(NameTokens.HOME_)
                .build());
        install(new ApplicationModule());

        bind(ImageBundle.class).asEagerSingleton();
    }
}
