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
                .applicationId("gxff3WMmhliw9nrYrWy9QuEWHJJn4K9GWImIh2Ck")
                .clientKey("bQ6zrt7s4EQvYkkIYZvtOpdA16X31TjS6MtXRAvH")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
