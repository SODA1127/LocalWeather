package com.soda1127.example.localweather.widget.viewholder.weather

import com.soda1127.example.localweather.databinding.ViewholderLocalWeatherHeaderBinding
import com.soda1127.example.localweather.model.localweather.LocalWeatherHeaderModel
import com.soda1127.example.localweather.widget.adapter.listener.weather.LocalWeatherListener
import com.soda1127.example.localweather.widget.viewholder.ModelViewHolder

class LocalWeatherHeaderViewHolder(
    private val binding: ViewholderLocalWeatherHeaderBinding,
): ModelViewHolder<LocalWeatherHeaderModel, LocalWeatherListener>(binding) {

    override fun reset() = with(binding) {
    }

    override fun bindData(model: LocalWeatherHeaderModel) {
        super.bindData(model)
        with(binding) {

        }
    }

    override fun bindViews(model: LocalWeatherHeaderModel, listener: LocalWeatherListener) = Unit

}
