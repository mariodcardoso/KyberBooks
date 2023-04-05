package br.com.kyberbooks.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel

class MyBooksViewModel :  BaseViewModel() {

    private val _urlBookCover = MutableLiveData<String>()
    var urlBookCover: LiveData<String> = _urlBookCover

    fun setupFields() {
        _urlBookCover.postValue("https://edit.org/images/cat/book-covers-big-2019101610.jpg")
    }
}