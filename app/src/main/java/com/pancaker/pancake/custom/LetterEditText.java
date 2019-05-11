package com.pancaker.pancake.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.EditText;

import com.pancaker.pancake.libs.WindowManagerUtil;

/**
 * Created by jianbinggouzi on 19-5-10.
 */

public class LetterEditText extends AppCompatEditText {

    private Context context;

    public LetterEditText(Context context){
        super(context);
        this.context = context;
    }

    public LetterEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }
    public LetterEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int windowsWidth = WindowManagerUtil.getWindowsWidthPixel(getContext());
        int windowsHeight = WindowManagerUtil.getWindowsWidthPixel(getContext());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        paint.setFakeBoldText(true);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int scrollX = getScrollX() + windowsWidth;
        int innerHeight = scrollY + getHeight() - paddingBottom;
        int lineHeight = getLineHeight();
        int baseLine = scrollY
                + (lineHeight - ((scrollY - paddingTop) % lineHeight));
        int x = 8;
        while (baseLine < innerHeight) {
            canvas.drawLine(x, baseLine, scrollX - x, baseLine, paint);
            baseLine += lineHeight;
        }

        super.onDraw(canvas);
    }
}
