package com.vukzrito.bolo.data;

import com.vukzrito.bolo.model.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("Vehicles/")
    Call<List<Vehicle>> getAllVehicles();


}
