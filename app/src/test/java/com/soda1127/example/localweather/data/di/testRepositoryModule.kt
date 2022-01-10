package com.soda1127.example.localweather.data.di

import com.soda1127.example.localweather.data.repository.LocalWeatherSearchRepository
import com.soda1127.example.localweather.data.repository.TestLocalWeatherSearchRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val testRepositoryModule = module {

    single<LocalWeatherSearchRepository> { TestLocalWeatherSearchRepository(Dispatchers.Main) }

}
