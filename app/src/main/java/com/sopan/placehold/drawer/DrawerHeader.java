package com.sopan.placehold.drawer;

import android.widget.ImageView;
import android.widget.TextView;

import com.sopan.placeholderview.annotations.Layout;
import com.sopan.placeholderview.annotations.NonReusable;
import com.sopan.placeholderview.annotations.Resolve;
import com.sopan.placeholderview.annotations.View;
import com.sopan.placehold.R;

/**
 * Created by Sopan on 19/08/16.
 */
@NonReusable
@Layout(R.layout.drawer_header)
public class DrawerHeader {

    @View(R.id.profileImageView)
    private ImageView profileImage;

    @View(R.id.nameTxt)
    private TextView nameTxt;

    @View(R.id.emailTxt)
    private TextView emailTxt;

    @Resolve
    private void onResolved() {
        nameTxt.setText("Janishar Ali");
        emailTxt.setText("janishar.ali@gmail.com");
    }

}
