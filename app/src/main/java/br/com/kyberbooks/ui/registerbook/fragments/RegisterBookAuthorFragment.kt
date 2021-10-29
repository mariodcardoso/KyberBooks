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
import br.com.kyberbooks.databinding.FragmentRegisterAuthorBinding
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookAuthorViewModel
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel

class RegisterBookAuthorFragment : Fragment() {

    private val binding by lazy { FragmentRegisterAuthorBinding.inflate(layoutInflater) }

    private val activityViewModel: RegisterBookViewModel by activityViewModels()
    private val fragmentViewModel: RegisterBookAuthorViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        setupObservable()
    }

    private fun setupViews() {
        with(binding) {
            btnBack.setOnClickListener { findNavController().popBackStack() }

            btnNext.setOnClickListener {
                fragmentViewModel.onNextButtonClicked(edtAuthorName.text.toString())
            }
        }
    }

    private fun setupObservable() {
        with(binding) {
            fragmentViewModel.isAuthorNameValidLiveData.observe(viewLifecycleOwner, { isAuthorNameValid ->
                if (isAuthorNameValid) {
                    activityViewModel.onAuthorNameInformed(edtAuthorName.text.toString())
                    findNavController().navigate(R.id.action_registerBookAuthorFragment_to_registerBookPublisherFragment)
                } else {
                    edtAuthorName.error = getString(R.string.register_book_author_name_invalid)
                }
            })
        }
    }
}