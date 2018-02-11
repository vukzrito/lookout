package com.vukzrito.bolo.data;

import android.support.annotation.NonNull;

import com.vukzrito.bolo.model.Incident;

import java.util.ArrayList;
import java.util.List;


public class IncidentsRepositoryImpl implements IncidentsRepository {
    private ArrayList<Incident> incidents;
    private WebApi api;

    public IncidentsRepositoryImpl() {
        api = new WebApiImpl();
    }

    @Override
    public void loadIncidents(@NonNull final LoadIncidentsCallback callback) {
        api.getIncidents(new WebApi.IncidentsServiceCallback<List<Incident>>() {
            @Override
            public void onLoaded(List<Incident> vehicles) {

                callback.onLoaded(vehicles);
            }

            @Override
            public void onError(String errorMessage) {

                callback.onError(errorMessage);
            }
        });
        callback.onLoaded(incidents);
    }

    @Override
    public void loadVehicle(String vehicleId, @NonNull LoadIncidentCallback callback) {
        callback.onLoaded(incidents.get(0));
    }

    @Override
    public void addIncident(Incident incident, final AddIncidentCallback callback) {
        api.addIncident(incident, new WebApi.AddIncidentServiceCallback() {
            @Override
            public void onAdded(Incident incident) {
                callback.onAdded(incident);
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }
}
