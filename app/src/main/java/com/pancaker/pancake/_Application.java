package com.pancaker.pancake;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.WindowManager;

import com.pancaker.pancake.dao.DaoManager;
import com.pancaker.pancake.libs.FileUtil;
import com.pancaker.pancake.libs.WindowManagerUtil;


/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class _Application extends Application {
    public static Bitmap letterBitmap;
    @Override
    public void onCreate() {
        super.onCreate();
        letterBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.letter_);

        new DaoManager(getApplicationContext());
        WindowManagerUtil.init(getApplicationContext());

    }
}
