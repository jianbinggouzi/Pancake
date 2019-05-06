package com.pancaker.pancake.service;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jianbinggouzi on 19-5-6.
 */

public class BaseService {

    public OkHttpClient client;

    public BaseService(){
        client = new OkHttpClient.Builder().connectTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS).build();
    }

    public void post(String url, HashMap<String,String> map, final DataCaller dataCaller){
        FormBody.Builder builder = new FormBody.Builder();
        Set<String> keySet = map.keySet();
        for(Iterator i = keySet.iterator();i.hasNext();){
            String key;
            builder.add(key = ((String)i.next()),map.get(key));
        }
        FormBody formBody = builder.build();
        final Request request = new Request.Builder().url(url).post(formBody).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                dataCaller.onFailed("网络请求出错");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                dataCaller.onResponse(response);
            }
        });
    }

    public void get(String url, final DataCaller dataCaller){
        final Request request = new Request.Builder().url(url).get().build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                dataCaller.onFailed("网络请求出错");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                dataCaller.onResponse(request);
            }
        });
    }

    public void exeOnThread(final Class clazz,final String methodName,final Class[] shape_params,final Class[] real_params,final DataCaller dataCaller) throws Exception{
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    Object instance = clazz.newInstance();
                    Method method = clazz.getDeclaredMethod(methodName,shape_params);
                    dataCaller.onResponse(method.invoke(instance,real_params));
                }catch (Exception e){
                    dataCaller.onFailed("BaseService.exeOnThread出错");
                }

            }
        };
        new Thread(runnable).start();

    }

}
