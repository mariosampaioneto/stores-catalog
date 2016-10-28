package br.com.marioneto.productcatalog.core.network.interceptor;

import android.content.Context;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import timber.log.Timber;


public class HeadersInterceptor implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static Context mContext;

    @Inject
    public HeadersInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Timber.v("RestInterceptor.intercept");
        return chain.proceed(createRequest(chain.request().newBuilder()));
    }

    private Request createRequest(Request.Builder builder) {
        //if we had to do some auth using headers, we could insert them here

//        builder.addHeader("Name", "Value");

        return builder.build();
    }
}