# LocalWeather

### Images
| Loading | Success | Toast |
| ------- | ------- | ----- |
|      https://imgur.com/LgX33LH.jpg   |  https://imgur.com/ocmthLc.jpg       |     https://imgur.com/z8zbZqR.jpg  |

### File Structure

📦main
 ┣ 📂java
 ┃ ┣ 📂com
 ┃ ┃ ┣ 📂soda1127
 ┃ ┃ ┃ ┣ 📂example
 ┃ ┃ ┃ ┃ ┗ 📂localweather
 ┃ ┃ ┃ ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂di
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜coroutinesModule.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜networkModule.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜provideBooksApiService.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜repositoryModule.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜viewModelModule.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalWeatherEntity.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocationInfoEntity.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocationWithWeathersEntity.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂network
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocalWeatherApiService.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DefaultLocalWeatherSearchRepository.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocalWeatherSearchRepository.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalWeathersResponse.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocationInfoResponse.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂url
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocalWeatherUrl.kt
 ┃ ┃ ┃ ┃ ┃ ┣ 📂extensions
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FloatExtensions.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ImageViewExtensions.kt
 ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂localweather
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalWeatherHeaderModel.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocalWeatherModel.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CellType.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Model.kt
 ┃ ┃ ┃ ┃ ┃ ┣ 📂screen
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂base
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseActivity.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BaseViewModel.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂delegate
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜viewBinding.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂weather
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalWeatherAction.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalWeatherActivity.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalWeatherState.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocalWeatherViewModel.kt
 ┃ ┃ ┃ ┃ ┃ ┣ 📂widget
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂adapter
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂listener
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂weather
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocalWeatherListener.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AdapterListener.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ModelViewHolderMapper.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ModelRecyclerAdapter.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂customview
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocalWeatherView.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂viewholder
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂weather
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalWeatherHeaderViewHolder.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocalWeatherViewHolder.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ModelViewHolder.kt
 ┃ ┃ ┃ ┃ ┃ ┗ 📜LocalWeatherApp.kt
 
 
📦test
 ┗ 📂java
 ┃ ┗ 📂com
 ┃ ┃ ┗ 📂soda1127
 ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┗ 📂localweather
 ┃ ┃ ┃ ┃ ┃ ┗ 📂data
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂di
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜testRepositoryModule.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜testViewModelModule.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂json
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalWeathresReponseJson.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LocationInfosResponseJson.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestLocalWeatherSearchRepository.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂viewmodel
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalWeatherViewModelTest.kt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ViewModelTest.kt
