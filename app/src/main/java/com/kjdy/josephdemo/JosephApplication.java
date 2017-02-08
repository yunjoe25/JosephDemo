package com.kjdy.josephdemo;

import android.app.Application;

import com.kjdy.josephdemo.util.UtilLog;

/**
 * Created by yunjo on 2/6/2017.
 */

//static methods can be saved here
public class JosephApplication extends Application {
    //runs before any activity runs
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);

    }
}
