package com.soda1127.example.localweather.data.repository

import com.soda1127.example.localweather.data.entity.LocalWeatherEntity
import com.soda1127.example.localweather.data.entity.LocationInfoEntity
import kotlinx.coroutines.flow.Flow

interface LocalWeatherSearchRepository {

    suspend fun findLocations(keyword: String): Flow<List<LocationInfoEntity>?>

    suspend fun findLocalWeathersByWoeid(woeid: String): Flow<List<LocalWeatherEntity>?>

}
