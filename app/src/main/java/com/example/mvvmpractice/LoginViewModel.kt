package com.example.mvvmpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel() : ViewModel() {

     var loginStatus=MutableLiveData<Boolean>()
     var inputName=MutableLiveData<String>()
     var inputPassword=MutableLiveData<String>()

    fun login(registeredUser: User?){
         if(inputName.value==registeredUser?.name && inputPassword.value==registeredUser?.password) {
             loginStatus.value = true
         }
         else{
             loginStatus.value=false
         }
     }
}