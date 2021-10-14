package br.com.kyberbooks.ui.bookdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.kyberbooks.databinding.ActivityBookDetailsBinding

class BookDetailsActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun getStartIntent(context: Context) = Intent(context, BookDetailsActivity::class.java)
    }

    private val binding by lazy { ActivityBookDetailsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


}