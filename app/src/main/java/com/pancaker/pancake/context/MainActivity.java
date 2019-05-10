package com.pancaker.pancake.context;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.pancaker.pancake.R;
import com.pancaker.pancake.custom.HomeFragment;
import com.pancaker.pancake.custom.LetterFragment;
import com.pancaker.pancake.custom.RootFragment;
import com.pancaker.pancake.custom.ThreadPool;
import com.pancaker.pancake.libs.FastBlur;
import com.pancaker.pancake.libs.PictureUtil;

public class MainActivity extends AppCompatActivity {

    private View rootView;

    private Bitmap background;

    private LinearLayout bottomBar;

    private int isInChanging = 0;

    private RootFragment fragment;

    //屏幕中央弹出框
    //private View miniView;

    public View getRootView(){
        return rootView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new HomeFragment(),false);
        initActivity();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(isInChanging == 0){
                    isInChanging = 1;
                    background = FastBlur.doBlur(PictureUtil.activityShot(MainActivity.this),20,true);
                    isInChanging = 0;
                }

            }
        };
        try{
            ThreadPool.put(runnable);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            super.onWindowFocusChanged(hasFocus);
        }

    }

    public void replaceFragment(RootFragment fragment,boolean ifAddToStack){
        this.fragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container,fragment);
        if(ifAddToStack) {
            //transaction.addToBackStack(null);
        }

        transaction.commit();
    }

    private void initActivity(){
        rootView = (View) findViewById(R.id.main_container);
        bottomBar = (LinearLayout) findViewById(R.id.bottom_bar);
        //miniView = getLayoutInflater().inflate(R.layout.custom_mini_view, null);
        //addContentView(miniView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //miniView.setVisibility(View.GONE);
    }

    public void showMiniView(boolean ifShow){
        if(ifShow){
            //miniView.setVisibility(View.VISIBLE);
            rootView.setBackground(new BitmapDrawable(getResources(),background));
            bottomBar.setVisibility(View.GONE);
            fragment.setAllViewShow(false);
        }else{
            //miniView.setVisibility(View.GONE);
            rootView.setBackgroundColor(Color.WHITE);
            bottomBar.setVisibility(View.VISIBLE);
            fragment.setAllViewShow(true);
        }
    }

}
