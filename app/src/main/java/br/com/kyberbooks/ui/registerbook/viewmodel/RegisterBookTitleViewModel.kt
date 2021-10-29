package br.com.kyberbooks.ui.registerbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel

class RegisterBookTitleViewModel : BaseViewModel() {

    private val _isTitleValidLiveData = MutableLiveData<Boolean>()
    val isTitleValidLiveData: LiveData<Boolean>
        get() = _isTitleValidLiveData


    fun onNextButtonClick(title: String, subtitle: String = "") {

        if (title.isEmpty()) {
            _isTitleValidLiveData.postValue(false)
        } else {
            _isTitleValidLiveData.postValue(true)
        }


    }

}