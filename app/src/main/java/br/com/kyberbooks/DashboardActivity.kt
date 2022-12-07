package br.com.kyberbooks

import android.os.Bundle
import br.com.kyberbooks.base.BaseActivity
import br.com.kyberbooks.databinding.ActivityDashboardBinding
import com.bumptech.glide.Glide


class DashboardActivity : BaseActivity() {

    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }

    val elizandra = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            Glide
                .with(this@DashboardActivity)
                .load("https://images-americanas.b2w.io/produtos/1418077734/imagens/livro-especialista-em-pessoas-solucoes-biblicas-e-inteligentes-para-lidar-com-todo-tipo-de-gente/1418077734_1_large.jpg")
                .into(imgBookCover)


            Glide
                .with(this@DashboardActivity)
                .load("https://images-americanas.b2w.io/produtos/1418077734/imagens/livro-especialista-em-pessoas-solucoes-biblicas-e-inteligentes-para-lidar-com-todo-tipo-de-gente/1418077734_1_large.jpg")
                .into(imgProfile)

        }


    }


}