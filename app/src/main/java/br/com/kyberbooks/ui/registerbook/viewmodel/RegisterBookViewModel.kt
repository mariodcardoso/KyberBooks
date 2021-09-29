package br.com.kyberbooks.ui.registerbook.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.kyberbooks.domain.model.Book
import br.com.kyberbooks.domain.usecase.books.CreateBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class RegisterBookViewModel @Inject constructor(
    private val book: Book,
    private val createBookUseCase: CreateBookUseCase,
) : ViewModel() {

    fun onNextButtonClick(fieldValue: String, fragmentId: String) {
        when (fragmentId) {
            "FragmentRegisterIsbnBinding" -> book.isbn = fieldValue
            "FragmentRegisterNameBinding" -> book.name = fieldValue
            "FragmentRegisterCoverBinding" -> {
                book.cover = fieldValue
                Log.i("MDCN", book.toString())
            }
        }
    }

    fun registerBook() {
        viewModelScope.launch { createBookUseCase.invoke(book) }
    }
}