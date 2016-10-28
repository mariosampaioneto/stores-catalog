package br.com.marioneto.productcatalog.dagger.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.marioneto.productcatalog.BuildConfig;
import br.com.marioneto.productcatalog.R;
import br.com.marioneto.productcatalog.core.network.interceptor.HeadersInterceptor;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
public class NetworkModule {

    private static final int CACHE_SIZE_10_MB = 10 * 1024 * 1024;

    @Provides
    @Reusable
    Cache providesOkHttpCache(Application application) {
        int cacheSize = CACHE_SIZE_10_MB;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Reusable
    Gson providesGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
    }

    @Provides
    @Reusable
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return httpLoggingInterceptor;
    }

    @Provides
    @Reusable
    HeadersInterceptor providesHeadersInterceptor(Context context) {
        return new HeadersInterceptor(context);
    }

    @Provides
    @Reusable
    OkHttpClient providesOkHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor, HeadersInterceptor headersInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(headersInterceptor)
                .cache(cache).build();
    }

    @Provides
    @Reusable
    GsonConverterFactory providesGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Reusable
    SimpleXmlConverterFactory providesSimpleXmlConverterFactory() {
        return SimpleXmlConverterFactory.create();
    }

    @Provides
    @Reusable
    RxJavaCallAdapterFactory providesRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Reusable
    Retrofit providesRetrofit(SimpleXmlConverterFactory simpleXmlConverterFactory, GsonConverterFactory gsonConverterFactory, OkHttpClient okHttpClient,
                              RxJavaCallAdapterFactory rxJavaCallAdapterFactory, Context context) {
        return new Retrofit.Builder().addConverterFactory(simpleXmlConverterFactory) //why not json/gson?!?!?! <o>
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .baseUrl(context.getString(R.string.HOST))
                .client(okHttpClient)
                .build();
    }

}