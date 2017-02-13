package com.kjdy.josephdemo;

import android.app.Application;
import android.widget.Toast;

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
        // Utilizing UtilLog by setting switch to true
        UtilLog.setDebug(true);

        // toasting debug status
        if(UtilLog.getDebug()){
            Toast.makeText(this,"UtilLog Debug is turned on",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"UtilLog Debug is turned off",Toast.LENGTH_LONG).show();
        }

    }
}
