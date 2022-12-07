package br.com.kyberbooks.dashboard.activity

import android.os.Bundle
import androidx.activity.viewModels
import br.com.kyberbooks.base.BaseActivity
import br.com.kyberbooks.dashboard.viewmodel.DashboardViewModel
import br.com.kyberbooks.databinding.ActivityDashboardBinding
import com.bumptech.glide.Glide


class DashboardActivity : BaseActivity() {

    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


}