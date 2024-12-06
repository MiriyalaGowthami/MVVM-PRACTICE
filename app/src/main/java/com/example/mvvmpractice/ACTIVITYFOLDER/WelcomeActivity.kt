package com.example.mvvmpractice.ACTIVITYFOLDER

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpractice.R
import com.example.mvvmpractice.WelcomeViewModel
import com.example.mvvmpractice.databinding.ActivityWelcomeBinding

class WelcomeActivity:AppCompatActivity() {

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:ActivityWelcomeBinding=DataBindingUtil.setContentView(this, R.layout.activity_welcome)
        viewModel=ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        val username = intent.getStringExtra("username") ?: "Unknown"
        val password = intent.getStringExtra("password") ?: "Unknown"

        // Update the ViewModel with the received data
        viewModel.setUserDetails(username, password)

    }

}
