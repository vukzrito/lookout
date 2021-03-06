package com.vukzrito.bolo.add;

import com.vukzrito.bolo.data.IncidentsRepository;
import com.vukzrito.bolo.model.Incident;
import com.vukzrito.bolo.util.DependencyContainer;

 class AddIncidentPresenter implements AddIncidentContract.Interactor {
    private IncidentsRepository repository;
    private AddIncidentContract.View view;

    AddIncidentPresenter(AddIncidentContract.View view) {
        this.view = view;
        repository = DependencyContainer.provideIncidentsRepository();
    }

    @Override
    public void addIncident(Incident incident) {
        view.showLoadingIndicator(true);
        repository.addIncident(incident, new IncidentsRepository.AddIncidentCallback() {
            @Override
            public void onAdded(Incident incident) {
                view.showLoadingIndicator(false);
                view.showSuccessMessage();
            }

            @Override
            public void onError(String errorMessage) {
                view.showErrorMessage(errorMessage);
                view.showLoadingIndicator(false);
            }
        });
    }
}
