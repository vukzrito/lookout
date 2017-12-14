package com.vukzrito.bolo.data;

import com.vukzrito.bolo.model.Vehicle;

import java.util.List;


public interface WebApi {

    void getVehicles(VehiclesServiceCallback<List<Vehicle>> callback);

    void getVehicle(VehiclesServiceCallback<Vehicle> callback);

    interface VehiclesServiceCallback<T> {
        void onLoaded(T articles);

        void onError(String errorMessage);
    }
}
