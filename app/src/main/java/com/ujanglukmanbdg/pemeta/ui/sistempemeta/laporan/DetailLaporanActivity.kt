package com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.paging.ExperimentalPagingApi
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.lapangan.PhotoLaporan
import com.ujanglukmanbdg.pemeta.databinding.ActivityDetailLaporanBinding
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.pekerjaan.TugasPekerjaanActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
@ExperimentalPagingApi
class DetailLaporanActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityDetailLaporanBinding
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailLaporanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = getString(R.string.detail_report_activity)
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.detail_laporan_map_locations) as SupportMapFragment
        mapFragment.getMapAsync(this)

        detailReportView()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.apply {
            isZoomControlsEnabled = true
            isIndoorLevelPickerEnabled = true
            isCompassEnabled = true
            isMapToolbarEnabled  = true
            isScrollGesturesEnabled = true
        }

        // Add a marker in Pemeta and move the camera
        val cilanglaBridge = LatLng(-7.7747237, 108.1156845)

        mMap.addMarker(
            MarkerOptions()
                .position(cilanglaBridge)
                .title(resources.getString(R.string.detail_report_job))
                .snippet(resources.getString(R.string.detail_report_location))
                .visible(true)
        )
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cilanglaBridge, 16F))
        mMap.isTrafficEnabled = false

    }

    private fun detailReportView() {
        val dataLaporanKaryawan = intent.getParcelableExtra<PhotoLaporan>(
            TugasPekerjaanActivity.EXTRA_REPORT_DETAIL
        ) as PhotoLaporan

        binding.detailLaporanImagePicture.setImageResource(dataLaporanKaryawan.uploadPhoto)
        binding.detailLaporanInformationName.text = dataLaporanKaryawan.uploadName
        binding.detailLaporanInformationJob.text = dataLaporanKaryawan.uploadJob
        binding.detailLaporanInformationDescription.text = dataLaporanKaryawan.uploadDescription
        binding.detailLaporanInformationLocation.text = dataLaporanKaryawan.uploadLocation
        binding.detailLaporanInformationDate.text = dataLaporanKaryawan.uploadDate
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

}
