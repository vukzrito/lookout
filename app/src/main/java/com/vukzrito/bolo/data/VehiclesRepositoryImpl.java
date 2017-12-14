package com.vukzrito.bolo.data;

import android.support.annotation.NonNull;

import com.vukzrito.bolo.model.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class VehiclesRepositoryImpl implements VehiclesRepository {
    private ArrayList<Vehicle> vehicles;
    private VehiclesApi api;

    public VehiclesRepositoryImpl() {
        api = new VehiclesApiImpl();
    }

    @Override
    public void loadVehicles(@NonNull final LoadVehiclesCallback callback) {
        api.getVehicles(new VehiclesApi.VehiclesServiceCallback<List<Vehicle>>() {
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
    public void loadVehicle(@NonNull LoadVehicleCallback callback) {
        callback.onLoaded(vehicles.get(0));
    }
}
