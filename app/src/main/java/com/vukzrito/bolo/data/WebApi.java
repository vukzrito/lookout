package com.vukzrito.bolo.data;

import com.vukzrito.bolo.model.Incident;

import java.util.List;


public interface WebApi {

    void getIncidents(IncidentsServiceCallback<List<Incident>> callback);

    void getIncident(IncidentsServiceCallback<Incident> callback);

    void addIncident(Incident incident, AddIncidentServiceCallback callback);

    interface IncidentsServiceCallback<T> {
        void onLoaded(T articles);

        void onError(String errorMessage);
    }
    interface AddIncidentServiceCallback {
        void onAdded(Incident incident);
        void onError(String errorMessage);
    }
}
