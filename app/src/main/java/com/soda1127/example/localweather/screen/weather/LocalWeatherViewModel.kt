package com.soda1127.example.localweather.screen.weather

import com.soda1127.example.localweather.data.entity.LocationWithWeathersEntity
import com.soda1127.example.localweather.data.repository.LocalWeatherSearchRepository
import com.soda1127.example.localweather.model.Model
import com.soda1127.example.localweather.model.localweather.LocalWeatherHeaderModel
import com.soda1127.example.localweather.model.localweather.LocalWeatherModel
import com.soda1127.example.localweather.screen.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LocalWeatherViewModel(
    private val keyword: String,
    private val localWeatherSearchRepository: LocalWeatherSearchRepository
) : BaseViewModel() {

    private val _localWeatherStateFlow = MutableStateFlow<LocalWeatherState>(LocalWeatherState.Uninitialized)
    val localWeatherStateFlow: StateFlow<LocalWeatherState> = _localWeatherStateFlow

    private val _localWeatherActionFlow = MutableStateFlow<LocalWeatherAction>(LocalWeatherAction.Uninitialized)
    val localWeatherActionFlow: StateFlow<LocalWeatherAction> = _localWeatherActionFlow

    override fun fetchData(): Job = viewModelErrorHandlerScope.launch {
        localWeatherSearchRepository.findLocations(keyword)
            .onStart {
                setState(
                    LocalWeatherState.Loading
                )
            }
            .onEach { locationInfos ->
                combine(
                    locationInfos?.map { locationInfo ->
                        localWeatherSearchRepository.findLocalWeathersByWoeid(locationInfo.woeid.toString())
                            .map {
                                locationInfo to it
                            }
                    } ?: listOf(flow { emit(null) })
                ) { locationWithLocalWeathersPairs ->
                    locationWithLocalWeathersPairs.filterNotNull().map {
                        val (locationInfo, localWeathers) = it
                        LocationWithWeathersEntity(locationInfo, localWeathers ?: listOf())
                    }
                }.collect { locationsWithLocalWeathers ->
                    val modelList = mutableListOf<Model>().apply {
                        add(LocalWeatherHeaderModel())
                        locationsWithLocalWeathers.forEach {
                            add(LocalWeatherModel.toModel(it))
                        }
                    }
                    setState(
                        LocalWeatherState.Success(modelList)
                    )
                }
            }
            .collect()
    }

    override fun handleError(coroutineContext: CoroutineContext, throwable: Throwable) {
        setState(
            LocalWeatherState.Error.Default(throwable)
        )
    }

    fun showToast(message: String) = viewModelErrorHandlerScope.launch {
        setAction(
            LocalWeatherAction.Toast(message)
        )
    }

    private fun setAction(action: LocalWeatherAction) {
        _localWeatherActionFlow.value = action
    }

    private fun setState(state: LocalWeatherState) {
        _localWeatherStateFlow.value = state
    }
}
