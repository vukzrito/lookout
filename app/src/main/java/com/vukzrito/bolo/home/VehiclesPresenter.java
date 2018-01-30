package com.vukzrito.bolo.home;

import com.vukzrito.bolo.data.FakeVehiclesRepositoryImpl;
import com.vukzrito.bolo.data.VehiclesRepository;
import com.vukzrito.bolo.model.Vehicle;

import java.util.List;

class VehiclesPresenter implements VehiclesContract.UserActionsListener {
    private VehiclesContract.View view;
    private VehiclesRepository repository;

    VehiclesPresenter(VehiclesContract.View view) {
        this.view = view;
        repository = new FakeVehiclesRepositoryImpl();
    }

    @Override
    public void loadVehicles(boolean forceUpdate) {
        view.showProgressIndicator(true);
        repository.loadVehicles(new VehiclesRepository.LoadVehiclesCallback() {
            @Override
            public void onLoaded(List<Vehicle> vehicles) {
                view.showProgressIndicator(false);
                view.showVehicles(vehicles);
            }

            @Override
            public void onError(String errorMessage) {
                view.showProgressIndicator(false);
                view.showErrorMessage(errorMessage);
            }
        });

    }

    @Override
    public void openVehicleDetail(Vehicle vehicle) {
        view.showVehicleDetail(vehicle.getId());
    }

    @Override
    public void addVehicle() {
        view.navigateToAddVehicle();
    }
}
