package com.soda1127.example.localweather.screen.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel: ViewModel() {

    open fun fetchData(): Job = viewModelScope.launch {  }

    private val jobs = mutableListOf<Job>()

    override fun onCleared() {
        jobs.forEach { it.cancel() }
        super.onCleared()
    }

    private val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        handleError(coroutineContext, throwable)
    }

    abstract fun handleError(coroutineContext: CoroutineContext, throwable: Throwable)

    protected val viewModelErrorHandlerScope = viewModelScope + coroutineExceptionHandler

}
