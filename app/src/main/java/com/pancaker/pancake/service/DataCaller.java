package com.pancaker.pancake.service;

import org.json.JSONObject;

/**
 * Created by jianbinggouzi on 19-5-6.
 */

public interface DataCaller {
    public void onResponse(Object object);
    public void onFailed(Object object);
}
