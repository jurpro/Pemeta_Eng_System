package com.ujanglukmanbdg.pemeta.ui.detail.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.databinding.ActivityCompanyProfileBinding

class CompanyProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCompanyProfileBinding
    // private lateinit var companyProfilePdf: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompanyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            isHideOnContentScrollEnabled = false
            title = resources.getString(R.string.company_profile_title)
        }

       // companyProfilePdf = binding.companyProfilePdf

      //  companyProfilePdf.fromAsset("pengalaman_perusahaan.pdf")
       //     .swipeVertical(true)
         //   .load()
    }

    companion object {
        val EXTRA_PROFILE = "extra_profile"
    }
}