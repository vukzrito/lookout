package com.vukzrito.bolo.home;


import com.vukzrito.bolo.model.Vehicle;

import java.util.List;

 interface VehiclesContract {
    interface View{
        void showVehicles(List<Vehicle> vehicleList);
        void showProgressIndicator(boolean active);
        void showErrorMessage(String errorMessage);
        void showVehicleDetail(String vehicleId);
    }

    interface UserActionsListener {
        void loadVehicles(boolean forceUpdate);
        void openVehicleDetail(Vehicle vehicle);
    }
}
