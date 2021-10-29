package br.com.kyberbooks.ui.registerbook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.kyberbooks.databinding.FragmentRegisterBookAboutBinding
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookAboutViewModel
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel

class RegisterBookAbout : Fragment() {

    private val binding by lazy { FragmentRegisterBookAboutBinding.inflate(layoutInflater) }

    private val activityViewModel: RegisterBookViewModel by activityViewModels()
    private val fragmentViewModel: RegisterBookAboutViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()


    }

    private fun setupViews() {
        with(binding) {

            spnGenre.apply {
                adapter = ArrayAdapter(
                    requireActivity(),
                    android.R.layout.simple_list_item_1,
                    arrayOf(
                        "Action and adventure",
                        "Art/architecture",
                        "Alternate history",
                        "Autobiography",
                        "Anthology",
                        "Biography",
                        "Chick lit",
                        "Business/economics",
                        "Children's",
                        "Crafts/hobbies",
                        "Classic",
                        "Cookbook",
                        "Comic book",
                        "Diary",
                        "Coming-of-age",
                        "Dictionary",
                        "Crime",
                        "Encyclopedia",
                        "Drama",
                        "Guide",
                        "Fairytale",
                        "Health/fitness",
                        "Fantasy",
                        "History",
                        "Graphic novel",
                        "Home and garden",
                        "Historical fiction",
                        "Humor",
                        "Horror",
                        "Journal",
                        "Mystery",
                        "Math",
                        "Paranormal romance",
                        "Memoir",
                        "Picture book",
                        "Philosophy",
                        "Poetry",
                        "Prayer",
                        "Political thriller",
                        "Religion, spirituality, and new age",
                        "Romance",
                        "Textbook",
                        "Satire",
                        "True crime",
                        "Science fiction",
                        "Review",
                        "Short story",
                        "Science",
                        "Suspense",
                        "Self help",
                        "Thriller",
                        "Sports and leisure",
                        "Western",
                        "Travel",
                        "Young adult",
                        "True crime"
                    )
                )
            }

            btnRegister.setOnClickListener {
                fragmentViewModel.onRegisterButtonClicked(
                    edtBookPages.text.toString().toInt(),
                    edtSynopsis.text.toString(),
                    spnGenre.selectedItem.toString()
                )

                activityViewModel.onBookInfosInformed(
                    edtBookPages.text.toString().toInt(),
                    edtSynopsis.text.toString(),
                    spnGenre.selectedItem.toString()
                )

            }

            btnBack.setOnClickListener { findNavController().popBackStack() }
        }
    }
}