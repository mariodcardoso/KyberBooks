package br.com.kyberbooks.ui.registerbook.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.kyberbooks.R
import br.com.kyberbooks.databinding.FragmentRegisterIsbnBinding
import br.com.kyberbooks.domain.model.Book
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class RegisterBookIsbnFragment : Fragment() {

    private val binding by lazy { FragmentRegisterIsbnBinding.inflate(layoutInflater) }

    private val viewModel: RegisterBookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            viewModel.onNextButtonClick("123456789", binding.javaClass.simpleName)
            findNavController().navigate(R.id.action_registerBookIsbnFragment_to_registerBookNameFragment)
        }
    }
}