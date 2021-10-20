package br.com.kyberbooks.domain.model

import android.os.Parcelable
import com.google.firebase.firestore.PropertyName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookReadProgress(
    @get:PropertyName("isbn")
    @set:PropertyName("isbn")
    var isbn: String = "",
    @get:PropertyName("book_name")
    @set:PropertyName("book_name")
    var bookName: String = "",
    @get:PropertyName("total_pages")
    @set:PropertyName("total_pages")
    var totalPages: Int = 0,
    @get:PropertyName("cover_book")
    @set:PropertyName("cover_book")
    var bookCover: String = "",
    @get:PropertyName("read_progress")
    @set:PropertyName("read_progress")
    var readProgress: List<ProgressRegister> = emptyList()
) : Parcelable

@Parcelize
data class ProgressRegister(
    @get:PropertyName("pages_read")
    @set:PropertyName("pages_read")
    var pages_read: Int = 0,
    @get:PropertyName("date_read")
    @set:PropertyName("date_read")
    var date_read: String = ""
) : Parcelable