package br.com.kyberbooks.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel

class DashboardViewModel : BaseViewModel() {

    private val _profileNameLiveData = MutableLiveData<String>()
    var profileNameLiveData: LiveData<String> = _profileNameLiveData

    private val _profileUserNameLiveData =MutableLiveData<String>()
    var profileUserNameLiveData: LiveData<String> = _profileUserNameLiveData

    private val _bookNameLiveData = MutableLiveData<String>()
    var bookNameLiveData: LiveData<String> = _bookNameLiveData

    private val _urlBookCover = MutableLiveData<String>()
    var urlBookCover: LiveData<String> = _urlBookCover

    fun setupFields(){
        _profileNameLiveData.postValue("Elizandra Krier")
        _profileUserNameLiveData.postValue("Gotica Suave")
        _bookNameLiveData.postValue("Especialista em pessoas")
        _urlBookCover.postValue("https://img2.doceru.com/image/l/cvcx5cv.png")
    }
}