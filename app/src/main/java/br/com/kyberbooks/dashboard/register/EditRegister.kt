package br.com.kyberbooks.dashboard.register

import android.os.Bundle
import android.widget.Button
import br.com.kyberbooks.dashboard.activity.DashboardActivity
import br.com.kyberbooks.databinding.ActivityListBookEditBinding

open class EditRegister: DashboardActivity() {

    private val binding by lazy { ActivityListBookEditBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textBookTitleEdit.setOnClickListener {

            val editTitle = binding.textBookTitleEdit.text.toString()
            val editDescription = binding.textBookDescriptionEdit.text.toString()
            val editIsbn = binding.textBookIsbnEdit.text.toString()
            val editGenus = binding.textBookGenusEdit.text.toString()


            binding.buttonBookSave.setText(editTitle, editDescription, editIsbn, editGenus)
        }
    }
}

private fun Button.setText(
    editTitle: String,
    editDescription: String,
    editIsbn: String,
    editGenus: String
) {

}
