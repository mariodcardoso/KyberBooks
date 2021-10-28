package br.com.kyberbooks.ui.registerbook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.kyberbooks.databinding.FragmentRegisterAuthorBinding

class RegisterBookAuthorFragment : Fragment() {

    private val binding by lazy { FragmentRegisterAuthorBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()


    }

    private fun setupViews() {
        with(binding){
            btnBack.setOnClickListener { findNavController().popBackStack() }

            btnNext.setOnClickListener {

            }
        }
    }
}