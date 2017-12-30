package com.zzj.myapplication22;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/12/30/030.
 */

public class ScrollImageView extends android.support.v7.widget.AppCompatImageView {

    private int height;

    public ScrollImageView(Context context) {
        this(context,null);
    }

    public ScrollImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScrollImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        height = wm.getDefaultDisplay().getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int[] location = new int[2];
        getLocationOnScreen(location);
        int y = location[1];
        Drawable drawable = getDrawable();
        int w = getWidth();
        int h = (int) (getWidth() * 1.0f / drawable.getIntrinsicWidth() * drawable.getIntrinsicHeight());
        drawable.setBounds(0, 0, w, h);
        int startH = (height - h)/2;
        int endH = height - startH;

        if (y>startH && y<endH-getBottom()){
            canvas.translate(0, -(y-startH));
        }else if (y>=endH-getBottom()){
            canvas.translate(0, getBottom()-h);
        }
        super.onDraw(canvas);
        invalidate();
    }
}
