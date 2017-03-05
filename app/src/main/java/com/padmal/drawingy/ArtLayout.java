package com.padmal.drawingy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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

    private int color = Color.BLACK;

    private Paint paint;

    private List<Point> points;

    private Path path = new Path();

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
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float X = event.getX();
        float Y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(X, Y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(X, Y);
                break;
            default:
                return false;
        }
        // Redraw
        postInvalidate();
        return true;
    }

    public void setDrawColor(String color) {

        switch (color) {
            case "Red":
                this.color = Color.RED;
                paint.setColor(this.color);
                break;
            case "Blue":
                this.color = Color.BLUE;
                paint.setColor(this.color);
                break;
            case "Green":
                this.color = Color.GREEN;
                paint.setColor(this.color);
                break;
            default:
                break;
        }
    }
}
