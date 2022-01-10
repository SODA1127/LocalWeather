package com.soda1127.example.localweather.data.network

import com.soda1127.example.localweather.data.response.LocalWeathersResponse
import com.soda1127.example.localweather.data.response.LocationInfoResponse
import com.soda1127.example.localweather.data.url.LocalWeatherUrl
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocalWeatherApiService {

    @GET(LocalWeatherUrl.EndPoint.LOCATION_SEARCH)
    suspend fun searchLocationsByKeyword(
        @Query(LocalWeatherUrl.EndPoint.QUERY)
        keyword: String
    ): Response<List<LocationInfoResponse>>

    @GET(LocalWeatherUrl.EndPoint.LOCAL_WEATHERS)
    suspend fun findLocalWeathersByWoeid(
        @Path(LocalWeatherUrl.EndPoint.WOEID)
        woeid: String
    ): Response<LocalWeathersResponse>

}
