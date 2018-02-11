package com.vukzrito.bolo.add;


import com.vukzrito.bolo.model.Incident;

 interface AddIncidentContract {
    interface View {
        void showIncidentDetail(Incident incident);

        void showLoadingIndicator(boolean active);

        void showErrorMessage(String errorMessage);

        void showSuccessMessage();
    }

    interface Interactor {
        void addIncident(Incident incident);
    }
}
