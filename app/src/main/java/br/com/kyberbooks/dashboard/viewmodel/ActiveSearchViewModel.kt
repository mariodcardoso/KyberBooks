package br.com.kyberbooks.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActiveSearchViewModel : ViewModel() {

    private val _urlMyBooksCoverData = MutableLiveData<String>()
        var urlMyBooksCoverData: LiveData<String> = _urlMyBooksCoverData

    fun setupFields(){
        _urlMyBooksCoverData.postValue("https://edit.org/images/cat/book-covers-big-2019101610.jpg")
    }
}