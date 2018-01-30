
package com.vukzrito.bolo.util;

import android.content.Context;
import android.content.Intent;

import com.vukzrito.bolo.add.AddVehicleActivity;
import com.vukzrito.bolo.detail.DetailActivity;

public class IntentFactory {
    public static String VEHICLE_ID_KEY = "VEHICLE_ID_KEY";

    public static Intent createDetailIntent(String vehicleId, Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(VEHICLE_ID_KEY, vehicleId);
        return intent;
    }

    public static Intent createAddVehicle(Context context) {
        return new Intent(context, AddVehicleActivity.class);
    }
}
