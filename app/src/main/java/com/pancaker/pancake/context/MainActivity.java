package com.pancaker.pancake.context;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pancaker.pancake.R;
import com.pancaker.pancake.custom.ThreadPool;
import com.pancaker.pancake.libs.FastBlur;
import com.pancaker.pancake.libs.WindowManagerUtil;

public class MainActivity extends AppCompatActivity {

    private View rootView;

    private Bitmap background;

    private LinearLayout bottomBar;

    private int isInChanging = 0;

    private RootFragment fragment;

    private ImageView indexButton;

    private ImageView writeLetterButton;

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
        initClickListener();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(isInChanging == 0){
                    isInChanging = 1;
                    try{
                        background = FastBlur.doBlur(WindowManagerUtil.activityShot(MainActivity.this),20,true);
                    }catch (Exception e){
                        Log.i("--------","----------");
                    }finally{
                        isInChanging = 0;
                    }
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
        indexButton = (ImageView) findViewById(R.id.index_button);
        writeLetterButton = (ImageView) findViewById(R.id.write_letter_button);
        //miniView = getLayoutInflater().inflate(R.layout.custom_mini_view, null);
        //addContentView(miniView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //miniView.setVisibility(View.GONE);
    }

    private void initClickListener(){
        indexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HomeFragment(),true);
            }
        });
        writeLetterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new WriteLetterFragment(),true);
            }
        });

    }

    public void showMiniView(boolean ifShow){
        if(ifShow){
            //miniView.setVisibility(View.VISIBLE);
            if(background != null)
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
