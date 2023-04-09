package br.com.kyberbooks.dashboard.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.kyberbooks.base.BaseActivity
import br.com.kyberbooks.dashboard.mybooks.MyBooksAdapter
import br.com.kyberbooks.dashboard.viewmodel.MyBooksViewModel
import br.com.kyberbooks.databinding.ActivityMyBooksBinding
import com.bumptech.glide.Glide

class MyBooksActivity : BaseActivity() {

    private val binding by lazy { ActivityMyBooksBinding.inflate(layoutInflater)}

    private val viewModel: MyBooksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.recyclerView.apply {
            adapter = MyBooksAdapter()
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        }

        viewModel.setupFields()

//        viewModel.urlMyBooks.observe(this){url->
//            Glide
//                .with(this)
//                .load(url)
//                .into(binding.)
//        }
    }

}


