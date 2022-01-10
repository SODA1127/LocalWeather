package com.soda1127.example.localweather.widget.customview

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.soda1127.example.localweather.R
import com.soda1127.example.localweather.data.entity.LocalWeatherEntity
import com.soda1127.example.localweather.data.url.LocalWeatherUrl
import com.soda1127.example.localweather.databinding.LocalWeatherViewBinding
import com.soda1127.example.localweather.extensions.clear
import com.soda1127.example.localweather.extensions.loadSvg

class LocalWeatherView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : ConstraintLayout(context, attrs) {

    private val binding = LocalWeatherViewBinding.inflate(LayoutInflater.from(context), this)

    fun clearImage() = binding.weatherIconImageView.clear()

    fun setLocalWeather(localWeatherEntity: LocalWeatherEntity) = with(binding) {
        localWeatherDataGroup.isVisible = true
        unknownDataTextView.isGone = true
        weatherIconImageView.loadSvg(LocalWeatherUrl.makeWeatherIconUrl(localWeatherEntity.weatherStateAbbr))
        weatherStateTextView.text = localWeatherEntity.weatherStateName

        val temperatureText = context.getString(R.string.temperature_text, localWeatherEntity.theTemp)
        val humidityText = context.getString(R.string.humidity_text, localWeatherEntity.humidity)

        temperatureTextView.text = getPrefixBoldText(temperatureText)
        humidityTextView.text = getPrefixBoldText(humidityText)
    }

    fun setUnknownData() = with(binding) {
        localWeatherDataGroup.isGone = true
        unknownDataTextView.isVisible = true
    }

    private fun getPrefixBoldText(text: CharSequence) =
        SpannableStringBuilder(text).apply {
            setSpan(StyleSpan(Typeface.BOLD), 0, text.length - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

}
