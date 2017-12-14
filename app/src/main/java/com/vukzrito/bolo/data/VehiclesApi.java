package com.vukzrito.bolo.data;

import com.vukzrito.bolo.model.Vehicle;

import java.util.List;

/**
 * Created by RVukela on 2017/04/18.
 */

public interface VehiclesApi {

    void getVehicles(VehiclesServiceCallback<List<Vehicle>> callback);

    void getVehicle(VehiclesServiceCallback<Vehicle> callback);

    interface VehiclesServiceCallback<T> {
        void onLoaded(T articles);

        void onError(String errorMessage);
    }
}
