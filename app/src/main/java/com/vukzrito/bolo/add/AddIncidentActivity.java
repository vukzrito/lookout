package com.vukzrito.bolo.add;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.vukzrito.bolo.R;
import com.vukzrito.bolo.model.Incident;
import com.vukzrito.bolo.model.Vehicle;

import java.util.Calendar;
import java.util.Date;

import static com.vukzrito.bolo.util.Constants.ADMOB_APP_ID;

public class AddIncidentActivity extends AppCompatActivity implements AddIncidentContract.View, DatePickerDialog.OnDateSetListener {
    private AddIncidentContract.Interactor presenter;
    private EditText location, make, model, color, registration, vin;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        MobileAds.initialize(this, ADMOB_APP_ID);
        presenter = new AddIncidentPresenter(this);

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
        location = findViewById(R.id.location);
        make = findViewById(R.id.make);
        model = findViewById(R.id.model);
        vin = findViewById(R.id.vin);
        registration = findViewById(R.id.registration_number);
        color = findViewById(R.id.color);
        progressBar = findViewById(R.id.progress_bar);
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(this, this, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vehicle vehicle = new Vehicle("", vin.getText().toString(), registration.getText().toString()
                        , make.getText().toString(), model.getText().toString(), color.getText().toString(), "");

                Incident incident = new Incident("id", new Date(), vehicle, "Johannesburg");
                presenter.addIncident(incident);
            }
        });
    }

    @Override
    public void showIncidentDetail(Incident incident) {

    }

    @Override
    public void showLoadingIndicator(boolean active) {
        if (active) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, "Error : ".concat(errorMessage), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessMessage() {

        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
