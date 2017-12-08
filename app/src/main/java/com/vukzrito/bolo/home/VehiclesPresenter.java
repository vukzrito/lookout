package com.vukzrito.bolo.home;

import com.vukzrito.bolo.model.Vehicle;

class VehiclesPresenter  implements VehiclesContract.UserActionsListener{
    private VehiclesContract.View view;

    VehiclesPresenter(VehiclesContract.View view) {
        this.view = view;
    }

    @Override
    public void loadVehicles(boolean forceUpdate) {
        view.showProgressIndicator(true);
    }

    @Override
    public void openVehicleDetail(Vehicle vehicle) {

    }
}
