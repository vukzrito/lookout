package com.vukzrito.bolo.data;

import android.support.annotation.NonNull;

import com.vukzrito.bolo.model.Incident;

import java.util.List;


public interface IncidentsRepository {

    void loadIncidents(@NonNull LoadIncidentsCallback callback);

    void loadVehicle(String incidentId, @NonNull LoadIncidentCallback callback);

    void addIncident(Incident incident, AddIncidentCallback callback);


    interface LoadIncidentsCallback {
        void onLoaded(List<Incident> incidents);

        void onError(String errorMessage);
    }

    interface LoadIncidentCallback {
        void onLoaded(Incident incident);

        void onError(String errorMessage);
    }

    interface AddIncidentCallback {
        void onAdded(Incident incident);

        void onError(String errorMessage);
    }

}
