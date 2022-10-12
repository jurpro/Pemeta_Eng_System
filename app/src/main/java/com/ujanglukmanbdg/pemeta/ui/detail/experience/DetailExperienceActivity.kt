package com.ujanglukmanbdg.pemeta.ui.detail.experience

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.addCallback
import com.bumptech.glide.Glide
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.PengalamanPemeta
import com.ujanglukmanbdg.pemeta.databinding.ActivityDetailExperienceBinding

class DetailExperienceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailExperienceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailExperienceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = resources.getString(R.string.detail_title)
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }

        // This callback will only be called when MyFragment is at least Started.
        val callback = onBackPressedDispatcher.addCallback(this) {
            onBackPressed()
        }

        // The callback can be enabled or disabled here or in the lambda

        // supportActionBar?.title = resources.getString(R.string.detail_title)

        val dataPengalamanPemeta = intent.getParcelableExtra<PengalamanPemeta>(EXTRA_USER) as PengalamanPemeta

        //Glide.with(this)
        //    .load(dataPengalamanPemeta.photo)
        //    .into(binding.includeHeaderExperience.detailHeaderImage)

        binding.includeHeaderExperience.detailHeaderImage.setImageResource(dataPengalamanPemeta.photo)
        binding.includeDescriptionExperience.detailNameText.text = dataPengalamanPemeta.name
        binding.includeDescriptionExperience.detailCompanyUserText.text = dataPengalamanPemeta.companyUser
        binding.includeDescriptionExperience.detailLocationText.text = dataPengalamanPemeta.location
        binding.includeDescriptionExperience.detailYearText.text = dataPengalamanPemeta.yearExperience
        binding.includeDescriptionExperience.detailContractAmountText.text = dataPengalamanPemeta.contract_amount
        binding.includeDescriptionExperience.detailJointOperationText.text = dataPengalamanPemeta.contract_jo
        binding.includeDescriptionExperience.detailAboutText.text = dataPengalamanPemeta.aboutExperience
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}