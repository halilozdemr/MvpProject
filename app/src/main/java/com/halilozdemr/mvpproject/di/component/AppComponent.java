package com.halilozdemr.mvpproject.di.component;

import android.app.Application;
import android.content.Context;

import com.halilozdemr.mvpproject.MvpProjectApp;
import com.halilozdemr.mvpproject.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MvpProjectApp app);

    Application application();

    Context context();

    final class Initializer {
        private Initializer() {
        }

        public static AppComponent init(Application application) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(application))
                    .build();
        }
    }
}
