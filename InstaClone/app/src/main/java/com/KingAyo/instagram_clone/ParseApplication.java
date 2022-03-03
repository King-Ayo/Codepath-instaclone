package com.KingAyo.instagram_clone;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(com.KingAyo.instagram_clone.Post.class);

//        Parse.enableLocalDatastore(this);
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        // Use for monitoring Parse OkHttp traffic
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        // See https://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Xy0jfU5OT2uePGXl5Y439O3Xh4ICqACalkUeBRKB")
                .clientKey("t3hzOcNArW0h5o80v8FhFQbUKIYkya28olqDFtRv")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}