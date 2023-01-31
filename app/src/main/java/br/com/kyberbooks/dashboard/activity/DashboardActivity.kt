package br.com.kyberbooks.dashboard.activity

import android.os.Bundle
import br.com.kyberbooks.base.BaseActivity
import br.com.kyberbooks.dashboard.recycleview.DashboardAdapter
import br.com.kyberbooks.databinding.ActivityDashboardBinding


open class DashboardActivity : BaseActivity() {

    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }

    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.setupFields()

        viewModel.profileNameLiveData.observe(this){ profileName ->
            binding.txtProfileName.text = profileName
        }

        viewModel.profileUserNameLiveData.observe(this){userName ->
            binding.txtProfileUsername.text = userName
        }

        viewModel.bookNameLiveData.observe(this){bookName ->
            binding.txtBookName.text = bookName
        }

        viewModel.urlBookCover.observe(this){url ->
            Glide
                .with(this)
                .load(url)
                .into(binding.imgBookCover)
        }

        val recyclerView = binding.recycleListBookRegister
        recyclerView.adapter = DashboardAdapter()
    }

    private fun DashboardAdapter(): DashboardAdapter {
        return DashboardAdapter()
    }

}