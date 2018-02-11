package com.vukzrito.bolo.detail;

import com.vukzrito.bolo.data.IncidentsRepository;
import com.vukzrito.bolo.detail.DetailContract.Interactor;
import com.vukzrito.bolo.model.Incident;
import com.vukzrito.bolo.util.DependencyContainer;


class DetailPresenter implements Interactor {
    private IncidentsRepository repository;
    private DetailContract.View view;

     DetailPresenter(DetailContract.View view) {
        this.view = view;
        repository = DependencyContainer.provideIncidentsRepository();
    }

    @Override
    public void loadVehicleDetails(String vehicleId) {
        view.showLoadingIndicator(true);
        repository.loadVehicle(vehicleId, new IncidentsRepository.LoadIncidentCallback() {
            @Override
            public void onLoaded(Incident incident) {
                view.showLoadingIndicator(false);
                view.showIncidentDetail(incident);
            }

            @Override
            public void onError(String errorMessage) {
                view.showLoadingIndicator(false);
            }
        });
    }
}
