// Generated by view binder compiler. Do not edit!
package com.ujanglukmanbdg.pemeta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ujanglukmanbdg.pemeta.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MenuFrontPemetaBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView homeAboutUs;

  @NonNull
  public final TextView homeAboutUsText;

  @NonNull
  public final CardView homeCardViewPemeta;

  @NonNull
  public final ConstraintLayout homeIconMenu;

  @NonNull
  public final ImageView homeOurClient;

  @NonNull
  public final TextView homeOurClientText;

  @NonNull
  public final ImageView homeOurExperience;

  @NonNull
  public final TextView homeOurExperienceText;

  @NonNull
  public final ImageView homeOurExperts;

  @NonNull
  public final TextView homeOurExpertsText;

  @NonNull
  public final ImageView homeOurProject;

  @NonNull
  public final TextView homeOurProjectText;

  @NonNull
  public final ImageView homePortfolio;

  @NonNull
  public final TextView homePortfolioText;

  private MenuFrontPemetaBinding(@NonNull CardView rootView, @NonNull ImageView homeAboutUs,
      @NonNull TextView homeAboutUsText, @NonNull CardView homeCardViewPemeta,
      @NonNull ConstraintLayout homeIconMenu, @NonNull ImageView homeOurClient,
      @NonNull TextView homeOurClientText, @NonNull ImageView homeOurExperience,
      @NonNull TextView homeOurExperienceText, @NonNull ImageView homeOurExperts,
      @NonNull TextView homeOurExpertsText, @NonNull ImageView homeOurProject,
      @NonNull TextView homeOurProjectText, @NonNull ImageView homePortfolio,
      @NonNull TextView homePortfolioText) {
    this.rootView = rootView;
    this.homeAboutUs = homeAboutUs;
    this.homeAboutUsText = homeAboutUsText;
    this.homeCardViewPemeta = homeCardViewPemeta;
    this.homeIconMenu = homeIconMenu;
    this.homeOurClient = homeOurClient;
    this.homeOurClientText = homeOurClientText;
    this.homeOurExperience = homeOurExperience;
    this.homeOurExperienceText = homeOurExperienceText;
    this.homeOurExperts = homeOurExperts;
    this.homeOurExpertsText = homeOurExpertsText;
    this.homeOurProject = homeOurProject;
    this.homeOurProjectText = homeOurProjectText;
    this.homePortfolio = homePortfolio;
    this.homePortfolioText = homePortfolioText;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static MenuFrontPemetaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MenuFrontPemetaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.menu_front_pemeta, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MenuFrontPemetaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.home_about_us;
      ImageView homeAboutUs = ViewBindings.findChildViewById(rootView, id);
      if (homeAboutUs == null) {
        break missingId;
      }

      id = R.id.home_about_us_text;
      TextView homeAboutUsText = ViewBindings.findChildViewById(rootView, id);
      if (homeAboutUsText == null) {
        break missingId;
      }

      CardView homeCardViewPemeta = (CardView) rootView;

      id = R.id.home_icon_menu;
      ConstraintLayout homeIconMenu = ViewBindings.findChildViewById(rootView, id);
      if (homeIconMenu == null) {
        break missingId;
      }

      id = R.id.home_our_client;
      ImageView homeOurClient = ViewBindings.findChildViewById(rootView, id);
      if (homeOurClient == null) {
        break missingId;
      }

      id = R.id.home_our_client_text;
      TextView homeOurClientText = ViewBindings.findChildViewById(rootView, id);
      if (homeOurClientText == null) {
        break missingId;
      }

      id = R.id.home_our_experience;
      ImageView homeOurExperience = ViewBindings.findChildViewById(rootView, id);
      if (homeOurExperience == null) {
        break missingId;
      }

      id = R.id.home_our_experience_text;
      TextView homeOurExperienceText = ViewBindings.findChildViewById(rootView, id);
      if (homeOurExperienceText == null) {
        break missingId;
      }

      id = R.id.home_our_experts;
      ImageView homeOurExperts = ViewBindings.findChildViewById(rootView, id);
      if (homeOurExperts == null) {
        break missingId;
      }

      id = R.id.home_our_experts_text;
      TextView homeOurExpertsText = ViewBindings.findChildViewById(rootView, id);
      if (homeOurExpertsText == null) {
        break missingId;
      }

      id = R.id.home_our_project;
      ImageView homeOurProject = ViewBindings.findChildViewById(rootView, id);
      if (homeOurProject == null) {
        break missingId;
      }

      id = R.id.home_our_project_text;
      TextView homeOurProjectText = ViewBindings.findChildViewById(rootView, id);
      if (homeOurProjectText == null) {
        break missingId;
      }

      id = R.id.home_portfolio;
      ImageView homePortfolio = ViewBindings.findChildViewById(rootView, id);
      if (homePortfolio == null) {
        break missingId;
      }

      id = R.id.home_portfolio_text;
      TextView homePortfolioText = ViewBindings.findChildViewById(rootView, id);
      if (homePortfolioText == null) {
        break missingId;
      }

      return new MenuFrontPemetaBinding((CardView) rootView, homeAboutUs, homeAboutUsText,
          homeCardViewPemeta, homeIconMenu, homeOurClient, homeOurClientText, homeOurExperience,
          homeOurExperienceText, homeOurExperts, homeOurExpertsText, homeOurProject,
          homeOurProjectText, homePortfolio, homePortfolioText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
