package br.com.kyberbooks.ui.dashboard.viewmodel

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import br.com.kyberbooks.base.BaseViewModel
import br.com.kyberbooks.domain.usecase.books.GetReadProgressUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getReadProgressUseCase: GetReadProgressUseCase
) : BaseViewModel() {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getBook() {
        viewModelScope.launch {
            Log.i("MDCN", getReadProgressUseCase.invoke().toString())
        }
    }
}