package br.com.kyberbooks.data

import br.com.kyberbooks.domain.model.Book
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class FirebaseBookDataSource @Inject constructor(
    firebaseFirestore: FirebaseFirestore
) : BookDataSource {

    private val documentReference = firebaseFirestore.document("data/kyber/")

    override suspend fun createBook(book: Book): Book {
        return suspendCoroutine { continuation ->
            documentReference
                .collection("books")
                .document(System.currentTimeMillis().toString())
                .set(book)
                .addOnSuccessListener { continuation.resumeWith(Result.success(book)) }
                .addOnFailureListener { exception -> continuation.resumeWith(Result.failure(exception)) }
        }
    }

    override suspend fun getBook(isbn: String): Book {
        return suspendCoroutine { continuation ->
            documentReference
                .collection("books")
                .whereEqualTo("isbn", "123456789")
                .get()
                .addOnSuccessListener { querySnapshot ->
                    val book = querySnapshot.documents[0].toObject(Book::class.java)

                    book?.let { continuation.resumeWith(Result.success(book)) }

                }
                .addOnFailureListener { exception -> continuation.resumeWith(Result.failure(exception)) }

        }
    }
}