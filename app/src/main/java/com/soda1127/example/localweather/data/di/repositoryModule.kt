package com.soda1127.example.localweather.data.di

import com.soda1127.example.localweather.data.repository.DefaultLocalWeatherSearchRepository
import com.soda1127.example.localweather.data.repository.LocalWeatherSearchRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<LocalWeatherSearchRepository> { DefaultLocalWeatherSearchRepository(get(), get()) }

}
