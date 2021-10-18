package br.com.kyberbooks.domain.model

import android.os.Parcelable
import com.google.firebase.firestore.PropertyName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookReadProgress(
    @get:PropertyName("isbn")
    val isbn: String = "",
    @get:PropertyName("book_name")
    val bookName: String = "",
    @get:PropertyName("total_pages")
    val totalPages: Int = 0,
    @get:PropertyName("cover_book")
    val coverBook: String? = "",
    @get:PropertyName("read_progress")
    val read_progress: List<ProgressRegister> = emptyList()
) : Parcelable

@Parcelize
data class ProgressRegister(
    val pages_read: Int = 0,
    val date_read: String = ""
) : Parcelable