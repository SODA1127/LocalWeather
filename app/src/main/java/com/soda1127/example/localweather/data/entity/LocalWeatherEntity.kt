package com.soda1127.example.localweather.data.entity

import java.util.*

/**
{
    "id": 5855779425878016,
    "weather_state_name": "Light Cloud",
    "weather_state_abbr": "lc",
    "wind_direction_compass": "W",
    "created": "2022-01-09T07:09:38.554090Z",
    "applicable_date": "2022-01-09",
    "min_temp": -2.25,
    "max_temp": 4.04,
    "the_temp": 3.69,
    "wind_speed": 2.5425876579177604,
    "wind_direction": 281.217121644955,
    "air_pressure": 1023,
    "humidity": 69,
    "visibility": 13.06836822953949,
    "predictability": 70
}
 */
data class LocalWeatherEntity(
    val id: Long,
    val weatherStateName: String,
    val weatherStateAbbr: String,
    val theTemp: Float,
    val humidity: Int,
    val applicableDate: Date
)
