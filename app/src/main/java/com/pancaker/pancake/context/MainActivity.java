package com.pancaker.pancake.context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.pancaker.pancake.R;

public class MainActivity extends AppCompatActivity {

    private TextView shoujian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
