package com.ujanglukmanbdg.pemeta.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.databinding.ActivitySplashScreenBinding
import com.ujanglukmanbdg.pemeta.ui.main.MainActivity
import com.ujanglukmanbdg.pemeta.ui.welcome.WelcomeActivity

/**
 * Created by Lukmanul Hakim on 30/07/2022.
 * Twitter account @ArifLukmanBdg
 */

// private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    var settings: SharedPreferences?= null
    var editor: SharedPreferences.Editor ?= null
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        settings = this.getSharedPreferences("com.ujanglukmanbdg.pemeta", 0)
        editor = settings!!.edit();

        val background = object : Thread() {
            override fun run() {
                try {
                    // Thread will sleep for 5 seconds
                    Thread.sleep((5 * SPLASH_SCREEN_DURATION_IN_MILIS).toLong())

                    // After 5 seconds redirect to another intent
                    if (settings!!.getString("first", "0") == "0") {
                        editor!!.putString("first", "1")
                        editor!!.apply()
                        val i = Intent(baseContext, MainActivity::class.java)
                        startActivity(i)
                        finish()
                    } else {
                        val i = Intent(baseContext, WelcomeActivity::class.java)
                        startActivity(i)
                        finish()
                    }

                    //Remove activity
                    finish()
                } catch (e: Exception) {
                }

            }
        }
        // start thread
        background.start()
    }

    companion object {
        const val SPLASH_SCREEN_DURATION_IN_MILIS = 1000
    }
}