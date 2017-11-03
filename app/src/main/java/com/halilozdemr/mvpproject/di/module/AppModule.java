package com.halilozdemr.mvpproject.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public final class AppModule {
  private final Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton Application provideApplication() {
    return application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return application.getApplicationContext();
  }
}
