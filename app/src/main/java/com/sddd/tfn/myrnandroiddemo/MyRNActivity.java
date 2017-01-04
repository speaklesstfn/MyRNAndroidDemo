package com.sddd.tfn.myrnandroiddemo;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * Created by tfn on 17-1-3.
 */

public class MyRNActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {
    private ReactRootView mReactRootView = null;
    private ReactInstanceManager mReactInstanceManager = null;

    @Override
    protected void onCreate(
            @Nullable
                    Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder().setApplication(getApplication()).setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android").addPackage(new MainReactPackage()).addPackage(new MyReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG).setInitialLifecycleState(LifecycleState.RESUMED).build();

        mReactRootView.startReactApplication(mReactInstanceManager, "firstrnandroiddemo", null);

        setContentView(mReactRootView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mReactInstanceManager) {
            mReactInstanceManager.onHostDestroy(this);
        }
    }

    @Override
    public void onBackPressed() {
        if (null == mReactInstanceManager) {
            super.onBackPressed();
        } else {
            mReactInstanceManager.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null != mReactInstanceManager) {
            mReactInstanceManager.onHostPause(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null != mReactInstanceManager) {
            mReactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && null != mReactInstanceManager) {
            mReactInstanceManager.showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }
}
