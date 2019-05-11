package com.pancaker.pancake.custom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jianbinggouzi on 19-5-6.
 */

public class ThreadPool {

    private static ExecutorService executorService = null;

    public static ExecutorService getInstance(){
        if(executorService == null)
            synchronized (ExecutorService.class){
                if(executorService == null){
                    executorService = Executors.newCachedThreadPool();
                }
            }

        return executorService;
    }

    public static void put(Runnable runnable) throws Exception{
        getInstance();
        executorService.execute(runnable);
    }

}
