package br.com.kyberbooks.ui.registerbook.viewmodel

import br.com.kyberbooks.base.BaseViewModel
import br.com.kyberbooks.domain.model.Book
import br.com.kyberbooks.domain.model.Isbn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterBookViewModel @Inject constructor() : BaseViewModel() {

    private val book = Book()

    fun onIsbnInformed(isbn13: String) {
        if (isbn13.length > 3) {
            val isbn10 = isbn13.substring(3)
            book.isbn.add(Isbn(isbn10, isbn13))
        }
    }

    fun onBookTitleInformed(title: String, subtitle: String = "") {
        with(book) {
            this.title = title
            this.subtitle = subtitle
        }
    }

    fun onBookCoverUploaded(bookCoverUri: String) {
        book.cover = bookCoverUri
    }

}