package com.soda1127.example.localweather.data.response

import com.soda1127.example.localweather.data.entity.LocalWeatherEntity

data class LocalWeathersResponse(
    val consolidatedWeather: List<LocalWeatherEntity>
)
