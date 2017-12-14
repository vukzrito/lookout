package com.vukzrito.bolo.data;

import com.vukzrito.bolo.model.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebApiImpl implements WebApi {
    @Override
    public void getVehicles(final VehiclesServiceCallback<List<Vehicle>> callback) {
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Vehicle>> call = api.getAllVehicles();
        call.enqueue(new Callback<List<Vehicle>>() {
            @Override
            public void onResponse(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
                callback.onLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<Vehicle>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    @Override
    public void getVehicle(VehiclesServiceCallback<Vehicle> callback) {

    }
}
