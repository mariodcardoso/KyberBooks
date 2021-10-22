package br.com.kyberbooks.ui.registerbook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.com.kyberbooks.R
import br.com.kyberbooks.databinding.FragmentRegisterIsbnBinding
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel
import dagger.hilt.android.AndroidEntryPoint

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

        with(binding) {
            btnNext.setOnClickListener {
                viewModel.onNextButtonClick(edtIsbn13.text.toString(), binding.javaClass.simpleName)
                findNavController().navigate(R.id.action_registerBookIsbnFragment_to_registerBookNameFragment)
            }
            btnBack.setOnClickListener { activity?.finish() }
        }

    }
}