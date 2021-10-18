package br.com.kyberbooks.data

import androidx.core.net.toUri
import br.com.kyberbooks.domain.model.Book
import br.com.kyberbooks.domain.model.BookReadProgress
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class FirebaseBookDataSource @Inject constructor(
    firebaseFirestore: FirebaseFirestore,
    firebaseStorage: FirebaseStorage
) : BookDataSource {

    private val documentReference = firebaseFirestore.document("data/kyber/")
    private val storage = firebaseStorage.reference

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

    override suspend fun uploadBookCover(uri: String): String {
        return suspendCoroutine { continuation ->
            val randomKey = UUID.randomUUID()
            val childReference = storage.child("images/kyber/$randomKey")

            childReference.putFile(uri.toUri())
                .addOnSuccessListener { taskSnapshot ->
                    taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
                        continuation.resumeWith(Result.success(uri.toString()))
                    }
                }
                .addOnFailureListener { exception -> continuation.resumeWith(Result.failure(exception)) }
        }
    }

    override suspend fun getBookReadProgress(): BookReadProgress {
        return suspendCoroutine { continuation ->
            documentReference
                .collection("read_progress")
                .get()
                .addOnSuccessListener { snapshot ->
                    val readBookProgress = snapshot.documents[0].toObject(BookReadProgress::class.java)
                    readBookProgress?.let { continuation.resumeWith(Result.success(readBookProgress)) }
                }
                .addOnFailureListener { exception -> continuation.resumeWith(Result.failure(exception)) }
        }
    }
}