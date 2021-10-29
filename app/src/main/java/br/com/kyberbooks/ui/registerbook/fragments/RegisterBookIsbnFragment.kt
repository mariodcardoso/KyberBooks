package br.com.kyberbooks.ui.registerbook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.kyberbooks.R
import br.com.kyberbooks.databinding.FragmentRegisterIsbnBinding
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookIsbnViewModel
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterBookIsbnFragment : Fragment() {

    private val binding by lazy { FragmentRegisterIsbnBinding.inflate(layoutInflater) }

    private val fragmentViewModel: RegisterBookIsbnViewModel by viewModels()
    private val activityViewModel: RegisterBookViewModel by activityViewModels()

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
            btnNext.setOnClickListener {
                fragmentViewModel.onNextButtonClick(edtIsbn13.text.toString())
            }

            btnBack.setOnClickListener { activity?.finish() }
        }
    }

    private fun setupObservables() {
        with(binding) {
            fragmentViewModel.isbnErrorLiveData.observe(viewLifecycleOwner, { isIsbnValid ->
                if (isIsbnValid.not()) edtIsbn13.error = getString(R.string.register_book_isbn_invalid)
            })

            fragmentViewModel.isbnLiveData.observe(viewLifecycleOwner, { isbn ->
                activityViewModel.onIsbnInformed(isbn.isbn10, isbn.isbn13)
                findNavController().navigate(R.id.action_registerBookIsbnFragment_to_registerBookNameFragment)
            })
        }
    }
}