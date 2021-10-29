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
import br.com.kyberbooks.databinding.FragmentRegisterPublisherBinding
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookPublisherViewModel
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterBookPublisherFragment : Fragment() {

    private val binding by lazy { FragmentRegisterPublisherBinding.inflate(layoutInflater) }

    private val activityViewModel: RegisterBookViewModel by activityViewModels()
    private val fragmentViewModel: RegisterBookPublisherViewModel by viewModels()

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
            btnNext.setOnClickListener {
                fragmentViewModel.onNextButtonClicked(
                    edtBookPublisher.text.toString(),
                    edtBookPublishDate.text.toString(),
                    edtBookPublishEdition.text.toString()
                )

                activityViewModel.onPublishmentInfoInformed(
                    edtBookPublisher.text.toString(),
                    edtBookPublishDate.text.toString(),
                    edtBookPublishEdition.text.toString()
                )

                findNavController().navigate(R.id.action_registerBookPublisherFragment_to_registerBookAbout)
            }

            btnBack.setOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun setupObservable() {

    }

}