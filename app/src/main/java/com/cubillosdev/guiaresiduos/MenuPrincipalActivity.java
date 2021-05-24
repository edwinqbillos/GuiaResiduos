package com.cubillosdev.guiaresiduos;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipalActivity extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        MobileAds.initialize(this, initializationStatus -> { });

        FrameLayout frameLayout = findViewById(R.id.frame_menu);
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_id));
        frameLayout.addView(adView);
        loadBanner();

        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);

        ImageView cv = findViewById(R.id.caneca_verde);
        ImageView cb = findViewById(R.id.caneca_blanca);
        ImageView cn = findViewById(R.id.caneca_negra);


        btn1.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, PrimerBotonActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        btn2.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, SegundoBotonActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        btn3.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, TercerBotonActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        btn4.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, CuartoBotonActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        btn5.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, QuintoBotonActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        btn6.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, SextoBotonActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        btn7.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, SeptimoBotonActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        btn8.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, OctavoBotonActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        cv.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, CanecaVerdeActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        cb.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, CanecaBlancaActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });

        cn.setOnClickListener(v -> {
            Intent i = new Intent(MenuPrincipalActivity.this, CanecaNegraActivity.class);
            startActivity(i);
            Animatoo.animateSlideLeft(MenuPrincipalActivity.this);
        });
    }

    private void loadBanner() {
        // Create an ad request. Check your logcat output for the hashed device ID
        // to get test ads on a physical device, e.g.,
        // "Use AdRequest.Builder.addTestDevice("ABCDE0123") to get test ads on this
        // device."

        List<String> testDevices = new ArrayList<>();
        testDevices.add(AdRequest.DEVICE_ID_EMULATOR);

        RequestConfiguration adRequest =
                new RequestConfiguration.Builder()
                .setTestDeviceIds(testDevices)
                .build();
        MobileAds.setRequestConfiguration(adRequest);

        AdSize adSize = getAdSize();
        // Step 4 - Set the adaptive ad size on the ad view.
        adView.setAdSize(adSize);

        // Step 5 - Start loading the ad in the background.
        adView.loadAd(new AdRequest.Builder().build());
    }

    private AdSize getAdSize() {
        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }
}