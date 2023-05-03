package br.com.kyberbooks.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel

class MyBooksViewModel :  BaseViewModel() {

    private val _urlMyBooks = MutableLiveData<String>()
    var urlMyBooks: LiveData<String> = _urlMyBooks

    fun setupFields() {
        _urlMyBooks.postValue("https://edit.org/images/cat/book-covers-big-2019101610.jpg")
    }
}

