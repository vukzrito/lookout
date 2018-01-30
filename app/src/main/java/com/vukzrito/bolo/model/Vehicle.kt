package com.vukzrito.bolo.model

data class Vehicle(var id: String?, var vin: String?, var registrationNumber: String?, var make: String?, var model: String?, var color: String?) {
    var variant: String? = null
    var description: String? = null
    var year: Int = 0


}
