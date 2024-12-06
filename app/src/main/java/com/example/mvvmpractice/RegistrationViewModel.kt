package com.example.mvvmpractice

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel: ViewModel() {
    val name=MutableLiveData<String>()
    val email=MutableLiveData<String>()
    val password=MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()

    val errormessage=MutableLiveData<String?>()

    var registeredUser: User?=null

    fun registerUser() {
        if (name.value.isNullOrEmpty()) {
            errormessage.value = "Name can't be empty"
            return
        }
        if (email.value.isNullOrEmpty()) {
            errormessage.value = "Email cannot be empty"
            return
        }
        if (password.value.isNullOrEmpty()) {
            errormessage.value = "Password cannot be empty"
            return
        }
        if (confirmPassword.value.isNullOrEmpty() || password.value != confirmPassword.value) {
            errormessage.value = "Passwords do not match"
            return
        }
        //if there are no errors
        registeredUser = User(name.value!!, email.value!!, password.value!!)//!! indicates that the values are not null
        errormessage.value = null

        Log.d("RegistrationViewModel", "Registered User: $registeredUser")
    }
}