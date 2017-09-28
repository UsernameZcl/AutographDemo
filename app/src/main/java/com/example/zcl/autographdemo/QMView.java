package com.example.zcl.autographdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 李梦月 on 2017/9/26.
 */

public class QMView extends View {

    private Paint paint;
    private Path path;
    private Bitmap bitmap;
    private Canvas canvasbt;

    public QMView(Context context) {
        this(context,null);
    }

    public QMView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public QMView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setFilterBitmap(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeMiter(4);
        paint.setDither(true);
        paint.setFakeBoldText(true);
        paint.setStyle(Paint.Style.STROKE);
        path = new Path();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        canvasbt = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(bitmap==null){
            return;
        }
        int i = canvas.saveLayer(null, null, Canvas.CLIP_SAVE_FLAG);
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restoreToCount(i);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       switch (event.getAction()){
           case MotionEvent.ACTION_DOWN:
               path.reset();
               float x = event.getX();
               float y = event.getY();
               path.moveTo(x,y);
               break;
           case MotionEvent.ACTION_MOVE:
               float movex = event.getX();
               float movey = event.getY();
               path.quadTo(movex,movey,movex,movey);
               break;
           case MotionEvent.ACTION_UP:
               break;
       }
       canvasbt.drawPath(path,paint);
        invalidate();
        return true;
    }

    public Bitmap getBitmap(){
        return bitmap;
    }
}
