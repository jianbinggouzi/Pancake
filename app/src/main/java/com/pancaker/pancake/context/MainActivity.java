package com.pancaker.pancake.context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pancaker.pancake.R;
import com.pancaker.pancake.custom.PaperDialog;

public class MainActivity extends AppCompatActivity {

    //收件箱
    private TextView receiveBox;
    //杂货箱
    private TextView goodsBox;
    //弹出面板
    private PaperDialog paperDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
    }

    private void initActivity(){
        receiveBox = (TextView) findViewById(R.id.receive_box);
        goodsBox = (TextView) findViewById(R.id.good_box);
        paperDialog = new PaperDialog(MainActivity.this,R.style.AlertDialogCustom);
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
}
