package com.soda1127.example.localweather.widget.adapter.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.soda1127.example.localweather.databinding.ViewholderLocalWeatherBinding
import com.soda1127.example.localweather.databinding.ViewholderLocalWeatherHeaderBinding
import com.soda1127.example.localweather.model.CellType
import com.soda1127.example.localweather.model.Model
import com.soda1127.example.localweather.widget.adapter.listener.AdapterListener
import com.soda1127.example.localweather.widget.viewholder.ModelViewHolder
import com.soda1127.example.localweather.widget.viewholder.weather.LocalWeatherHeaderViewHolder
import com.soda1127.example.localweather.widget.viewholder.weather.LocalWeatherViewHolder

object ModelViewHolderMapper {

    @Suppress("UNCHECKED_CAST")
    fun <M: Model, L: AdapterListener> map(
        parent: ViewGroup,
        type: CellType,
    ): ModelViewHolder<M, L> {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when (type) {
            CellType.HEADER_CELL -> LocalWeatherHeaderViewHolder(
                ViewholderLocalWeatherHeaderBinding.inflate(inflater, parent, false)
            )
            CellType.LOCAL_WEATHER_CELL -> LocalWeatherViewHolder(
                ViewholderLocalWeatherBinding.inflate(inflater, parent, false)
            )
        }

        return viewHolder as ModelViewHolder<M, L>
    }

}
