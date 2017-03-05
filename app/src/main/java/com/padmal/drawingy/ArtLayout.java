package com.padmal.drawingy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Padmal on 3/5/17.
 */

public class ArtLayout extends View {

    private final int color = Color.BLACK;

    private Paint paint;

    private List<Point> points;

    public ArtLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        initiatePaint();
        points = new ArrayList<>();
    }

    private void initiatePaint() {
        paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Point point : points) {
            canvas.drawCircle(point.x, point.y, 5, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        points.add(new Point(Math.round(touchX), Math.round(touchY)));
        // Redraw
        postInvalidate();
        return true;
    }
}
