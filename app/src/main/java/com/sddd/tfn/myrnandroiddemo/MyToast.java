package com.sddd.tfn.myrnandroiddemo;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.widget.Toast;

/**
 * Created by tfn on 17-1-4.
 */

public class MyToast extends ReactContextBaseJavaModule {
    public MyToast(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "MyToast";
    }

    @ReactMethod
    public void showMyToast(String str) {
        Toast.makeText(getReactApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}
