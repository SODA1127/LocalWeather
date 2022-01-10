package com.soda1127.example.localweather.data.viewmodel

import com.soda1127.example.localweather.data.entity.LocationWithWeathersEntity
import com.soda1127.example.localweather.data.json.LocationInfosResponseJsonKeyword
import com.soda1127.example.localweather.data.repository.LocalWeatherSearchRepository
import com.soda1127.example.localweather.model.Model
import com.soda1127.example.localweather.model.localweather.LocalWeatherHeaderModel
import com.soda1127.example.localweather.model.localweather.LocalWeatherModel
import com.soda1127.example.localweather.screen.weather.LocalWeatherAction
import com.soda1127.example.localweather.screen.weather.LocalWeatherActivity
import com.soda1127.example.localweather.screen.weather.LocalWeatherState
import com.soda1127.example.localweather.screen.weather.LocalWeatherViewModel
import dev.olog.flow.test.observer.test
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.core.parameter.parametersOf
import org.koin.test.inject

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
internal class LocalWeatherViewModelTest : ViewModelTest() {

    private lateinit var locationWithWeathersEntities: List<LocationWithWeathersEntity>

    private val localWeatherSearchRepository by inject<LocalWeatherSearchRepository>()

    private val vm by inject<LocalWeatherViewModel> {
        parametersOf(LocalWeatherActivity.KEYWORD_LOCATION_SE)
    }

    @Before
    fun `Initialize expected data`() = runBlockingTest {
        localWeatherSearchRepository.findLocations(LocationInfosResponseJsonKeyword)
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
                    locationWithWeathersEntities = locationsWithLocalWeathers
                }
            }
            .collect()
    }

    @Test
    fun `Test fetch data`() = runBlockingTest {
        vm.localWeatherStateFlow.test(this) {
            assertValues(
                LocalWeatherState.Uninitialized,
                LocalWeatherState.Loading,
                LocalWeatherState.Success(
                    mutableListOf<Model>().apply {
                        add(LocalWeatherHeaderModel())
                        locationWithWeathersEntities.forEach {
                            add(LocalWeatherModel.toModel(it))
                        }
                    }
                )
            )
        }
        vm.fetchData()
    }

    @Test
    fun `Test show Toast`() = runBlockingTest {
        val testMessage = "testMessage"
        vm.localWeatherActionFlow.test(this) {
            assertValues(
                LocalWeatherAction.Uninitialized,
                LocalWeatherAction.Toast(testMessage),
            )
        }
        vm.showToast(testMessage)
    }

}
