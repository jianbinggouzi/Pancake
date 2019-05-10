package com.pancaker.pancake.custom;

import android.support.v4.app.Fragment;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianbinggouzi on 19-5-9.
 */

public class RootFragment extends Fragment {

    protected List<View> childViews = new ArrayList<>();

    public void setAllViewShow(boolean isShow){
        for(int i=0;i<childViews.size();i++)
            childViews.get(i).setVisibility((isShow?View.VISIBLE:View.GONE));
    }

}
