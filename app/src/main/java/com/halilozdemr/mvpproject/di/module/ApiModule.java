package com.halilozdemr.mvpproject.di.module;

import com.halilozdemr.mvpproject.di.scope.PerActivity;
import com.halilozdemr.mvpproject.rest.repository.ApiClient;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class ApiModule {
    @Provides
    @PerActivity
    protected ApiClient provideApi(Retrofit.Builder builder) {
        return builder.baseUrl(ApiClient.BASE_URL).build().create(ApiClient.class);
    }
}
