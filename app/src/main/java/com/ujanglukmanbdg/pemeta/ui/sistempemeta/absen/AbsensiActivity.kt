package com.ujanglukmanbdg.pemeta.ui.sistempemeta.absen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.databinding.ActivityAbsensiBinding
import java.text.DateFormat
import java.util.Calendar

class AbsensiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAbsensiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAbsensiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = null
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }

        val calendar: Calendar
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}