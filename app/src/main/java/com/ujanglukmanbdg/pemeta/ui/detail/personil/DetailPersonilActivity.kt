package com.ujanglukmanbdg.pemeta.ui.detail.personil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.PersonilPemeta
import com.ujanglukmanbdg.pemeta.databinding.ActivityDetailPersonilBinding

class DetailPersonilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPersonilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailPersonilBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataPersonilPemeta = intent.getParcelableExtra<PersonilPemeta>(EXTRA_USER_DETAIL) as PersonilPemeta

        binding.includeDetailHeader.headerDetailPersonilNama.text = dataPersonilPemeta.personil_name
        binding.includeDetailHeader.headerDetailPersonilPhoto.setImageResource(dataPersonilPemeta.personil_photo)
        binding.includeDetailHeader.headerDetailPersonilJabatan.text = dataPersonilPemeta.personil_jabatan
    }

    companion object {
        val EXTRA_USER_DETAIL = "extra user detail"
    }
}