package com.vukzrito.bolo.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vukzrito.bolo.R;
import com.vukzrito.bolo.model.Vehicle;
import com.vukzrito.bolo.util.IntentFactory;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    private DetailContract.Interactor interactor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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
