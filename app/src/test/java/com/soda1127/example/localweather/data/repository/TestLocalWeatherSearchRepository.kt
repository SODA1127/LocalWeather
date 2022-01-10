package com.soda1127.example.localweather.data.repository

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.soda1127.example.localweather.data.entity.LocalWeatherEntity
import com.soda1127.example.localweather.data.entity.LocationInfoEntity
import com.soda1127.example.localweather.data.json.*
import com.soda1127.example.localweather.data.response.LocalWeathersResponse
import com.soda1127.example.localweather.data.response.LocationInfoResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class TestLocalWeatherSearchRepository(
    private val ioDispatcher: CoroutineDispatcher,
) : LocalWeatherSearchRepository {

    fun provideGsonPolicy(): Gson =
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd")
            .create()

    override suspend fun findLocations(keyword: String): Flow<List<LocationInfoEntity>?> = withContext(ioDispatcher) {
        val locationInfosResponseListType = object : TypeToken<List<LocationInfoResponse>>() {}.type
        val locationInfosResponseList = provideGsonPolicy().fromJson<List<LocationInfoResponse>>(LocationInfosResponseJson, locationInfosResponseListType)
        flow<List<LocationInfoEntity>?> {
            val data = if (keyword == LocationInfosResponseJsonKeyword) {
                locationInfosResponseList?.map { LocationInfoEntity.fromResponse(it) } ?: listOf()
            } else {
                null
            }
            emit(data)
        }
    }

    override suspend fun findLocalWeathersByWoeid(woeid: String): Flow<List<LocalWeatherEntity>?> = withContext(ioDispatcher) {
        val jsonString = when (woeid) {
            LocalWeathersResponseJson_Seoul_Woeid.toString() -> LocalWeathersResponseJson_Seoul
            LocalWeathersResponseJson_San_jose_Woeid.toString() -> LocalWeathersResponseJson_San_Jose
            else -> null
        }
        val localWeathersResponse = provideGsonPolicy().fromJson(jsonString, LocalWeathersResponse::class.java)
        flow<List<LocalWeatherEntity>?> {
            emit(localWeathersResponse?.consolidatedWeather)
        }
    }

}
