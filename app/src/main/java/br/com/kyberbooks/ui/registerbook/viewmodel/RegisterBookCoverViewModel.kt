package br.com.kyberbooks.ui.registerbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel

class RegisterBookCoverViewModel : BaseViewModel() {

    private val _isImageValidLiveData = MutableLiveData<Boolean>()
    val isImageValidLiveData: LiveData<Boolean>
        get() = _isImageValidLiveData


    fun onNextButtonClicked(imageUri: String) {
        if (imageUri.isEmpty()){
            _isImageValidLiveData.postValue(false)
        } else {
            _isImageValidLiveData.postValue(true)
        }
    }
}