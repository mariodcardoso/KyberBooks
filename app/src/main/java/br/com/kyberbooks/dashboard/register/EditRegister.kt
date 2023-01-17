package br.com.kyberbooks.dashboard.register

import android.os.Bundle
import br.com.kyberbooks.dashboard.activity.DashboardActivity
import br.com.kyberbooks.databinding.ActivityListBookEditBinding

open class EditRegister: DashboardActivity() {

    private val binding by lazy { ActivityListBookEditBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textBookTitleEdit.setOnClickListener {

            val editTitle = binding.textBookTitleEdit.text.toString()

            binding.buttonBookSave.setText(editTitle)
        }
    }
}