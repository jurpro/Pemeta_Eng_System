package com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import com.ujanglukmanbdg.pemeta.data.lapangan.PhotoLaporanStatis
import com.ujanglukmanbdg.pemeta.databinding.ActivityDetailLaporanBinding

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
@ExperimentalPagingApi
class DetailLaporanStatisActivity : AppCompatActivity(), OnMapReadyCallback {
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

        // Untuk Data Statis
        setDetailReportStatis()

        // Untuk menampilkan maps
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.detail_laporan_map_locations) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    private fun setDetailReportStatis() {
        val datareport = intent.getParcelableExtra<PhotoLaporanStatis>(EXTRA_JOB_STATIS) as PhotoLaporanStatis
        Log.d("Detail data ", datareport.photoStatis)

        binding.detailLaporanImagePicture.setImageResource(datareport.photoStatis.toInt())
        binding.detailLaporanInformationName.text = datareport.nameStatis
        binding.detailLaporanInformationJob.text = datareport.jobStatis
        binding.detailLaporanInformationDescription.text = datareport.descriptionStatis
        binding.detailLaporanInformationLocation.text = datareport.locationStatis
        binding.detailLaporanInformationDate.text = datareport.dateStatis
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
        /*
        val cilanglaBridge = LatLng(-7.7747237, 108.1156845)

        mMap.addMarker(
            MarkerOptions()
                .position(cilanglaBridge)
                .title(resources.getString(R.string.detail_report_job))
                .snippet(resources.getString(R.string.detail_report_location))
                .visible(true)
        )
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cilanglaBridge, 16F))
        mMap.isTrafficEnabled = false */

        // Untuk data Statis
        val datareport = intent.getParcelableExtra<PhotoLaporanStatis>(EXTRA_JOB_STATIS) as PhotoLaporanStatis
        Log.d("Detail map ", datareport.latStatis)

        val latitudeStatis = datareport.latStatis.toDouble()
        val longitudeStatis = datareport.lonStatis.toDouble()

        val dataStatisMap = LatLng(latitudeStatis, longitudeStatis)

        mMap.addMarker(
            MarkerOptions()
                .position(dataStatisMap)
                .title(datareport.jobStatis)
                .snippet(datareport.locationStatis)
                .visible(true)
        )
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dataStatisMap, 16F))
        mMap.isTrafficEnabled = false
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object{
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_JOB_STATIS = "extra_job_statis"
    }
}