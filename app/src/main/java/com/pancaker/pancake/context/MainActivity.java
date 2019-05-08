package com.pancaker.pancake.context;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pancaker.pancake.R;
import com.pancaker.pancake.custom.PaperDialog;
import com.pancaker.pancake.custom.ThreadPool;
import com.pancaker.pancake.libs.FastBlur;
import com.pancaker.pancake.libs.PictureUtil;

public class MainActivity extends AppCompatActivity {

    private View rootView;
    //收件箱
    private TextView receiveBox;
    //杂货箱
    private TextView goodsBox;


    private Bitmap background;

    private LinearLayout bottomBar;

    private int isInChanging = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    private void initActivity(){
        receiveBox = (TextView) findViewById(R.id.receive_box);
        goodsBox = (TextView) findViewById(R.id.good_box);
        rootView = (View) findViewById(R.id.main_container);
        bottomBar = (LinearLayout) findViewById(R.id.bottom_bar);
    }

    private void initClickListener(){
        receiveBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showMiniView();
            }
        });
        goodsBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showMiniView();
            }
        });
    }

    private void showMiniView(){
        rootView.setBackground(new BitmapDrawable(getResources(),background));
        controllViesShow(false);
        LayoutInflater inflater = LayoutInflater.from(this);
        //从xml转换为View
        View layoutView = inflater.inflate(R.layout.custom_mini_view, null);
        addContentView(layoutView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }

    private void controllViesShow(boolean isSHow){
        if(isSHow){

            //rootView.setBackgroundColor(Color.WHITE);
        }else{
            receiveBox.setVisibility(View.GONE);
            goodsBox.setVisibility(View.GONE);
            bottomBar.setVisibility(View.GONE);

        }
    }
}
