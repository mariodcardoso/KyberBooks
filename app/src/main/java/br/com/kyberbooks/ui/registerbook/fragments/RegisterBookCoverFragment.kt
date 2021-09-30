package br.com.kyberbooks.ui.registerbook.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.com.kyberbooks.databinding.FragmentRegisterCoverBinding
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterBookCoverFragment : Fragment() {

    private val binding by lazy { FragmentRegisterCoverBinding.inflate(layoutInflater) }

    private val activityViewModel: RegisterBookViewModel by activityViewModels()
    private var bookUri: Uri? = null

    private val startImageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            binding.imgBookCover.setImageURI(result.data?.data)
            bookUri = result.data?.data
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnRegister.setOnClickListener {
                activityViewModel.onNextButtonClick(bookUri.toString(), binding.javaClass.simpleName)
                activityViewModel.registerBook()
            }

            imgBookCover.setOnClickListener { openGallery() }

        }
    }

    private fun openGallery() {
        val intent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.INTERNAL_CONTENT_URI
        )
        startImageResult.launch(intent)

    }
}