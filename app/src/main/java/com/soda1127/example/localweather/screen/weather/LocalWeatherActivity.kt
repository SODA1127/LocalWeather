package com.soda1127.example.localweather.screen.weather

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.soda1127.example.localweather.data.entity.LocalWeatherEntity
import com.soda1127.example.localweather.databinding.ActivityLocalWeatherBinding
import com.soda1127.example.localweather.model.Model
import com.soda1127.example.localweather.screen.base.BaseActivity
import com.soda1127.example.localweather.screen.delegate.viewBinding
import com.soda1127.example.localweather.widget.adapter.ModelRecyclerAdapter
import com.soda1127.example.localweather.widget.adapter.listener.weather.LocalWeatherListener
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class LocalWeatherActivity : BaseActivity<LocalWeatherViewModel, ActivityLocalWeatherBinding>() {

    companion object {
        const val KEYWORD_LOCATION_SE = "se"
    }

    override val binding by viewBinding(ActivityLocalWeatherBinding::inflate)

    override val vm by viewModel<LocalWeatherViewModel> {
        parametersOf(KEYWORD_LOCATION_SE)
    }

    private val adapter by lazy {
        ModelRecyclerAdapter<Model, LocalWeatherListener>(object : LocalWeatherListener {

            override fun onClickItem(localWeatherEntity: LocalWeatherEntity) {
                vm.showToast(localWeatherEntity.toString())
            }

        })
    }

    override fun initViews() = with(binding) {
        recyclerView.adapter = adapter
        refreshLayout.setOnRefreshListener {
            vm.fetchData()
        }
        progressBar.isVisible = true
    }

    override fun observeData(): Job = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            launch {
                vm.localWeatherStateFlow.collect {
                    when (it) {
                        is LocalWeatherState.Loading -> handLoadingState()
                        is LocalWeatherState.Success -> handleSuccessState(it)
                        is LocalWeatherState.Error -> handleErrorState(it)
                        else -> Unit
                    }
                }
            }
            launch {
                vm.localWeatherActionFlow.collect {
                    when (it) {
                        is LocalWeatherAction.Toast -> showToast(it)
                        else -> Unit
                    }
                }
            }
        }
    }

    private fun showToast(toastAction: LocalWeatherAction.Toast) {
        Toast.makeText(this, toastAction.toastMessage, Toast.LENGTH_SHORT).show()
    }

    private fun handLoadingState() = with(binding) {
        refreshLayout.isRefreshing = progressBar.isVisible.not()
        recyclerView.isGone = true
        errorTitleTextView.isGone = true
    }

    private fun handleSuccessState(localWeatherState: LocalWeatherState.Success) = with(binding) {
        recyclerView.isVisible = true
        progressBar.isGone = true
        refreshLayout.isRefreshing = false
        errorTitleTextView.isGone = true
        adapter.submitList(localWeatherState.modelList)
    }

    private fun handleErrorState(errorState: LocalWeatherState.Error) = with(binding) {
        recyclerView.isGone = true
        progressBar.isGone = true
        refreshLayout.isRefreshing = false
        errorTitleTextView.isVisible = true
    }

}
