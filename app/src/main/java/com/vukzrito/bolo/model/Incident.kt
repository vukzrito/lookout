package com.vukzrito.bolo.model

import java.util.*

data class Incident(var id: String? = null,
                    var date: Date? = null,
                    var vehicle: Vehicle? = null,
                    var location: String? = null)
