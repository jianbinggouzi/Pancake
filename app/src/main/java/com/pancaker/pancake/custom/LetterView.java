package com.pancaker.pancake.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.pancaker.pancake.R;
import com.pancaker.pancake._Application;
import com.pancaker.pancake.libs.FileUtil;

/**
 * Created by jianbinggouzi on 19-5-16.
 */

public class LetterView extends View {

    private int defaultSize = 100;

    private String[] strings = new String[3];

    //三行文字在原图中的原点x 基线y 最后两位存储宽度 长度
    private int[] indexs = new int[8];

    public LetterView(Context context){
        super(context);
    }

    public LetterView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    private int getThisSize(int measureSpec){
        int res = defaultSize;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode){
            case MeasureSpec.UNSPECIFIED:
                res = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                res = size;
                break;
            case MeasureSpec.EXACTLY:
                res = size;
                break;
        }
        return res;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getThisSize(widthMeasureSpec);
        int height = getThisSize(heightMeasureSpec);
        setMeasuredDimension(width,height);
    }

    public void setStringsAndIndex(String[] strings,int[] indexs){
        for(int i=0;i<3;i++)
            this.strings[i] = strings[i];
        for(int i=0;i<8;i++)
            this.indexs[i] = indexs[i];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(_Application.letterBitmap == null)
            _Application.letterBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.letter_);

        Bitmap _bitmap = _Application.letterBitmap;
        _bitmap = FileUtil.imageScale(_bitmap,getMeasuredWidth(),getMeasuredHeight());
        Bitmap bitmap = Bitmap.createBitmap(_bitmap,0,0,_bitmap.getWidth(),_bitmap.getHeight());

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);

        Paint paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        paint1.setStrokeWidth(3);
        paint1.setTextSize((float)140/4667*getMeasuredHeight());

        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        setStringsAndIndex(new String[]{"测试1","测试2","测试3"},new int[]{264,3306,552,3476,376,3658,2480,4667});
        for(int i=0;i<6;i=i+2){
            canvas.drawText(strings[i/2],(float) indexs[i]/indexs[6]*getMeasuredWidth(),(float)indexs[i+1]/indexs[7]*getMeasuredHeight(),paint1);
        }

    }
}
