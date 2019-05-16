package com.pancaker.pancake.libs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by jianbinggouzi on 19-5-16.
 */

public class FileUtil {

    public static Matrix imageScale(Context context,Bitmap bitmap, int dstW, int dstH){
        int srcW = bitmap.getWidth();
        int srcH = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((float) (dstW/srcW),(float)(dstH/srcH));
        return matrix;
    }

    public static Bitmap imageScale(Bitmap bitmap, int dst_w, int dst_h) {
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) dst_w) / src_w;
        float scale_h = ((float) dst_h) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap dstbmp = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix,
                true);
        return dstbmp;
    }

}
