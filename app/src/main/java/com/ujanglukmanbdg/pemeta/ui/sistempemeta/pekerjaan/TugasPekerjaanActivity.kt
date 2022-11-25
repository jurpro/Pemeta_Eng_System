package com.ujanglukmanbdg.pemeta.ui.sistempemeta.pekerjaan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.paging.ExperimentalPagingApi
import com.bumptech.glide.Glide
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.lapangan.KaryawanTugasLapangan
import com.ujanglukmanbdg.pemeta.data.lapangan.PhotoLaporan
import com.ujanglukmanbdg.pemeta.databinding.ActivityTugasPekerjaanBinding
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan.DetailLaporanActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
@ExperimentalPagingApi
class TugasPekerjaanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTugasPekerjaanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugasPekerjaanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = getString(R.string.tugas_pekerjaan_title)
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }

        detailPekerjaanOpen()

        binding.tugasDetailHeaderImage.setOnClickListener{
            detailOnClick()
        }

    }

    private fun detailPekerjaanOpen() {
        val dataKaryawanTugasLapangan = intent.getParcelableExtra<KaryawanTugasLapangan>(EXTRA_JOB_DETAIL) as KaryawanTugasLapangan

        //Header
        Glide.with(this)
            .load(dataKaryawanTugasLapangan.lapanganPhoto)
            .circleCrop()
            .into(binding.tugasDetailHeaderImage)
        binding.tugasDetailHeaderName.text = dataKaryawanTugasLapangan.lapanganName

        // Detail
        binding.includeDescriptionSistemTugas.personilDetailPekerjaanTeks.text = dataKaryawanTugasLapangan.lapanganTugasPekerjaan
        binding.includeDescriptionSistemTugas.personilDetailPenempatanTeks.text = dataKaryawanTugasLapangan.lapanganKotaPenempatan
        binding.includeDescriptionSistemTugas.personilDetailSatkerTeks.text = dataKaryawanTugasLapangan.lapanganSatkerPenempatan
        binding.includeDescriptionSistemTugas.personilDetailPerusahaanTeks.text = dataKaryawanTugasLapangan.lapanganPerusahaanKontrak
        binding.includeDescriptionSistemTugas.personilDetailMobilisasiTeks.text = dataKaryawanTugasLapangan.lapanganMobilisasi
        binding.includeDescriptionSistemTugas.personilDetailDemobilisasiTeks.text = dataKaryawanTugasLapangan.lapanganDemobilisasi
    }

    private fun detailOnClick() {
        val dataLaporanKaryawan = PhotoLaporan (
            uploadPhoto = R.drawable.slideshow_01,
            uploadName = resources.getString(R.string.detail_report_name),
            uploadJob = resources.getString(R.string.detail_report_job),
            uploadDescription= resources.getString(R.string.detail_report_description),
            uploadLocation= resources.getString(R.string.detail_report_location),
            uploadDate= resources.getString(R.string.detail_report_date), /*
            lat= resources.getString(R.string.detail_report_lat),
            lang= resources.getString(R.string.detail_report_lang) */
        )

        val dataLaporanIntent = Intent(this@TugasPekerjaanActivity, DetailLaporanActivity::class.java)
        dataLaporanIntent.putExtra(EXTRA_REPORT_DETAIL, dataLaporanKaryawan)
        startActivity(dataLaporanIntent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        val EXTRA_REPORT_DETAIL = "extra job detail"
        val EXTRA_JOB_DETAIL = "extra job detail"
    }
}