package br.com.kyberbooks.ui.dashboard.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.kyberbooks.base.BaseViewModel
import br.com.kyberbooks.domain.model.BookReadProgress
import br.com.kyberbooks.domain.usecase.books.GetReadProgressUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getReadProgressUseCase: GetReadProgressUseCase
) : BaseViewModel() {

    private val _readProgress = MutableLiveData<BookReadProgress>()
    val readProgress: LiveData<BookReadProgress>
        get() = _readProgress

    fun getReadProgress() {
        viewModelScope.launch {
            Log.i("MDCN", getReadProgressUseCase.invoke().toString())
            _readProgress.value = getReadProgressUseCase.invoke()
        }
    }
}