package com.serpanalo.legalaplication;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;


public class ShowUtils {

    public static ProgressBar showLoadingDialog(Context context) {

        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setVisibility(View.VISIBLE);

        return progressBar;
    }

}
