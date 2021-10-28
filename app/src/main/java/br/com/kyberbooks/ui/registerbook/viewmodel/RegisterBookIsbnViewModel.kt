package br.com.kyberbooks.ui.registerbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel
import br.com.kyberbooks.utils.isValidIsbn13
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterBookIsbnViewModel @Inject constructor() : BaseViewModel() {

    private val _isbnErrorLiveData = MutableLiveData<Boolean>()
    val isbnErrorLiveData: LiveData<Boolean>
        get() = _isbnErrorLiveData

    fun onNextButtonClick(isbn13: String) {

        if (isbn13.isValidIsbn13()) {
            _isbnErrorLiveData.postValue(true)
        } else {
            _isbnErrorLiveData.postValue(false)
        }

    }

}