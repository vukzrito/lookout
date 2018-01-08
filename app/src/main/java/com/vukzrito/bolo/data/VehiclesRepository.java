package com.vukzrito.bolo.data;

import android.support.annotation.NonNull;

import com.vukzrito.bolo.model.Vehicle;

import java.util.List;


public interface VehiclesRepository {

    void loadVehicles(@NonNull LoadVehiclesCallback callback);

    void loadVehicle(String vehicleId, @NonNull LoadVehicleCallback callback);


    interface LoadVehiclesCallback {
        void onLoaded(List<Vehicle> articles);

        void onError(String errorMessage);
    }

    interface LoadVehicleCallback {
        void onLoaded(Vehicle article);

        void onError(String errorMessage);
    }

}
