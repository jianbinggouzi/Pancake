package com.pancaker.pancake.context;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pancaker.pancake.R;

/**
 * Created by jianbinggouzi on 19-5-10.
 */

public class WriteLetterFragment extends RootFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.write_letter_fragment,container,false);
        return view;
    }
}
