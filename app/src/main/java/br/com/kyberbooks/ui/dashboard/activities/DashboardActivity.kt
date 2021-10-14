package br.com.kyberbooks.ui.dashboard.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.kyberbooks.R
import br.com.kyberbooks.databinding.ActivityDashboardBinding
import br.com.kyberbooks.ui.bookdetail.BookDetailsActivity
import br.com.kyberbooks.ui.registerbook.activities.RegisterBookActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            btnRegisterBook.setOnClickListener {
                startActivity(RegisterBookActivity.getStartIntent(this@DashboardActivity))
            }
            ctnBookProgress.setOnClickListener {
                startActivity(BookDetailsActivity.getStartIntent(this@DashboardActivity))
            }
        }

        Glide.with(this)
            .load(R.drawable.book_cover_placeholder)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imgUser)
    }

}
