package com.soda1127.example.localweather.data.repository

import com.soda1127.example.localweather.data.entity.LocalWeatherEntity
import com.soda1127.example.localweather.data.entity.LocationInfoEntity
import com.soda1127.example.localweather.data.network.LocalWeatherApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class DefaultLocalWeatherSearchRepository(
    private val ioDispatcher: CoroutineDispatcher,
    private val localWeatherApiService: LocalWeatherApiService,
): LocalWeatherSearchRepository {

    override suspend fun findLocations(keyword: String): Flow<List<LocationInfoEntity>?> = withContext(ioDispatcher) {
        val locationInfosResponse = localWeatherApiService.searchLocationsByKeyword(keyword)
        flow<List<LocationInfoEntity>?> {
            if (locationInfosResponse.isSuccessful) {
                emit(
                    locationInfosResponse.body()?.map { LocationInfoEntity.fromResponse(it) } ?: listOf()
                )
            } else {
                emit(null)
            }
        }
    }

    override suspend fun findLocalWeathersByWoeid(woeid: String): Flow<List<LocalWeatherEntity>?> = withContext(ioDispatcher) {
        val localWeathersResponse = localWeatherApiService.findLocalWeathersByWoeid(woeid)
        flow<List<LocalWeatherEntity>?> {
            if (localWeathersResponse.isSuccessful) {
                emit(
                    localWeathersResponse.body()?.consolidatedWeather
                )
            } else {
                emit(null)
            }
        }
    }

}
