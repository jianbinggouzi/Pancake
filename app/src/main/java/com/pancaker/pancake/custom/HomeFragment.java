package com.pancaker.pancake.custom;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.pancaker.pancake.R;
import com.pancaker.pancake.context.MainActivity;
import com.pancaker.pancake.domain.Letter;

import java.util.ArrayList;

/**
 * Created by jianbinggouzi on 19-5-9.
 */

public class HomeFragment extends RootFragment {

    //收件箱
    private TextView receiveBox;
    //杂货箱
    private TextView goodsBox;

    private ArrayList<String> al;

    private ArrayAdapter<String> arrayAdapter;

    private SwipeFlingAdapterView swipeFlingAdapterView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home1_fragment,container,false);
        initActivity(view);
        initClickListener();
        return view;
    }

    private void initActivity(View view){
        receiveBox = view.findViewById(R.id.receive_box);
        goodsBox = view.findViewById(R.id.good_box);
        childViews.add(receiveBox);
        childViews.add(goodsBox);
    }

    public void setMiniView(boolean isShow){
        if(isShow){
            ((MainActivity)getActivity()).showMiniView(true);
        }else{
            ((MainActivity)getActivity()).showMiniView(false);
        }

    }

    private void initClickListener(){
        receiveBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(new LetterFragment(),true);
                setMiniView(true);
            }
        });
        goodsBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(new LetterFragment(),true);
                setMiniView(true);
            }
        });
    }


}
