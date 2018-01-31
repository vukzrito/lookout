package com.vukzrito.bolo.data;

import com.vukzrito.bolo.model.Incident;

import java.util.List;


public interface WebApi {

    void getIncidents(IncidentsServiceCallback<List<Incident>> callback);

    void getIncident(IncidentsServiceCallback<Incident> callback);

    interface IncidentsServiceCallback<T> {
        void onLoaded(T articles);

        void onError(String errorMessage);
    }
}
