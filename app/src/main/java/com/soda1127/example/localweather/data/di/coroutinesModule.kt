package com.soda1127.example.localweather.data.di

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val coroutinesModule = module {

    single { Dispatchers.IO }
    single { Dispatchers.Main }

}
