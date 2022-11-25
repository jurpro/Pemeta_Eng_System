package com.ujanglukmanbdg.pemeta.ui.sistempemeta

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.bumptech.glide.Glide
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.lapangan.KaryawanLapanganPemeta
import com.ujanglukmanbdg.pemeta.data.lapangan.KaryawanTugasLapangan
import com.ujanglukmanbdg.pemeta.databinding.ActivityDashboardSistemBinding
import com.ujanglukmanbdg.pemeta.ui.home.LandingPageActivity
import com.ujanglukmanbdg.pemeta.ui.maps.MapsActivity
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.absen.AbsensiActivity
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan.ListLaporanActivity
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.pekerjaan.TugasPekerjaanActivity
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.profile.DetailPersonilActivity
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.upload.UploadActivity
import com.ujanglukmanbdg.pemeta.ui.welcome.WelcomeActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
@ExperimentalPagingApi
class DashboardSistemActivity: AppCompatActivity() {

    private lateinit var binding : ActivityDashboardSistemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardSistemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val dashboardSistemViewModel = ViewModelProvider(this)[DashboardSistemViewModel::class.java]

        allMenuClick()

        val avatarDashboard = R.drawable.personil_lukmanul_hakim

        Glide.with(this)
            .load(avatarDashboard)
            .circleCrop()
            .into(binding.sistemPemetaPhoto)
    }

    private fun allMenuClick() {
        binding.sistemPemetaDashboardReportIcon.setOnClickListener {
            switchToListReportActivity()
        }

        binding.sistemPemetaDashboardAbsensiIcon.setOnClickListener {
            switchToAbsensiActivity()
        }

        binding.sistemPemetaDashboardLaporHarianIcon.setOnClickListener {
            switchToUploadActivity()
        }

        binding.sistemPemetaDashboardProfileIcon.setOnClickListener {
            switchToProfilePersonilActivity()
        }

        binding.sistemPemetaDashboardPekerjaanIcon.setOnClickListener {
            switchToTugasPekerjaan()
        }
    }

    private fun switchToTugasPekerjaan() {
        val dataKaryawanTugasLapangan = KaryawanTugasLapangan (
            lapanganPhoto = R.drawable.slideshow_01,
            lapanganName = resources.getString(R.string.detail_personil_lapangan_nama),
            lapanganKotaPenempatan = resources.getString(R.string.detail_personil_lapangan_penempatan),
            lapanganSatkerPenempatan = resources.getString(R.string.detail_personil_lapangan_satker),
            lapanganTugasPekerjaan = resources.getString(R.string.detail_personil_lapangan_pekerjaan),
            lapanganPerusahaanKontrak= resources.getString(R.string.detail_personil_lapangan_perusahaan),
            lapanganMobilisasi= resources.getString(R.string.detail_personil_lapangan_mobilisasi),
            lapanganDemobilisasi= resources.getString(R.string.detail_personil_lapangan_demobilisasi),
        )

        val tugasDetailInntent = Intent(this@DashboardSistemActivity, TugasPekerjaanActivity::class.java)
        tugasDetailInntent.putExtra(TugasPekerjaanActivity.EXTRA_JOB_DETAIL, dataKaryawanTugasLapangan)
        startActivity(tugasDetailInntent)
    }

    private fun switchToProfilePersonilActivity() {
        val dataKaryawanLapanganPemeta = KaryawanLapanganPemeta (
            lapanganName = resources.getString(R.string.detail_personil_lapangan_nama),
            lapanganPhoto = R.drawable.personil_lukmanul_hakim,
            lapanganJabatan = resources.getString(R.string.detail_personil_lapangan_jabatan),
            lapanganAlamatKtp = resources.getString(R.string.detail_personil_lapangan_alamat),
            lapanganEmail = resources.getString(R.string.detail_personil_lapangan_email),
            lapanganContact = resources.getString(R.string.detail_personil_lapangan_contact),

            lapanganKotaPenempatan = resources.getString(R.string.detail_personil_lapangan_penempatan),
            lapanganSatkerPenempatan = resources.getString(R.string.detail_personil_lapangan_satker),
            lapanganTugasPekerjaan = resources.getString(R.string.detail_personil_lapangan_pekerjaan),
            lapanganPerusahaanKontrak= resources.getString(R.string.detail_personil_lapangan_perusahaan),
            lapanganMobilisasi= resources.getString(R.string.detail_personil_lapangan_mobilisasi),
            lapanganDemobilisasi= resources.getString(R.string.detail_personil_lapangan_demobilisasi),
        )

        val profileDetailIntent = Intent(this@DashboardSistemActivity, DetailPersonilActivity::class.java)
        profileDetailIntent.putExtra(DetailPersonilActivity.EXTRA_USER_DETAIL, dataKaryawanLapanganPemeta)
        startActivity(profileDetailIntent)
    }

    private fun switchToListReportActivity() {
        intent = Intent(this@DashboardSistemActivity, ListLaporanActivity::class.java)
        startActivity(intent)
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

    private fun switchToAbsensiActivity() {
        intent = Intent(this@DashboardSistemActivity, AbsensiActivity::class.java)
        startActivity(intent)
    }

    private fun switchToUploadActivity() {
        intent = Intent(this@DashboardSistemActivity, UploadActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_TOKEN = "extra_token"
    }
}