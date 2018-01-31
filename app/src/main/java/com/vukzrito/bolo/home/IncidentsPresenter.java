package com.vukzrito.bolo.home;

import com.vukzrito.bolo.data.FakeIncidentsRepositoryImpl;
import com.vukzrito.bolo.data.IncidentsRepository;
import com.vukzrito.bolo.model.Incident;

import java.util.List;

class IncidentsPresenter implements IncidentsContract.UserActionsListener {
    private IncidentsContract.View view;
    private IncidentsRepository repository;

    IncidentsPresenter(IncidentsContract.View view) {
        this.view = view;
        repository = new FakeIncidentsRepositoryImpl();
    }

    @Override
    public void loadVehicles(boolean forceUpdate) {
        view.showProgressIndicator(true);
        repository.loadIncidents(new IncidentsRepository.LoadIncidentsCallback() {
            @Override
            public void onLoaded(List<Incident> incidents) {
                view.showProgressIndicator(false);
                view.showIncidents(incidents);
            }

            @Override
            public void onError(String errorMessage) {
                view.showProgressIndicator(false);
                view.showErrorMessage(errorMessage);
            }
        });

    }

    @Override
    public void openIncidentDetail(Incident vehicle) {
        view.showVehicleDetail(vehicle.getId());
    }

    @Override
    public void addVehicle() {
        view.navigateToAddIncident();
    }
}
