package com.vukzrito.bolo.detail;

import com.vukzrito.bolo.data.VehiclesRepository;
import com.vukzrito.bolo.detail.DetailContract.Interactor;
import com.vukzrito.bolo.model.Vehicle;
import com.vukzrito.bolo.util.DependencyContainer;


public class DetailPresenter implements Interactor {
    private VehiclesRepository repository;
    private DetailContract.View view;

    public DetailPresenter(DetailContract.View view) {
        this.view = view;
        repository = DependencyContainer.provideVehiclesRepository();
    }

    @Override
    public void loadVehicleDetails(String vehicleId) {
        view.showLoadingIndicator(true);
        repository.loadVehicle(vehicleId, new VehiclesRepository.LoadVehicleCallback() {
            @Override
            public void onLoaded(Vehicle vehicle) {
                view.showLoadingIndicator(false);
                view.showVehicleDetail(vehicle);
            }

            @Override
            public void onError(String errorMessage) {
                view.showLoadingIndicator(false);
            }
        });
    }
}
