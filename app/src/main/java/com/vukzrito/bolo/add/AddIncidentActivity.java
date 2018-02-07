package com.vukzrito.bolo.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.vukzrito.bolo.R;

import static com.vukzrito.bolo.util.Constants.ADMOB_APP_ID;

public class AddIncidentActivity extends AppCompatActivity {
    private AddIncidentContract.Interactor presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        MobileAds.initialize(this, ADMOB_APP_ID);
        presenter = new AddIncidentPresenter();

        final AdView adView = findViewById(R.id.adView);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                adView.setVisibility(View.VISIBLE);
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
