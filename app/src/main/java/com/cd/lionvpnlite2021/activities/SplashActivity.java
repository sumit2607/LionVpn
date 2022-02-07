package com.cd.lionvpnlite2021.activities;


import android.content.Intent;


import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.anchorfree.partner.api.auth.AuthMethod;
import com.anchorfree.partner.api.response.User;
import com.anchorfree.sdk.UnifiedSDK;
import com.anchorfree.vpnsdk.callbacks.Callback;
import com.anchorfree.vpnsdk.exceptions.VpnException;
import com.google.android.material.snackbar.Snackbar;
import com.onesignal.OneSignal;
import com.cd.lionvpnlite2021.BuildConfig;
import com.cd.lionvpnlite2021.Preference;
import com.cd.lionvpnlite2021.R;
import com.cd.lionvpnlite2021.utils.NetworkStateUtility;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.cd.lionvpnlite2021.utils.BillConfig.IN_PURCHASE_KEY;
import static com.cd.lionvpnlite2021.utils.BillConfig.One_Month_Sub;
import static com.cd.lionvpnlite2021.utils.BillConfig.One_Year_Sub;
import static com.cd.lionvpnlite2021.utils.BillConfig.Six_Month_Sub;

public class SplashActivity extends AppCompatActivity {

    private  TextView tv1 ,tv2;

    Preference preference;
    @BindView(R.id.parent)
    ConstraintLayout parent;
    //private static int SPLASH_SCREEN = 2500;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        preference = new Preference(SplashActivity.this);
        preference.setStringpreference(IN_PURCHASE_KEY, BuildConfig.IN_APPKEY);
        preference.setStringpreference(One_Month_Sub, BuildConfig.MONTHLY);
        preference.setStringpreference(Six_Month_Sub, BuildConfig.SIX_MONTH);
        preference.setStringpreference(One_Year_Sub, BuildConfig.YEARLY);


        // image = findViewById(R.id.imageView);
        //logo = findViewById(R.id.textView);

        tv1= findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!NetworkStateUtility.isOnline(getApplicationContext())) {


                    Snackbar snackbar = Snackbar
                            .make(parent, "Check internet connection", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    loginUser();
                }


            }
        }, 2000);

    }

    private void loginUser() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 100);



    }
}


