package com.provectus.taxmanagement.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.provectus.taxmanagement.client.resource.ImageBundle;

/**
 * Created by unconsionable on 19.03.2017.
 */
public class GWTPModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule
                .Builder()
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME)
                .unauthorizedPlace(NameTokens.HOME)
                .build());
        install(new ApplicationModule());

        bind(ImageBundle.class).asEagerSingleton();
    }
}
