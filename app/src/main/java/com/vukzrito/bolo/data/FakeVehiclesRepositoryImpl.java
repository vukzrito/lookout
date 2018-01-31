package com.vukzrito.bolo.data;

import android.support.annotation.NonNull;

import com.vukzrito.bolo.model.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class FakeVehiclesRepositoryImpl implements VehiclesRepository {
    private List<Vehicle> vehicles;

    public FakeVehiclesRepositoryImpl() {
        vehicles = generateTestVehicles();
    }

    @Override
    public void loadVehicles(@NonNull final LoadVehiclesCallback callback) {

        new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();

        callback.onLoaded(vehicles);
    }

    @Override
    public void loadVehicle(String vehicleId, @NonNull LoadVehicleCallback callback) {
        callback.onLoaded(vehicles.get(0));
    }

    private List<Vehicle> generateTestVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle v1 = new Vehicle("gA5gGWyugs", "KF4NY6P8764FBQLV",
                "FK 35 XF GP", "Toyota", "Yaris", "White", "http://st.motortrend.ca/uploads/sites/10/2016/02/2016-Toyota-Corolla-front-three-quarter.jpg");
        Vehicle v2 = new Vehicle("j4RYv5y9hYFC", "ZK546PUGHV4",
                "DWD 350 FS", "Volkswagen", "Polo", "Silver", "https://www.contracthireandleasing.com/cms-images/Volkswagen-Polo-GTI-2015-white-front-three-quarter-10.jpg");
        Vehicle v3 = new Vehicle("m6YHcEsfH87jNSBvWh", "NTF53H7PW2BGV",
                "DX 89 TG GP", "Ford", "Ranger", "Charcoal", "http://www.botswanayouth.com/wp-content/uploads/2018/01/ford.jpg");
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);

        return vehicles;
    }
}
