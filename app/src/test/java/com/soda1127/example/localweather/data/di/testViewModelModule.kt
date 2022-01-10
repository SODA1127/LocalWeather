package com.soda1127.example.localweather.data.di

import com.soda1127.example.localweather.screen.weather.LocalWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val testViewModelModule = module {

    viewModel { (keyword: String) -> LocalWeatherViewModel(keyword, get()) }

}
