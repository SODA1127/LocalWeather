package com.soda1127.example.localweather.screen.weather

sealed class LocalWeatherAction {

    object Uninitialized: LocalWeatherAction()

    data class Toast(val toastMessage: String): LocalWeatherAction()

}
