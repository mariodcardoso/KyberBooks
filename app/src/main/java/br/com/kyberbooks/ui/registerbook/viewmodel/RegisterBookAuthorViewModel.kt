package br.com.kyberbooks.ui.registerbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel
import br.com.kyberbooks.utils.isNameValid

class RegisterBookAuthorViewModel : BaseViewModel() {

    private val _isAuthorNameValidLiveData = MutableLiveData<Boolean>()
    val isAuthorNameValidLiveData: LiveData<Boolean>
        get() = _isAuthorNameValidLiveData

    fun onNextButtonClicked(authorName: String) {
        if (authorName.isNameValid()) {
            _isAuthorNameValidLiveData.postValue(true)
        } else {
            _isAuthorNameValidLiveData.postValue(false)
        }
    }

}