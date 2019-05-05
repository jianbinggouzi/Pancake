package com.pancaker.pancake.dao;

import android.app.Application;
import android.content.Context;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class DaoManager {

    private static DaoManager instance = null;

    private DaoMaster daoMaster;

    private DaoSession daoSession;


    public DaoManager(Context context){
        init(context);
        instance = this;
    }



    public static DaoManager getInstance() throws Exception{
        if(instance == null){
            throw new Exception("DaoManager未初始化");
        }
        return instance;
    }

    private void init(Context context){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,"pancake");
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public DaoMaster getDaoMaster(){
        return daoMaster;
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }

    public DaoSession getNewSession(){
        return daoMaster.newSession();
    }


}
