package com.example.mvvmpractice.ACTIVITYFOLDER

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmpractice.R
import com.example.mvvmpractice.User
import com.example.mvvmpractice.LoginViewModel
import com.example.mvvmpractice.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
     val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        // Get the registered user from the intent
        val registeredUser: User? = intent.getSerializableExtra("registeredUser") as? User


       // viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.loginStatus.observe(this) { isSuccess ->
            if (isSuccess) {
                val intent = Intent(this, WelcomeActivity::class.java).apply {
                    putExtra("username", viewModel.inputName.value)
                    putExtra("password", viewModel.inputPassword.value)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            viewModel.login(registeredUser)
        }
    }
}
