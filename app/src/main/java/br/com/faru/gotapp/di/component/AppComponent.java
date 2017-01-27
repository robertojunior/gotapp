package br.com.faru.gotapp.di.component;

import javax.inject.Singleton;

import br.com.faru.gotapp.di.module.AppModule;
import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Retrofit getRetrofit();

}
