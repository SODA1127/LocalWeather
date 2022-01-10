package com.soda1127.example.localweather.data.url

object LocalWeatherUrl {
    const val BASE_URL = "https://www.metaweather.com/api/"

    fun makeWeatherIconUrl(weatherStateAbbr: String) =
        "https://www.metaweather.com/static/img/weather/${weatherStateAbbr}.svg"

    internal object EndPoint {

        const val QUERY = "query"
        const val WOEID = "woeid"

        const val LOCATION_SEARCH = "location/search"

        const val LOCAL_WEATHERS = "location/{woeid}"

    }

}
