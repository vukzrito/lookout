package com.vukzrito.bolo.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.vukzrito.bolo.R;
import com.vukzrito.bolo.model.Vehicle;
import com.vukzrito.bolo.util.IntentFactory;

import static com.vukzrito.bolo.util.Constants.ADMOB_APP_ID;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    private DetailContract.Interactor interactor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        MobileAds.initialize(this, ADMOB_APP_ID);
        final AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                adView.setVisibility(View.VISIBLE);
            }
        });

        interactor = new DetailPresenter(this);
        //TODO get vehicle ID from bundle
        String vehicleId = getIntent().getStringExtra(IntentFactory.VEHICLE_ID_KEY);
        interactor.loadVehicleDetails(vehicleId);
    }

    @Override
    public void showVehicleDetail(Vehicle vehicle) {

    }

    @Override
    public void showLoadingIndicator(boolean active) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }
}
