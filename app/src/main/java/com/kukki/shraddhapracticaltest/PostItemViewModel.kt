package com.kukki.shraddhapracticaltest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kukki.shraddhapracticaltest.data.PostVo

class PostItemViewModel(card : PostVo) : ViewModel() {

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val body = MutableLiveData<String>()

    init {

        name.value = card.name
        email.value = card.email
        body.value = card.body
    }
}