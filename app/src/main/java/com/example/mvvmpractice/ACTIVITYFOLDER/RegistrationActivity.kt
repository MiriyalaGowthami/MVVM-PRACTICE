package com.example.mvvmpractice.ACTIVITYFOLDER

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpractice.R
import com.example.mvvmpractice.RegistrationViewModel
import com.example.mvvmpractice.databinding.ActivityRegistrationBinding


class RegistrationActivity : AppCompatActivity() {

    private lateinit var viewModel: RegistrationViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityRegistrationBinding=DataBindingUtil.setContentView(this, R.layout.activity_registration)
        viewModel=ViewModelProvider(this).get(RegistrationViewModel::class.java)
        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        binding.btnRegister.setOnClickListener{
            viewModel.registerUser()
            if(viewModel.registeredUser != null){
                Log.d("RegistrationActivity", "Navigating to LoginActivity")
            val intent = Intent(this, LoginActivity::class.java).apply{
                putExtra("registeredUser", viewModel.registeredUser)
            }
            startActivity(intent)
            finish()
            }
        }

    }
}