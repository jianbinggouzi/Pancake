package com.pancaker.pancake.context;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.pancaker.pancake.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianbinggouzi on 19-5-9.
 */

public class LetterFragment extends RootFragment {

    private ArrayList<String> al = new ArrayList<>();

    private ArrayAdapter<String> arrayAdapter;

    private SwipeFlingAdapterView swipeFlingAdapterView;

    private List Data = new ArrayList();

    private int i = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home1_letter_fragment,container,false);
        swipeFlingAdapterView = view.findViewById(R.id.swiper_view);
        childViews.add(swipeFlingAdapterView);
        setData(null);
        init();
        return view;
    }

    private void init(){
        arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.letter_item,R.id.helloText,al);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST------------", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                makeToast(getContext(), "Left!");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(getContext(), "Right!");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                /*
                ****************************
                ********数据为空时***********
                ****************************
                 */

                // Ask for more data here
                //al.add("XML ".concat(String.valueOf(i)));
                //arrayAdapter.notifyDataSetChanged();
                //Log.d("LIST", "notified");
                //i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = swipeFlingAdapterView.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });

        swipeFlingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                makeToast(getContext(), "Clicked!");
            }
        });

    }

    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }


    public void setData(List list){
        al.add("letter_1");
        al.add("letter_2");
        al.add("letter_3");
    }


}
