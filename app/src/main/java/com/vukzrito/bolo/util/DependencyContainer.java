package com.vukzrito.bolo.util;

import com.vukzrito.bolo.data.FakeVehiclesRepositoryImpl;
import com.vukzrito.bolo.data.VehiclesRepository;

public class DependencyContainer {
    public static VehiclesRepository provideVehiclesRepository() {
        return new FakeVehiclesRepositoryImpl();
    }
}
