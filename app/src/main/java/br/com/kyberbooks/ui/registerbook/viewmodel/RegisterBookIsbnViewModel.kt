package br.com.kyberbooks.ui.registerbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel
import br.com.kyberbooks.domain.model.Isbn
import br.com.kyberbooks.utils.isValidIsbn13
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterBookIsbnViewModel @Inject constructor() : BaseViewModel() {

    private val _isbnLiveData = MutableLiveData<Isbn>()
    val isbnLiveData: LiveData<Isbn>
        get() = _isbnLiveData

    private val _isIsbnValidLiveData = MutableLiveData<Boolean>()
    val isbnErrorLiveData: LiveData<Boolean>
        get() = _isIsbnValidLiveData

    fun onNextButtonClick(isbn13: String) {
        if (isbn13.isValidIsbn13()) {
            _isbnLiveData.postValue(Isbn(getIsbn10(isbn13), isbn13))
        } else {
            _isIsbnValidLiveData.postValue(false)
        }
    }

    private fun getIsbn10(isbn13: String) = isbn13.substring(3)
}