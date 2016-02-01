package com.bignerdranch.android.draganddraw2;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by My on 2/1/2016.
 */
// this class is a custom view that derives from View which is a blank canvas
public class BoxDrawingView extends View {
   public static final String    TAG = "BoxDrawingView";

   // this method is used when creating the view in code
   public BoxDrawingView(Context context) {
      this(context, null);
   }

   // this method is used when inflating the view from XML
   public BoxDrawingView(Context context, AttributeSet attributeSet) {
      super(context, attributeSet);
   }

   @Override
   public boolean onTouchEvent(MotionEvent event) {
      PointF current = new PointF(event.getX(), event.getY());
      String action = "";
      switch (event.getAction()) {
         case MotionEvent.ACTION_DOWN:
            action = "ACTION_DOWN";
            break;
         case MotionEvent.ACTION_MOVE:
            action = "ACTION_MOVE";
            break;
         case MotionEvent.ACTION_UP:
            action = "ACTION_UP";
            break;
         case MotionEvent.ACTION_CANCEL:
            action = "ACTION_CANCEL";
            break;
      }
      Log.i(TAG, action + " at x=" + current.x + ", y=" + current.y);
      return true;
   }
}
