package br.com.kyberbooks.ui.registerbook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.kyberbooks.R
import br.com.kyberbooks.databinding.FragmentRegisterPublisherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterBookPublisherFragment : Fragment() {

    private val binding by lazy { FragmentRegisterPublisherBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnNext.setOnClickListener { findNavController().navigate(R.id.action_registerBookPublisherFragment_to_registerBookAbout) }

            btnBack.setOnClickListener { findNavController().popBackStack() }
        }
    }


}