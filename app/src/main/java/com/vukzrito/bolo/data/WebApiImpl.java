package com.vukzrito.bolo.data;

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
            public void onFailure(Call<List<Incident>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    @Override
    public void getIncident(IncidentsServiceCallback<Incident> callback) {

    }
}
