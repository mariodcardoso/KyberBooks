package br.com.kyberbooks.ui.dashboard.activities

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.activity.viewModels
import br.com.kyberbooks.R
import br.com.kyberbooks.base.BaseActivity
import br.com.kyberbooks.databinding.ActivityDashboardBinding
import br.com.kyberbooks.ui.bookdetail.BookDetailsActivity
import br.com.kyberbooks.ui.dashboard.viewmodel.DashboardViewModel
import br.com.kyberbooks.ui.registerbook.activities.RegisterBookActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : BaseActivity() {

    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }

    private val viewModel by viewModels<DashboardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViews()

        with(binding) {
            btnRegisterBook.setOnClickListener { startActivity(RegisterBookActivity.getStartIntent(this@DashboardActivity)) }
            ctnBookProgress.setOnClickListener { startActivity(BookDetailsActivity.getStartIntent(this@DashboardActivity)) }
        }

        Glide.with(this)
            .load(R.drawable.img_profile_placeholder)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imgUser)
    }

    private fun setupViews() {
        setupProgressBarAnimation()
    }

    private fun setupProgressBarAnimation() {
        with(binding) {
            ValueAnimator.ofInt(0, 375).apply {
                addUpdateListener {
                    val value = it.animatedValue as Int
                    val progressValue = value * 100 / 500
                    pgbReadProgress.progress = progressValue
                    txtPercentReadPages.text = "$progressValue%"
                    txtAbsolutReadPages.text = "$value / 500"
                }

                interpolator = LinearInterpolator()
                duration = 2000
                start()
            }
        }
    }
}