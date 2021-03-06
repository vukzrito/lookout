package com.vukzrito.bolo.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.vukzrito.bolo.R;
import com.vukzrito.bolo.home.IncidentsContract.UserActionsListener;
import com.vukzrito.bolo.model.Incident;
import com.vukzrito.bolo.util.IntentFactory;

import java.util.List;

import butterknife.BindView;

import static com.vukzrito.bolo.util.Constants.ADMOB_APP_ID;

interface IncidentItemListener {
    void onIncidentClicked(Incident incident);
}

public class IncidentsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IncidentsContract.View {
    private UserActionsListener userActionsListener;
    @BindView(R.id.vehicles_list)
    private RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    private SwipeRefreshLayout swipeRefreshLayout;
    private IncidentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);
        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.vehicles_list);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                userActionsListener.loadVehicles(true);
            }
        });

        setSupportActionBar(toolbar);
        userActionsListener = new IncidentsPresenter(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userActionsListener.addVehicle();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        MobileAds.initialize(this, ADMOB_APP_ID);

        final AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                adView.setVisibility(View.VISIBLE);
            }
        });
        adView.loadAd(adRequest);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        IncidentItemListener clickListener = new IncidentItemListener() {
            @Override
            public void onIncidentClicked(Incident incident) {
                userActionsListener.openIncidentDetail(incident);
            }
        };
        adapter = new IncidentsAdapter(clickListener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userActionsListener.loadVehicles(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vehicles, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseUser user = firebaseAuth.getCurrentUser();
    }

    @Override
    public void showIncidents(List<Incident> incidents) {
        adapter.updateData(incidents);
    }

    @Override
    public void showProgressIndicator(boolean active) {
        swipeRefreshLayout.setRefreshing(active);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showVehicleDetail(String incidentId) {
        Intent intent = IntentFactory.createDetailIntent(incidentId, this);
        startActivity(intent);
    }

    @Override
    public void navigateToAddIncident() {
        Intent intent = IntentFactory.createAddVehicle(this);
        startActivity(intent);
    }
}
