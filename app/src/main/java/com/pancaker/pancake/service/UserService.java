package com.pancaker.pancake.service;

import com.pancaker.pancake.dao.DaoManager;
import com.pancaker.pancake.dao.UserDao;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class UserService extends BaseService {
    ThreadLocal<UserDao> userDaoThreadLocal = new ThreadLocal<>();
    UserDao userDao ;
    static{
        try{
            UserDao userDao = DaoManager.getInstance().getDaoSession().getUserDao();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
