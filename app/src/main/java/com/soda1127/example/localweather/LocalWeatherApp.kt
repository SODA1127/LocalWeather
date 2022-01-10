package com.soda1127.example.localweather

import android.app.Application
import android.content.Context
import com.soda1127.example.localweather.data.di.coroutinesModule
import com.soda1127.example.localweather.data.di.networkModule
import com.soda1127.example.localweather.data.di.repositoryModule
import com.soda1127.example.localweather.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class LocalWeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@LocalWeatherApp)
            modules(
                coroutinesModule,
                viewModelModule,
                networkModule,
                repositoryModule,
            )
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        appContext = null
    }

    companion object {

        var appContext: Context? = null
            private set

    }

}
