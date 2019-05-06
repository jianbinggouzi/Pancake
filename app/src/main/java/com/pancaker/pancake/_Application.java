package com.pancaker.pancake;

import android.app.Application;
import android.content.Context;

import com.pancaker.pancake.dao.DaoManager;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class _Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new DaoManager(getApplicationContext());
    }
}