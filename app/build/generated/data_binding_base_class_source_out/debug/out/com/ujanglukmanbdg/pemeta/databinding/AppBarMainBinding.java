// Generated by view binder compiler. Do not edit!
package com.ujanglukmanbdg.pemeta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.ujanglukmanbdg.pemeta.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class AppBarMainBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  private AppBarMainBinding(@NonNull CoordinatorLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AppBarMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.app_bar_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AppBarMainBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new AppBarMainBinding((CoordinatorLayout) rootView);
  }
}
