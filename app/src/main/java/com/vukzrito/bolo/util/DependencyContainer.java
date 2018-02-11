package com.vukzrito.bolo.util;

import com.vukzrito.bolo.data.FakeIncidentsRepositoryImpl;
import com.vukzrito.bolo.data.IncidentsRepository;

public class DependencyContainer {
    public static IncidentsRepository provideIncidentsRepository() {
        return new FakeIncidentsRepositoryImpl();
    }
}
