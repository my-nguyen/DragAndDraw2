package com.bignerdranch.android.draganddraw2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by My on 2/1/2016.
 */
// this class is a custom view that derives from View which is a blank canvas
public class BoxDrawingView extends View {
   // this method is used when creating the view in code
   public BoxDrawingView(Context context) {
      this(context, null);
   }

   // this method is used when inflating the view from XML
   public BoxDrawingView(Context context, AttributeSet attributeSet) {
      super(context, attributeSet);
   }
}
