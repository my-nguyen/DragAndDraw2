package com.bignerdranch.android.draganddraw2;

import android.graphics.PointF;

/**
 * Created by My on 2/1/2016.
 */
// this class represents a box to be drawn on screen, with the origin point (where the finger was
// initially placed) and the current point (where the finger currently is)
public class Box {
   private PointF mOrigin;
   private PointF mCurrent;

   public Box(PointF origin) {
      mOrigin = origin;
      mCurrent = origin;
   }

   public PointF getOrigin() {
      return mOrigin;
   }

   public PointF getCurrent() {
      return mCurrent;
   }

   public void setCurrent(PointF current) {
      mCurrent = current;
   }
}
