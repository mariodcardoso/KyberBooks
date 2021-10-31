package br.com.kyberbooks.ui.registerbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel

class RegisterBookPublisherViewModel : BaseViewModel() {

    private val _isPublisherValid = MutableLiveData<Boolean>()
    val isPublisherLiveData: LiveData<Boolean>
        get() = _isPublisherValid

    private val _isPublishDateValidLiveData = MutableLiveData<Boolean>()
    val isPublishDateValidLiveData: LiveData<Boolean>
        get() = _isPublishDateValidLiveData

    private val _isEditionValidLiveData = MutableLiveData<Boolean>()
    val isEditionValidLiveData: LiveData<Boolean>
        get() = _isEditionValidLiveData

    private val _isLanguageValidLiveData = MutableLiveData<Boolean>()
    val isLanguageValidLiveData: LiveData<Boolean>
        get() = _isLanguageValidLiveData

    private val _isInformationsValid = MutableLiveData<Boolean>()
    val isInformationsValid: LiveData<Boolean>
        get() = _isInformationsValid

    fun onNextButtonClicked(
        publisher: String,
        publishDate: String,
        edition: String,
        language: String
    ) {

        if (validatePublisherName(publisher) &&
            validatePublishYearName(publishDate) &&
            validateEdition(edition) &&
            validateLanguage(language)
        ) {
            _isInformationsValid.postValue(true)
        }
    }

    private fun validatePublisherName(publisher: String): Boolean {
        return if (publisher.isEmpty()) {
            _isPublisherValid.postValue(false)
            false
        } else {
            true
        }
    }

    private fun validatePublishYearName(publishDate: String): Boolean {
        return if (publishDate.isEmpty() || publishDate >= "2022") {
            _isPublishDateValidLiveData.postValue(false)
            false
        } else {
            true
        }
    }

    private fun validateEdition(edition: String): Boolean {
        return if (edition.toInt() <= 0 || edition.isEmpty()) {
            _isEditionValidLiveData.postValue(false)
            return false
        } else {
            true
        }
    }

    private fun validateLanguage(language: String): Boolean {
        return if (language.isEmpty()) {
            _isLanguageValidLiveData.postValue(false)
            false
        } else {
            true
        }
    }
}