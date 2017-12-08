package com.vukzrito.bolo.detail;

import com.vukzrito.bolo.model.Vehicle;

interface DetailContract {
     interface View {
         void showVehicleDetail(Vehicle vehicle);
         void showLoadingIndicator(boolean active);
         void showErrorMessage(String errorMessage);
     }

     interface Interactor {
         void loadVehicleDetails(String vehicleId);
     }
}
