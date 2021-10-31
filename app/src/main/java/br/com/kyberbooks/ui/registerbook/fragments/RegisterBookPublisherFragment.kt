package br.com.kyberbooks.ui.registerbook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
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

    private val languageList = listOf(
        "Portuguese (Brazil)",
        "Portuguese (Portugal)",
        "English",
        "Spanish",
        "Japanese",
        "French",
        "Italian",
    )

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
                    edtBookPublishEdition.text.toString(),
                    spnLanguage.selectedItem.toString()
                )
            }

            btnBack.setOnClickListener { findNavController().popBackStack() }

            spnLanguage.adapter = ArrayAdapter(
                requireActivity(),
                android.R.layout.simple_list_item_1,
                languageList
            )
        }
    }

    private fun setupObservable() {

        fragmentViewModel.isPublisherLiveData.observe(viewLifecycleOwner, { isPublisherValid ->
            if (isPublisherValid.not()) {
                binding.edtBookPublisher.error = getString(R.string.resgiter_book_publish_edit_publisher_error)
            }
        })

        fragmentViewModel.isPublishDateValidLiveData.observe(viewLifecycleOwner, { isPublishDateValid ->
            if (isPublishDateValid.not()) {
                binding.edtBookPublishDate.error = getString(R.string.resgiter_book_publish_edit_publish_date_error)
            }
        })

        fragmentViewModel.isEditionValidLiveData.observe(viewLifecycleOwner, { isEditionValid ->
            if (isEditionValid.not()) {
                binding.edtBookPublishEdition.error = getString(R.string.resgiter_book_publish_edit_edition_error)
            }
        })

        fragmentViewModel.isLanguageValidLiveData.observe(viewLifecycleOwner, { isLanguageValid ->
            if (isLanguageValid.not()) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.resgiter_book_publish_edit_language_error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        fragmentViewModel.isInformationsValid.observe(viewLifecycleOwner, { isInformationValid ->
            with(binding) {
                if (isInformationValid) {
                    activityViewModel.onPublishmentInfoInformed(
                        edtBookPublisher.text.toString(),
                        edtBookPublishDate.text.toString(),
                        edtBookPublishEdition.text.toString(),
                        spnLanguage.selectedItem.toString()
                    )

                    findNavController().navigate(R.id.action_registerBookPublisherFragment_to_registerBookAbout)
                }
            }
        })
    }
}