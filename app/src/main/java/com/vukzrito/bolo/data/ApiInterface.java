package com.vukzrito.bolo.data;

import com.vukzrito.bolo.model.Incident;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("Incidents/")
    Call<List<Incident>> getAllIncidents();


}
