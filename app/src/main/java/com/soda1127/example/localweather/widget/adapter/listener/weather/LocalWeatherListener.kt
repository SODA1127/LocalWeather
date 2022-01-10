package com.soda1127.example.localweather.widget.adapter.listener.weather

import com.soda1127.example.localweather.data.entity.LocalWeatherEntity
import com.soda1127.example.localweather.model.localweather.LocalWeatherModel
import com.soda1127.example.localweather.widget.adapter.listener.AdapterListener

interface LocalWeatherListener: AdapterListener {

    fun onClickItem(localWeatherEntity: LocalWeatherEntity)

}
