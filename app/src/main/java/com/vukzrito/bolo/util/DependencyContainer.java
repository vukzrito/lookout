package com.vukzrito.bolo.util;

import com.vukzrito.bolo.data.IncidentsRepository;
import com.vukzrito.bolo.data.IncidentsRepositoryImpl;

public class DependencyContainer {
    public static IncidentsRepository provideIncidentsRepository() {
        return new IncidentsRepositoryImpl();
    }
}
