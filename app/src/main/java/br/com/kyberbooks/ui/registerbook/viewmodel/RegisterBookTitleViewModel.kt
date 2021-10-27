package br.com.kyberbooks.ui.registerbook.viewmodel

import androidx.lifecycle.MutableLiveData
import br.com.kyberbooks.base.BaseViewModel

class RegisterBookTitleViewModel : BaseViewModel() {

    private val cbxSubtitleLiveData = MutableLiveData<Boolean>()


    fun onSubtitleCheckClick(isChecked: Boolean) {

    }
}