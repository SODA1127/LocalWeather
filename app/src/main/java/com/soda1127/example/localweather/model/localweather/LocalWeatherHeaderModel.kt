package com.soda1127.example.localweather.model.localweather

import com.soda1127.example.localweather.model.CellType
import com.soda1127.example.localweather.model.Model

data class LocalWeatherHeaderModel(
    override val id: String = LocalWeatherHeaderModel::class.java.simpleName,
    override val type: CellType = CellType.HEADER_CELL,
) : Model(id, type)
