package com.halilozdemr.mvpproject.di.module;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.halilozdemr.mvpproject.BuildConfig;
import com.halilozdemr.mvpproject.di.scope.PerActivity;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public final class NetModule {
    private static final int CLIENT_TIME_OUT = 10;
    private static final int CLIENT_CACHE_SIZE = 10 * 1024 * 1024; // 10 MiB
    private static final String CLIENT_DATE_FORMAT = "yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'";
    private static final String CLIENT_CACHE_DIRECTORY = "http";

    @Provides
    @PerActivity
    Cache provideCache(Application application) {
        return new Cache(new File(application.getCacheDir(), CLIENT_CACHE_DIRECTORY),
                CLIENT_CACHE_SIZE);
    }

    @Provides
    @PerActivity
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(CLIENT_DATE_FORMAT)
                .create();
    }

    @Provides
    @PerActivity
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(BuildConfig.DEBUG
                                ? HttpLoggingInterceptor.Level.BODY
                                : HttpLoggingInterceptor.Level.NONE))
                .connectTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }

    @Provides
    @PerActivity
    Retrofit.Builder provideRetrofitBuilder(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient);
    }
}
