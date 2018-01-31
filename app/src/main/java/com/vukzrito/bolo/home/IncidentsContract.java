package com.vukzrito.bolo.home;


import com.vukzrito.bolo.model.Incident;

import java.util.List;

interface IncidentsContract {
    interface View {
        void showIncidents(List<Incident> incidents);

        void showProgressIndicator(boolean active);

        void showErrorMessage(String errorMessage);

        void showVehicleDetail(String vehicleId);

        void navigateToAddIncident();
    }

    interface UserActionsListener {
        void loadVehicles(boolean forceUpdate);

        void openIncidentDetail(Incident incident);

        void addVehicle();
    }
}
