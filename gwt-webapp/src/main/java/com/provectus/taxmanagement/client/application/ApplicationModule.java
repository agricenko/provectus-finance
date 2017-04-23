package com.provectus.taxmanagement.client.application;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.provectus.taxmanagement.client.ui.presenter.common.LoginPresenter;
import com.provectus.taxmanagement.client.ui.presenter.common.LoginView;
import com.provectus.taxmanagement.client.ui.presenter.employee.EmployeeListPresenter;
import com.provectus.taxmanagement.client.ui.presenter.employee.EmployeeListView;
import com.provectus.taxmanagement.client.ui.presenter.employee.EmployeePresenter;
import com.provectus.taxmanagement.client.ui.presenter.employee.EmployeeView;
import com.provectus.taxmanagement.client.ui.presenter.home.HomePresenter;
import com.provectus.taxmanagement.client.ui.presenter.home.HomeView;
import com.provectus.taxmanagement.client.ui.presenter.layout.FullScreenLayoutPresenter;
import com.provectus.taxmanagement.client.ui.presenter.layout.FullScreenLayoutView;
import com.provectus.taxmanagement.client.ui.presenter.layout.HeaderPresenterWidget;
import com.provectus.taxmanagement.client.ui.presenter.layout.HeaderView;
import com.provectus.taxmanagement.client.ui.presenter.payment.PaymentHistoryPresenter;
import com.provectus.taxmanagement.client.ui.presenter.payment.PaymentHistoryView;
import com.provectus.taxmanagement.client.ui.widget.menu.NavigationPresenterWidget;
import com.provectus.taxmanagement.client.ui.widget.menu.NavigationView;
import com.provectus.taxmanagement.client.ui.widget.payment.QuarterViewPresenterWidget;
import com.provectus.taxmanagement.client.ui.widget.payment.QuarterPaymentView;
import com.provectus.taxmanagement.shared.UserSession;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bindApplicationClasses();

        bindPresenter(FullScreenLayoutPresenter.class, FullScreenLayoutPresenter.IView.class, FullScreenLayoutView.class, FullScreenLayoutPresenter.IProxy.class);
        bindPresenter(HomePresenter.class, HomePresenter.MyView.class, HomeView.class, HomePresenter.MyProxy.class);
        bindPresenter(EmployeeListPresenter.class, EmployeeListPresenter.ViewImpl.class, EmployeeListView.class, EmployeeListPresenter.Proxy.class);
        bindPresenter(PaymentHistoryPresenter.class, PaymentHistoryPresenter.ViewImpl.class, PaymentHistoryView.class, PaymentHistoryPresenter.Proxy.class);
        bindPresenter(EmployeePresenter.class, EmployeePresenter.ViewImpl.class, EmployeeView.class, EmployeePresenter.Proxy.class);

        bindPresenterWidget(LoginPresenter.class, LoginPresenter.MyView.class, LoginView.class);
        bindPresenterWidget(HeaderPresenterWidget.class, HeaderPresenterWidget.HeaderView.class, HeaderView.class);
        bindPresenterWidget(NavigationPresenterWidget.class, NavigationPresenterWidget.NavigationBarView.class, NavigationView.class);
        bindPresenterWidget(QuarterViewPresenterWidget.class, QuarterViewPresenterWidget.ViewI.class, QuarterPaymentView.class);
    }

    private void bindApplicationClasses() {
        bind(LoggedInGatekeeper.class).in(Singleton.class);
        bind(ApplicationPlaceManager.class).in(Singleton.class);
        bind(UserSession.class).in(Singleton.class);
    }
}
