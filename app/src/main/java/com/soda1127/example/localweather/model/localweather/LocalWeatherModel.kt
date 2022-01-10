package com.soda1127.example.localweather.model.localweather

import com.soda1127.example.localweather.data.entity.LocalWeatherEntity
import com.soda1127.example.localweather.data.entity.LocationInfoEntity
import com.soda1127.example.localweather.data.entity.LocationWithWeathersEntity
import com.soda1127.example.localweather.model.CellType
import com.soda1127.example.localweather.model.Model

data class LocalWeatherModel(
    override val id: String,
    override val type: CellType = CellType.LOCAL_WEATHER_CELL,
    val locationInfo: LocationInfoEntity,
    val localWeathers: List<LocalWeatherEntity>
) : Model(id, type) {

    companion object {
        fun toModel(localWeathersEntity: LocationWithWeathersEntity) = LocalWeatherModel(
            id = localWeathersEntity.locationInfo.woeid.toString(),
            locationInfo = localWeathersEntity.locationInfo,
            localWeathers = localWeathersEntity.localWeathers
        )
    }

}
