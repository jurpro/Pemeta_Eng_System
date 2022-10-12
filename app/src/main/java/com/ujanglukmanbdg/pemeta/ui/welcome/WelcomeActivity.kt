package com.ujanglukmanbdg.pemeta.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ujanglukmanbdg.pemeta.databinding.ActivityWelcomeBinding
import com.ujanglukmanbdg.pemeta.ui.home.LandingPageActivity
import com.ujanglukmanbdg.pemeta.ui.main.MainActivity
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.DashboardSistemActivity
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.login.LoginActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.welcomeContinueGuest.setOnClickListener {
            switchToLandingPageActivity()
        }

        binding.welcomeContinueEmployee.setOnClickListener {
            switchToLoginActivity()
        }

        binding.welcomeContinueSystemInformationPemeta.setOnClickListener {
            switchToSystemActivity()
        }
    }

    private fun switchToMainActivity() {
        intent = Intent(this@WelcomeActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun switchToLoginActivity() {
        intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun switchToSystemActivity() {
        intent = Intent(this@WelcomeActivity, DashboardSistemActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun switchToLandingPageActivity() {
        intent = Intent(this@WelcomeActivity, LandingPageActivity::class.java)
        startActivity(intent)
        finish()
    }
}