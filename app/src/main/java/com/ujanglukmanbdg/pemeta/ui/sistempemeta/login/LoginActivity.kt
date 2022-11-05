package com.ujanglukmanbdg.pemeta.ui.sistempemeta.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.UserModelStory
import com.ujanglukmanbdg.pemeta.databinding.ActivityLoginBinding
import com.ujanglukmanbdg.pemeta.datastories.UserPreference
import com.ujanglukmanbdg.pemeta.ui.home.LandingPageActivity
import com.ujanglukmanbdg.pemeta.ui.main.ViewModelFactory
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.DashboardSistemActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
@ExperimentalPagingApi
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var user: UserModelStory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = resources.getString(R.string.login)

        // validateLogin()
        setupViewModel()
        setupAction()

        isLoading(false)

        binding.loginDontHaveAccount.setOnClickListener {
            backToLandingPage()
        }
    }

    private fun backToLandingPage() {
        intent = Intent(this@LoginActivity, LandingPageActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun validateLogin() {
        loginViewModel.isLoading.observe(this) {
            isLoading(it)
        }
        loginViewModel.apiResponse.observe(this) { message ->
            Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
        }

        loginViewModel.isEmailEmpty.observe(this) {
            if (it) {
                binding.loginEmailEditText.error = resources.getString(R.string.requires_email)
            }
        }

        loginViewModel.isEmailValid.observe(this) {
            if (it) {
                binding.loginEmailEditText.error = resources.getString(R.string.invalid_email)
            }
        }

        loginViewModel.isPasswordEmpty.observe(this) {
            if (it) {
                binding.loginPasswordEditText.error = resources.getString(R.string.requires_password)
            }
        }

        loginViewModel.isPasswordValid.observe(this) {
            if (!it) {
                binding.loginPasswordEditText.error = resources.getString(R.string.password_invalid)
            } else {
                binding.loginEmailEditText.error = null
            }
        }
    }

    private fun isLoading(value: Boolean) {
        if (value) {
            binding.loginProgressbar.visibility = View.VISIBLE
            binding.loginButton.isEnabled = false
        } else {
            binding.loginProgressbar.visibility = View.GONE
            binding.loginButton.isEnabled = true
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    private fun setupViewModel(){
        loginViewModel = ViewModelProvider(this, ViewModelFactory(UserPreference.getInstance(dataStore), this))[LoginViewModel::class.java]

        loginViewModel.getUser().observe(this) { user ->
            Log.d(resources.getString(R.string.login_success), user.token)
            this.user = user

            Log.d(resources.getString(R.string.login_activity), "Token: ${user.token}")
            if (this.user.isLogin) {
                Intent(this@LoginActivity, DashboardSistemActivity::class.java).let {
                    it.putExtra(DashboardSistemActivity.EXTRA_TOKEN, user.token)
                    startActivity(it)
                    finish()
                }
            }
        }
    }

    private fun setupAction() {
        binding.loginButton.setOnClickListener {
            val email = binding.loginEmailEditText.text.toString()
            val password = binding.loginPasswordEditText.text.toString()

         loginViewModel.loginUser(this,email,password)
        }
    }
}