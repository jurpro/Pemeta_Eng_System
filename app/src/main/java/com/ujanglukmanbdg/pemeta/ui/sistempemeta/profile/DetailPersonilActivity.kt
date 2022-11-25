package com.ujanglukmanbdg.pemeta.ui.sistempemeta.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.bumptech.glide.Glide
import com.ujanglukmanbdg.pemeta.data.lapangan.KaryawanLapanganPemeta
import com.ujanglukmanbdg.pemeta.databinding.ActivityDetailPersonilBinding

class DetailPersonilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPersonilBinding
    private lateinit var listView: ListView
    private lateinit var adapter: PersonilAdapter
    private lateinit var employees: ArrayList<KaryawanLapanganPemeta>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailPersonilBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

        dataPersonilOpen()

    }

    private fun dataPersonilOpen() {
        val dataKaryawanLapanganPemeta = intent.getParcelableExtra<KaryawanLapanganPemeta>(EXTRA_USER_DETAIL) as KaryawanLapanganPemeta

        //Header
        Glide.with(this)
            .load(dataKaryawanLapanganPemeta.lapanganPhoto)
            .circleCrop()
            .into(binding.includeHeaderPersonilLapangan.headerDetailPersonilPhoto)
        binding.includeHeaderPersonilLapangan.headerDetailPersonilNama.text = dataKaryawanLapanganPemeta.lapanganName
        binding.includeHeaderPersonilLapangan.headerDetailPersonilJabatan.text = dataKaryawanLapanganPemeta.lapanganJabatan

        //Detail
        binding.includeDetailPersonilLapangan.personilDetailAlamatTeks.text = dataKaryawanLapanganPemeta.lapanganAlamatKtp
        binding.includeDetailPersonilLapangan.personilDetailEmailTeks.text = dataKaryawanLapanganPemeta.lapanganEmail
        binding.includeDetailPersonilLapangan.personilDetailContactTeks.text = dataKaryawanLapanganPemeta.lapanganContact
        /*
        binding.includeDetailPersonilLapangan.personilDetailPenempatanTeks .text = dataKaryawanLapanganPemeta.lapanganKotaPenempatan
        binding.includeDetailPersonilLapangan.personilDetailSatkerTeks.text = dataKaryawanLapanganPemeta.lapanganSatkerPenempatan
        binding.includeDetailPersonilLapangan.personilDetailPekerjaanTeks.text = dataKaryawanLapanganPemeta.lapanganTugasPekerjaan
        binding.includeDetailPersonilLapangan.personilDetailPerusahaanTeks.text = dataKaryawanLapanganPemeta.lapanganPerusahaanKontrak
        binding.includeDetailPersonilLapangan.personilDetailMobilisasiTeks.text = dataKaryawanLapanganPemeta.lapanganMobilisasi
        binding.includeDetailPersonilLapangan.personilDetailDemobilisasiTeks.text = dataKaryawanLapanganPemeta.lapanganDemobilisasi */
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        val EXTRA_USER_DETAIL = "extra user detail"
    }
}