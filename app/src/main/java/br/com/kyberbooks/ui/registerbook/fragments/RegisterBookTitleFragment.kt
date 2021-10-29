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
import br.com.kyberbooks.databinding.FragmentRegisterTitleBinding
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookTitleViewModel
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel
import br.com.kyberbooks.utils.gone
import br.com.kyberbooks.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterBookTitleFragment : Fragment() {

    private val binding by lazy { FragmentRegisterTitleBinding.inflate(layoutInflater) }

    private val activityViewModel: RegisterBookViewModel by activityViewModels()
    private val fragmentViewModel: RegisterBookTitleViewModel by viewModels()

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
            cbxSubtitle.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) inputBookSubtitle.visible() else inputBookSubtitle.gone()
            }

            btnNext.setOnClickListener {
                fragmentViewModel.onNextButtonClick(
                    edtBookTitle.text.toString(),
                    edtBookSubtitle.text.toString()
                )
            }

            btnBack.setOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun setupObservables() {
        with(binding) {
            fragmentViewModel.isTitleValidLiveData.observe(viewLifecycleOwner, { isTitleValid ->
                if (isTitleValid) {
                    activityViewModel.onBookTitleInformed(
                        edtBookTitle.text.toString(),
                        edtBookSubtitle.text.toString()
                    )
                    findNavController().navigate(R.id.action_registerBookTitleFragment_to_registerBookCoverFragment)
                } else {
                    edtBookTitle.error = getString(R.string.register_book_title_invalid)
                }
            })
        }
    }


}