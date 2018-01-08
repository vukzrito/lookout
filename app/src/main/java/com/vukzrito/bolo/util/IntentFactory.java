/*
 * Copyright (c) 2018 Barclays Bank Plc, All Rights Reserved.
 *
 * This code is confidential to Barclays Bank Plc and shall not be disclosed
 * outside the Bank without the prior written permission of the Director of
 * CIO
 *
 * In the event that such disclosure is permitted the code shall not be copied
 * or distributed other than on a need-to-know basis and any recipients may be
 * required to sign a confidentiality undertaking in favor of Barclays Bank
 * Plc.
 */
package com.vukzrito.bolo.util;


import android.content.Context;
import android.content.Intent;

import com.vukzrito.bolo.detail.DetailActivity;

public class IntentFactory {
    public static String VEHICLE_ID_KEY = "VEHICLE_ID_KEY";

    public static Intent createDetailIntent(String vehicleId, Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(VEHICLE_ID_KEY, vehicleId);
        return intent;
    }
}
