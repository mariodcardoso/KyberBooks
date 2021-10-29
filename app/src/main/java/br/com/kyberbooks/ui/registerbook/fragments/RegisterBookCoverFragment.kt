package br.com.kyberbooks.ui.registerbook.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.kyberbooks.R
import br.com.kyberbooks.databinding.FragmentRegisterCoverBinding
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookCoverViewModel
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel
import br.com.kyberbooks.utils.gone
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterBookCoverFragment : Fragment() {

    private val binding by lazy { FragmentRegisterCoverBinding.inflate(layoutInflater) }

    private val activityViewModel: RegisterBookViewModel by activityViewModels()
    private val fragmentViewModel: RegisterBookCoverViewModel by viewModels()
    private var bookUri: Uri? = null

    private val startImageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            with(binding) {
                txtClickHere.gone()
                imgBookCover.setImageURI(result.data?.data)
                bookUri = result.data?.data
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservables()
    }

    private fun setupViews() {
        with(binding) {
            btnNext.setOnClickListener { fragmentViewModel.onNextButtonClicked(bookUri.toString()) }
            btnBack.setOnClickListener { findNavController().popBackStack() }

            imgBookCover.setOnClickListener { openGallery() }
        }
    }

    private fun setupObservables() {
        fragmentViewModel.isImageValidLiveData.observe(viewLifecycleOwner, Observer { isImageUriValid ->
            if (isImageUriValid) {
                activityViewModel.onBookCoverUploaded(bookUri.toString())
                findNavController().navigate(R.id.action_registerBookCoverFragment_to_registerBookAuthorFragment)
            } else {
                Toast.makeText(context, getString(R.string.resgiter_book_cover_invalid), Toast.LENGTH_SHORT).show()
            }


        })
    }

    private fun openGallery() {
        val intent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.INTERNAL_CONTENT_URI
        )
        startImageResult.launch(intent)
    }
}