package com.example.chemm.jimdemo;

import android.app.Application;

import com.example.chemm.jimdemo.util.UtilLog;

/**
 * Created by chemm on 2/15/2017.
 */

public class JimApplication extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
