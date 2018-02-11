package com.vukzrito.bolo.data;

import android.support.annotation.NonNull;

import com.vukzrito.bolo.model.Incident;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WebApiImpl implements WebApi {
    @Override
    public void getIncidents(final IncidentsServiceCallback<List<Incident>> callback) {
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Incident>> call = api.getAllIncidents();
        call.enqueue(new Callback<List<Incident>>() {
            @Override
            public void onResponse(Call<List<Incident>> call, Response<List<Incident>> response) {
                callback.onLoaded(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Incident>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    @Override
    public void getIncident(IncidentsServiceCallback<Incident> callback) {

    }

    @Override
    public void addIncident(Incident incident, final AddIncidentServiceCallback callback) {
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        api.createIncident(incident).enqueue(new Callback<Incident>() {
            @Override
            public void onResponse(Call<Incident> call, Response<Incident> response) {
                if(response.isSuccessful()){
                    callback.onAdded(response.body());
                }
            }

            @Override
            public void onFailure(Call<Incident> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
