package br.com.kyberbooks.ui.registerbook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.navGraphViewModels
import br.com.kyberbooks.R
import br.com.kyberbooks.databinding.FragmentRegisterCoverBinding
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterBookCoverFragment : Fragment() {

    private val binding by lazy { FragmentRegisterCoverBinding.inflate(layoutInflater) }

    private val activityViewModel: RegisterBookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            activityViewModel.onNextButtonClick("imagem", binding.javaClass.simpleName)
            activityViewModel.registerBook()
        }
    }
}