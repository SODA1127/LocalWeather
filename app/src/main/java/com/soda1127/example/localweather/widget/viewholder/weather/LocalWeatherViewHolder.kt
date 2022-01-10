package com.soda1127.example.localweather.widget.viewholder.weather

import com.soda1127.example.localweather.databinding.ViewholderLocalWeatherBinding
import com.soda1127.example.localweather.model.localweather.LocalWeatherModel
import com.soda1127.example.localweather.widget.adapter.listener.weather.LocalWeatherListener
import com.soda1127.example.localweather.widget.viewholder.ModelViewHolder

class LocalWeatherViewHolder(
    private val binding: ViewholderLocalWeatherBinding,
): ModelViewHolder<LocalWeatherModel, LocalWeatherListener>(binding) {

    override fun reset() = with(binding) {
        firstLocalWeather.clearImage()
        secondLocalWeather.clearImage()
    }

    override fun bindData(model: LocalWeatherModel) {
        super.bindData(model)
        with(binding) {
            locationTextView.text = model.locationInfo.title
            if (model.localWeathers.isNotEmpty()) {
                firstLocalWeather.setLocalWeather(model.localWeathers[0])
                secondLocalWeather.setLocalWeather(model.localWeathers[1])
            } else {
                secondLocalWeather.setUnknownData()
            }

        }
    }

    override fun bindViews(model: LocalWeatherModel, listener: LocalWeatherListener) {
        binding.firstLocalWeather.setOnClickListener {
            listener.onClickItem(model.localWeathers[0])
        }
        binding.secondLocalWeather.setOnClickListener {
            listener.onClickItem(model.localWeathers[1])
        }
    }

}
