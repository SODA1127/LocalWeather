package com.soda1127.example.localweather.data.entity

data class LocationWithWeathersEntity(
    val locationInfo: LocationInfoEntity,
    val localWeathers: List<LocalWeatherEntity>
)
