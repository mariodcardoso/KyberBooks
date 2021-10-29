package br.com.kyberbooks.ui.registerbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel

class RegisterBookPublisherViewModel : BaseViewModel() {

    private val _isPublisherValid = MutableLiveData<Boolean>()
    val isPublisherLiveData: LiveData<Boolean>
        get() = _isPublisherValid

    private val _isPublishDateValid = MutableLiveData<Boolean>()
    val isPublishDateValid: LiveData<Boolean>
        get() = _isPublishDateValid

    private val _isEditionValid = MutableLiveData<Boolean>()
    val isEditionValid: LiveData<Boolean>
        get() = _isEditionValid

    fun onNextButtonClicked(
        publisher: String,
        publishDate: String,
        edition: String
    ) {



    }
}