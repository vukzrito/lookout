package com.vukzrito.bolo.data;

import android.support.annotation.NonNull;

import com.vukzrito.bolo.model.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class VehiclesRepositoryImpl implements VehiclesRepository {
    private ArrayList<Vehicle> vehicles;
    private WebApi api;

    public VehiclesRepositoryImpl() {
        api = new WebApiImpl();
    }

    @Override
    public void loadVehicles(@NonNull final LoadVehiclesCallback callback) {
        api.getVehicles(new WebApi.VehiclesServiceCallback<List<Vehicle>>() {
            @Override
            public void onLoaded(List<Vehicle> vehicles) {

                callback.onLoaded(vehicles);
            }

            @Override
            public void onError(String errorMessage) {

                callback.onError(errorMessage);
            }
        });
        callback.onLoaded(vehicles);
    }

    @Override
    public void loadVehicle(String vehicleId, @NonNull LoadVehicleCallback callback) {
        callback.onLoaded(vehicles.get(0));
    }
}
