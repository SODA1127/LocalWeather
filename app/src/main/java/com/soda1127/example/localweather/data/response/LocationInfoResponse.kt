package com.soda1127.example.localweather.data.response

/**
[
    {
        "title": "Seoul",
        "location_type": "City",
        "woeid": 1132599,
        "latt_long": "37.557121,126.977379"
    },
]
 */
data class LocationInfoResponse(
    val title: String,
    val locationType: String,
    val woeid: Long,
    val lattLong: String
)
