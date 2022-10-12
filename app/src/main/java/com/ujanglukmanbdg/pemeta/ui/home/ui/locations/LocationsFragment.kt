package com.ujanglukmanbdg.pemeta.ui.home.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.databinding.FragmentLocationsBinding


class LocationsFragment: Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var _binding: FragmentLocationsBinding

    private val binding get() = _binding

    private lateinit var locationsViewModel: LocationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLocationsBinding.inflate(layoutInflater)
        val root: View = binding.root

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val supportFragmentManager = childFragmentManager
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_locations) as SupportMapFragment
        mapFragment.getMapAsync(this@LocationsFragment)

        // val locationsViewModel = ViewModelProvider(this)[LocationsViewModel::class.java]

        // locationsViewModel.text.observe(viewLifecycleOwner) {}

        setToolbarHide()

        return root
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
        val pemetaEngSys = LatLng(-6.943474, 107.622712)

        mMap.addMarker(
            MarkerOptions()
                .position(pemetaEngSys)
                .title(resources.getString(R.string.company_full_name))
                .snippet(resources.getString(R.string.company_address))
                .visible(true)
        )
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(pemetaEngSys))
        // mMap.moveCamera(CameraUpdateFactory.zoomTo(14F))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pemetaEngSys, 16F))
        mMap.isTrafficEnabled = false

    }

    private fun setToolbarHide() {
        binding.apply {
            (requireActivity() as AppCompatActivity).supportActionBar?.isHideOnContentScrollEnabled
            /*
            homeSlideshow1.visibility = View.VISIBLE
            homeSlideshow2.visibility = View.VISIBLE
            homeSlideshow3.visibility = View.VISIBLE
            homeSlideshow4.visibility = View.VISIBLE
            includeMenuFrontAddress.root.visibility = View.VISIBLE
            includeMenuFrontPemeta.root.visibility = View.VISIBLE
            menu1.visibility = View.VISIBLE
            menu2.visibility = View.VISIBLE
            menu3.visibility = View.VISIBLE
            menu4.visibility = View.VISIBLE */
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = this.binding
    }

}