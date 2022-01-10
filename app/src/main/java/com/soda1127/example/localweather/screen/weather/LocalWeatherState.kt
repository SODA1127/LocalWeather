package com.soda1127.example.localweather.screen.weather

import com.soda1127.example.localweather.model.Model

sealed class LocalWeatherState {

    object Uninitialized: LocalWeatherState()

    object Loading: LocalWeatherState()

    data class Success(
        val modelList: List<Model>
    ): LocalWeatherState()


    sealed class Error: LocalWeatherState() {

        data class Default(
            val e: Throwable
        ): Error()

        object NotFound: Error()

    }

}
