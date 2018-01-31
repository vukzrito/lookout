package com.vukzrito.bolo.detail;

import com.vukzrito.bolo.model.Incident;

interface DetailContract {
     interface View {
         void showIncidentDetail(Incident incident);
         void showLoadingIndicator(boolean active);
         void showErrorMessage(String errorMessage);
     }

     interface Interactor {
         void loadVehicleDetails(String vehicleId);
     }
}
