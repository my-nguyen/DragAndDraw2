package com.bignerdranch.android.draganddraw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by My on 2/1/2016.
 */
// this class is a custom view that derives from View which is a blank canvas
public class BoxDrawingView extends View {
   public static final String    TAG = "BoxDrawingView";
   private Box       mCurrentBox;
   private List<Box> mBoxes = new ArrayList<>();
   private Paint     mBoxPaint;
   private Paint     mBackgroundPaint;

   // this method is used when creating the view in code
   public BoxDrawingView(Context context) {
      this(context, null);
   }

   // this method is used when inflating the view from XML
   public BoxDrawingView(Context context, AttributeSet attributeSet) {
      super(context, attributeSet);
      // paint the box a nice semitransparent red (ARGB)
      mBoxPaint = new Paint();
      mBoxPaint.setColor(0x22ff0000);
      // paint the background off-white
      mBackgroundPaint = new Paint();
      mBackgroundPaint.setColor(0xfff8efe0);
   }

   @Override
   public boolean onTouchEvent(MotionEvent event) {
      PointF current = new PointF(event.getX(), event.getY());
      String action = "";
      switch (event.getAction()) {
         case MotionEvent.ACTION_DOWN:
            action = "ACTION_DOWN";
            // set mCurrentBox to be a new Box with its origin as the event’s location.
            mCurrentBox = new Box(current);
            // this new Box is added to the list of boxes.
            mBoxes.add(mCurrentBox);
            break;
         case MotionEvent.ACTION_MOVE:
            action = "ACTION_MOVE";
            // update mCurrentBox.mCurrent as the user’s finger moves around the screen
            if (mCurrentBox != null) {
               mCurrentBox.setCurrent(current);
               // force BoxDrawingView to redraw itself so that the user can see the box while
               // dragging across the screen.
               invalidate();
            }
            break;
         case MotionEvent.ACTION_UP:
            // user's finger leaves the screen
            action = "ACTION_UP";
            mCurrentBox = null;
            break;
         case MotionEvent.ACTION_CANCEL:
            // touch is cancelled
            action = "ACTION_CANCEL";
            mCurrentBox = null;
            break;
      }
      Log.i(TAG, action + " at x=" + current.x + ", y=" + current.y);
      return true;
   }

   @Override
   protected void onDraw(Canvas canvas) {
      // fill the background with off-white color
      canvas.drawPaint(mBackgroundPaint);
      for (Box box : mBoxes) {
         // calculate the 4 corners of a rectangle
         float left = Math.min(box.getOrigin().x, box.getCurrent().x);
         float right = Math.max(box.getOrigin().x, box.getCurrent().x);
         float top = Math.min(box.getOrigin().y, box.getCurrent().y);
         float bottom = Math.max(box.getOrigin().y, box.getCurrent().y);
         // draw the rectangle with semitransparent red color
         canvas.drawRect(left, top, right, bottom, mBoxPaint);
      }
   }
}
