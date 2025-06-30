package com.example.helloworld;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

public class MyApplication extends Application {
    public static Map<String, String> userCredentials = new HashMap<>();
    @Override
    public void onCreate() {
        super.onCreate();
        userCredentials.put("jencalada", "1234");
        userCredentials.put("admin", "adm1n");
    }
}
