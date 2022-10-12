// Generated by view binder compiler. Do not edit!
package com.ujanglukmanbdg.pemeta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ujanglukmanbdg.pemeta.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailPersonilBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final HeaderDetailPersonilBinding includeDetailHeader;

  private ActivityDetailPersonilBinding(@NonNull ConstraintLayout rootView,
      @NonNull HeaderDetailPersonilBinding includeDetailHeader) {
    this.rootView = rootView;
    this.includeDetailHeader = includeDetailHeader;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailPersonilBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailPersonilBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail_personil, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailPersonilBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.include_detail_header;
      View includeDetailHeader = ViewBindings.findChildViewById(rootView, id);
      if (includeDetailHeader == null) {
        break missingId;
      }
      HeaderDetailPersonilBinding binding_includeDetailHeader = HeaderDetailPersonilBinding.bind(includeDetailHeader);

      return new ActivityDetailPersonilBinding((ConstraintLayout) rootView,
          binding_includeDetailHeader);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}