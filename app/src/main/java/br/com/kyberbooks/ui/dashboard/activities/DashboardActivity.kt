package br.com.kyberbooks.ui.dashboard.activities

import android.animation.ValueAnimator
import android.os.Bundle
import android.transition.TransitionManager
import android.view.animation.LinearInterpolator
import androidx.activity.viewModels
import br.com.kyberbooks.R
import br.com.kyberbooks.base.BaseActivity
import br.com.kyberbooks.databinding.ActivityDashboardBinding
import br.com.kyberbooks.ui.bookdetail.BookDetailsActivity
import br.com.kyberbooks.ui.dashboard.viewmodel.DashboardViewModel
import br.com.kyberbooks.ui.registerbook.activities.RegisterBookActivity
import br.com.kyberbooks.utils.visible
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class DashboardActivity : BaseActivity() {

    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }

    private val viewModel by viewModels<DashboardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBookReadProgress()

        with(binding) {
            btnRegisterBook.setOnClickListener { startActivity(RegisterBookActivity.getStartIntent(this@DashboardActivity)) }
            ctnBookProgress.setOnClickListener { startActivity(BookDetailsActivity.getStartIntent(this@DashboardActivity)) }
        }

        Glide.with(this@DashboardActivity)
            .load(R.mipmap.ic_launcher_round)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imgUser)
    }

    private fun setupBookReadProgress() {
        viewModel.getReadProgress()

        viewModel.readProgress.observe(this) { readProgress ->
            with(binding) {
                TransitionManager.beginDelayedTransition(root)
                ctnBookProgress.visible()

                Glide.with(this@DashboardActivity)
                    .load(readProgress.bookCover)
                    .into(binding.imgBookCover)

                txtBookTitle.text = readProgress.bookName

                ValueAnimator.ofInt(0, 100).apply {
                    addUpdateListener {
                        val value = it.animatedValue as Int
                        val progressValue = value * 200 / 264
                        pgbReadProgress.progress = progressValue
                        txtPercentReadPages.text = "$progressValue%"
                        txtAbsolutReadPages.text =
                            "${readProgress.readProgress[readProgress.readProgress.lastIndex].pages_read}/${readProgress.totalPages}"
                    }

                    interpolator = LinearInterpolator()
                    duration = 2000
                    start()
                }

            }
        }
    }

//    private fun setupChart() {
//
//        val dataPoint = listOf(
//            DataPoint(0, 1),
//            DataPoint(1, 2),
//            DataPoint(2, 0),
//            DataPoint(3, 2),
//            DataPoint(4, 1),
//            DataPoint(5, 5),
//            DataPoint(6, 3),
//            DataPoint(7, 2),
//            DataPoint(8, 1),
//            DataPoint(9, 4),
//            DataPoint(10, 6),
//            DataPoint(11, 1),
//            DataPoint(12, 0),
//            DataPoint(13, 2),
//            DataPoint(14, 1),
//            DataPoint(15, 5),
//            DataPoint(16, 3),
//            DataPoint(17, 2),
//            DataPoint(18, 1),
//            DataPoint(19, 4),
//            DataPoint(20, 6)
//        )
//
//        binding.lineChart.setData(dataPoint)
//
//        ValueAnimator.ofFloat(0f, 1000f).apply {
//            addUpdateListener { binding.bgCourtain.translationX = it.animatedValue as Float }
//            duration = 3000
//            interpolator = LinearInterpolator()
//            start()
//        }
//
//
//    }

}