package br.com.kyberbooks.dashboard.mybooks.activesearch

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.kyberbooks.dashboard.viewmodel.ActiveSearchViewModel
import br.com.kyberbooks.databinding.ActiveSearchBinding

class ActiveSearchMain : AppCompatActivity(){

    private val binding by lazy { ActiveSearchBinding.inflate(layoutInflater) }

    private val viewModel : ActiveSearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rcvListMain.apply {
            adapter = ActiveSearchMainAdapter()
            layoutManager = LinearLayoutManager(this@ActiveSearchMain, LinearLayoutManager.HORIZONTAL, false)
        }

        viewModel.setupFields()

        viewModel.urlMyBooksCoverData.observe(this){ myBookCover ->
            binding.rcvListMain
        }
    }
}