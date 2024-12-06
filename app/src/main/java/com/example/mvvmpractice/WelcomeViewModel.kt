package com.example.mvvmpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel:ViewModel() {
    val userName = MutableLiveData<String>()
    val Password = MutableLiveData<String>()

    fun setUserDetails(username: String, password: String) {
        this.userName.value = username
        this.Password.value = password
    }
}