package br.com.kyberbooks.ui.registerbook.viewmodel

import androidx.lifecycle.viewModelScope
import br.com.kyberbooks.base.BaseViewModel
import br.com.kyberbooks.domain.model.Book
import br.com.kyberbooks.domain.model.Isbn
import br.com.kyberbooks.domain.usecase.books.CreateBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterBookViewModel @Inject constructor(
    private val createBookUseCase: CreateBookUseCase
) : BaseViewModel() {

    private val book = Book()

    fun onIsbnInformed(isbn10: String, isbn13: String) {
        book.isbn.removeFirst()
        book.isbn.add(Isbn(isbn10, isbn13))
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

    fun onAuthorNameInformed(authorName: String) {
        book.authors = authorName
    }

    fun onPublishmentInfoInformed(
        publisher: String,
        publishDate: String,
        edition: String,
        language: String
    ) {
        book.publisher = publisher
        book.publishDate = publishDate
        book.edition = edition
        book.language = language
    }

    fun onBookInfosInformed(pages: Int, synopsis: String, genre: String) {
        book.pages = pages.toString()
        book.synopsis = synopsis
        book.genre = genre


        viewModelScope.launch { createBookUseCase.invoke(book) }

    }

}