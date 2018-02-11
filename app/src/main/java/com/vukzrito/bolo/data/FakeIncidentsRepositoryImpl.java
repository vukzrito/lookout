package com.vukzrito.bolo.data;

import android.support.annotation.NonNull;

import com.vukzrito.bolo.model.Incident;
import com.vukzrito.bolo.model.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FakeIncidentsRepositoryImpl implements IncidentsRepository {
    private List<Incident> incidents;

    public FakeIncidentsRepositoryImpl() {
        incidents = generateTestVehicles();
    }

    @Override
    public void loadIncidents(@NonNull final LoadIncidentsCallback callback) {

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

        callback.onLoaded(incidents);
    }

    @Override
    public void loadVehicle(String vehicleId, @NonNull LoadIncidentCallback callback) {
        callback.onLoaded(incidents.get(0));
    }

    @Override
    public void addIncident(Incident incident, AddIncidentCallback callback) {
        incidents.add(incident);
        callback.onAdded(incident);
    }

    private List<Incident> generateTestVehicles() {
        List<Incident> incidents = new ArrayList<>();
        Vehicle v1 = new Vehicle("gA5gGWyugs", "KF4NY6P8764FBQLV",
                "FK 35 XF GP", "Toyota", "Yaris", "White", "http://st.motortrend.ca/uploads/sites/10/2016/02/2016-Toyota-Corolla-front-three-quarter.jpg");
        Vehicle v2 = new Vehicle("j4RYv5y9hYFC", "ZK546PUGHV4",
                "DWD 350 FS", "Volkswagen", "Polo", "Silver", "https://www.contracthireandleasing.com/cms-images/Volkswagen-Polo-GTI-2015-white-front-three-quarter-10.jpg");
        Vehicle v3 = new Vehicle("m6YHcEsfH87jNSBvWh", "NTF53H7PW2BGV",
                "DX 89 TG GP", "Ford", "Ranger", "Charcoal", "http://www.botswanayouth.com/wp-content/uploads/2018/01/ford.jpg");
        incidents.add(new Incident("v7e", new Date(), v1, "Johannesburg"));
        incidents.add(new Incident("v4tgresre", new Date(), v2, "Johannesburg"));
        incidents.add(new Incident("8jfn5e", new Date(), v3, "Johannesburg"));

        return incidents;
    }
}
