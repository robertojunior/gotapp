package br.com.faru.gotapp.app;

import android.app.Application;

import br.com.faru.gotapp.BuildConfig;
import br.com.faru.gotapp.di.Injector;
import br.com.faru.gotapp.di.component.AppComponent;
import br.com.faru.gotapp.di.component.DaggerAppComponent;
import br.com.faru.gotapp.di.component.DaggerGOTComponent;
import br.com.faru.gotapp.di.module.AppModule;

public class GOTApplication extends Application {

    public static GOTApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        final AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(BuildConfig.BASE_URL))
                .build();

        Injector.initialize(DaggerGOTComponent.builder().appComponent(appComponent).build());
    }

    public static GOTApplication getApplication() {
        return application;
    }

}
