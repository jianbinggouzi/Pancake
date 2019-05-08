package com.pancaker.pancake.context;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    //弹出面板
    private PaperDialog paperDialog;

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
        paperDialog = new PaperDialog(MainActivity.this,R.style.AlertDialogCustom){
            @Override
            public void dismiss() {
                super.dismiss();
                controllViesShow(true);
            }
        };
        rootView = (View) findViewById(R.id.main_container);
        bottomBar = (LinearLayout) findViewById(R.id.bottom_bar);
        paperDialog.createDialog();
    }

    private void initClickListener(){
        receiveBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("receiveBox","receiveBox-message","receiveBox-remark");
            }
        });
        goodsBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("goodsBox","goodsBox-message","messageBox-remark");
            }
        });
    }

    private void showDialog(String title,String message,String remark){
        rootView.setBackground(new BitmapDrawable(getResources(),background));
        controllViesShow(false);
        paperDialog.setTitle(title);
        paperDialog.setMessage(message);
        paperDialog.setRemark(remark);
        paperDialog.setCheckOnClickListener("确认",new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                paperDialog.dismiss();
            }
        });
        paperDialog.show();
    }

    private void controllViesShow(boolean isSHow){
        if(isSHow){
            receiveBox.setVisibility(View.VISIBLE);
            goodsBox.setVisibility(View.VISIBLE);
            bottomBar.setVisibility(View.VISIBLE);
            rootView.setBackgroundColor(Color.WHITE);
        }else{
            receiveBox.setVisibility(View.GONE);
            goodsBox.setVisibility(View.GONE);
            bottomBar.setVisibility(View.GONE);
        }
    }
}
