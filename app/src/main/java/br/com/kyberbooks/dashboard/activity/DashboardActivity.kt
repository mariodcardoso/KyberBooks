package br.com.kyberbooks.dashboard.activity

import android.os.Bundle
import br.com.kyberbooks.base.BaseActivity
import br.com.kyberbooks.dashboard.recycleview.DashboardAdapter
import br.com.kyberbooks.databinding.ActivityDashboardBinding


open class DashboardActivity : BaseActivity() {

    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerView = binding.recycleListBookRegister
        recyclerView.adapter = DashboardAdapter()
    }

    private fun DashboardAdapter(): DashboardAdapter {
        return DashboardAdapter()
    }

}