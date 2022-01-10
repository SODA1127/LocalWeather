package com.soda1127.example.localweather.data.entity

import com.soda1127.example.localweather.data.response.LocationInfoResponse

data class LocationInfoEntity(
    val title: String,
    val locationType: String,
    val woeid: Long,
    val lat: Double,
    val lon: Double
) {

    companion object {

        fun fromResponse(locationInfoResponse: LocationInfoResponse): LocationInfoEntity {
            val (lat, lon) = locationInfoResponse.lattLong.split(",")
            return LocationInfoEntity(
                title = locationInfoResponse.title,
                locationType = locationInfoResponse.locationType,
                woeid = locationInfoResponse.woeid,
                lat = lat.toDouble(),
                lon = lon.toDouble()
            )
        }

    }

}
