package br.com.kyberbooks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.kyberbooks.databinding.ActivityDashboardBinding
import br.com.kyberbooks.ui.registerbook.activities.RegisterBookActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegisterBook.setOnClickListener {

            startActivity(RegisterBookActivity.getStartIntent(this))
        }

    }

}
