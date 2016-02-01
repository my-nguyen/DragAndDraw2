package com.bignerdranch.android.draganddraw2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DragAndDrawActivity extends SingleFragmentActivity {
   @Override
   protected Fragment createFragment() {
      return DragAndDrawFragment.newInstance();
   }
}