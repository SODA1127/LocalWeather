package com.soda1127.example.localweather.data.di

import org.koin.dsl.module

val networkModule = module {

    single { provideGsonPolicy() }
    single { provideGsonConverterFactory(get()) }
    single { buildOkHttpClient() }

    single { provideLocalWeatherRetrofit(get(), get()) }

    single { provideLocalWeatherApiService(get()) }

}
