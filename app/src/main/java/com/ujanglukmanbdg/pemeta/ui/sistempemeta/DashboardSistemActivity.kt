package com.ujanglukmanbdg.pemeta.ui.sistempemeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ujanglukmanbdg.pemeta.databinding.ActivityDashboardSistemBinding
import com.ujanglukmanbdg.pemeta.ui.home.LandingPageActivity
import com.ujanglukmanbdg.pemeta.ui.home.ui.home.HomeViewModel
import com.ujanglukmanbdg.pemeta.ui.maps.MapsActivity
import com.ujanglukmanbdg.pemeta.ui.welcome.WelcomeActivity

class DashboardSistemActivity: AppCompatActivity() {

    private lateinit var binding : ActivityDashboardSistemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardSistemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val dashboardSistemViewModel = ViewModelProvider(this)[DashboardSistemViewModel::class.java]

        binding.sistemPemetaDashboardBack.setOnClickListener {
            switchToWelcomePageActivity()
        }

        binding.sistemPemetaDashboardHome.setOnClickListener {
            switchToLandingPageActivity()
        }

        binding.sistemPemetaDashboardLogout.setOnClickListener {
            switchToMapsActivity()
        }
    }

    private fun switchToMapsActivity() {
        intent = Intent(this@DashboardSistemActivity, MapsActivity::class.java)
        startActivity(intent)
    }

    private fun switchToWelcomePageActivity() {
        intent = Intent(this@DashboardSistemActivity, WelcomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun switchToLandingPageActivity() {
        intent = Intent(this@DashboardSistemActivity, LandingPageActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        const val EXTRA_TOKEN = "extra_token"
    }
}