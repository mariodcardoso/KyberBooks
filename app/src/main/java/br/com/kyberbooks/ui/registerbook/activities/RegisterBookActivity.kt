package br.com.kyberbooks.ui.registerbook.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import br.com.kyberbooks.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterBookActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, RegisterBookActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_book)

    }
}