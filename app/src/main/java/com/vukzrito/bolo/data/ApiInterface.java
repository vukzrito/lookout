package com.vukzrito.bolo.data;

import com.vukzrito.bolo.model.Incident;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("Incidents/")
    Call<List<Incident>> getAllIncidents();

    @POST("add-incident/")
    Call<Incident> createIncident(@Body Incident incident);


}
