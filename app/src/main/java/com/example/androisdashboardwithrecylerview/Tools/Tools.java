package com.example.androisdashboardwithrecylerview.Tools;

import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.codemybrainsout.ratingdialog.BuildConfig;
import com.codemybrainsout.ratingdialog.RatingDialog;

public class Tools {
    public static void PrivacyPolicy(Context context) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
       context.startActivity(browserIntent);
    }

    public static void MoreApp(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName()));
        try {
            context.startActivity(new Intent(intent)
                    .setPackage("com.android.vending"));
        } catch (android.content.ActivityNotFoundException exception) {
           context.startActivity(intent);
        }
    }

    public static void ShareApp(Context context) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage = "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
          context.  startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            //e.toString();
        }
    }

    public static void Rateus(Context context) {
        final RatingDialog ratingDialog = new RatingDialog.Builder(context)
                .threshold(3)
                .session(7)
                .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                    @Override
                    public void onFormSubmitted(String feedback) {

                    }
                }).build();

        ratingDialog.show();

    }
    public static void setImageViewDrawableColor(ImageView imageView, int quizcolor) {
        imageView.getBackground().setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(imageView.getContext(), quizcolor),
                PorterDuff.Mode.SRC_IN));


    }
}
