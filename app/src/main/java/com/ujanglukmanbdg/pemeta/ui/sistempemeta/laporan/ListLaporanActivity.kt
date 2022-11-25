package com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.databinding.ActivityListLaporanBinding

class ListLaporanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListLaporanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListLaporanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = getString(R.string.list_camera_report)
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val CAMERA_X_RESULT = 200
        const val EXTRA_TOKEN = "extra_token"
    }
}