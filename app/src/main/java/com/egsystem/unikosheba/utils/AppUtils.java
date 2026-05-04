package com.egsystem.unikosheba.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.credential.LoginActivity;


public class AppUtils {

    private static Dialog progressDialog;

    /**
     * Show a reusable alert dialog
     */
    public static void showDialog(Context context, String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    public static void showDialog(Context context, String title, String message, boolean shouldRecreate) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                    if (shouldRecreate && context instanceof Activity) {
                        ((Activity) context).recreate(); // 🔄 Recreate only if requested
                    }
                })
                .show();
    }


    /**
     * Show a modern progress dialog using custom layout
     */
    public static void showProgressDialog(Activity activity) {
        if (progressDialog != null && progressDialog.isShowing()) return;

        progressDialog = new Dialog(activity);
        progressDialog.setContentView(R.layout.dialog_progress);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        progressDialog.show();
    }

    /**
     * Hide the custom progress dialog
     */
    public static void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }





    public static void goToLogin(Activity activity, boolean finishCurrent) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);

        if (finishCurrent) {
            activity.finish();
        }
    }



}
