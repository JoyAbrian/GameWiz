package com.ruukaze.gamewiz.ApiService;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private static final String ACCESS_TOKEN = "t305p9r1brzyyf4riproyamqa3pdl3";
    private static final String CLIENT_ID = "o5131lrp043geu51qzrxqv890rekiw";

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        Request.Builder builder = originalRequest.newBuilder()
                .header("Client-ID", CLIENT_ID)
                .header("Authorization", "Bearer " + ACCESS_TOKEN);

        Request newRequest = builder.build();
        return chain.proceed(newRequest);
    }
}