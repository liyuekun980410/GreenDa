package com.bwei.greendao.app;

import android.app.Application;

import com.bwei.greendao.utils.GreendaoUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GreendaoUtils.getInstance().initGreenDao(this);//初始化greendao
        Fresco.initialize(this);
    }
}
