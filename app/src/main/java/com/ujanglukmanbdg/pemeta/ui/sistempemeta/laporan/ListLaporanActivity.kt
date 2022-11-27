package com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.database.model.UserModelStory
import com.ujanglukmanbdg.pemeta.data.database.paging.LoadingStateAdapter
import com.ujanglukmanbdg.pemeta.data.lapangan.PhotoLaporanStatis
import com.ujanglukmanbdg.pemeta.databinding.ActivityListLaporanBinding
import com.ujanglukmanbdg.pemeta.datastories.UserPreference
import com.ujanglukmanbdg.pemeta.ui.main.MainViewModel
import com.ujanglukmanbdg.pemeta.ui.main.ViewModelFactory
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan.DetailLaporanStatisActivity.Companion.EXTRA_JOB_STATIS

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@ExperimentalPagingApi
class ListLaporanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListLaporanBinding

    private lateinit var listReportViewModel: MainViewModel
    private lateinit var adapter: ListReportAdapter
    private lateinit var userModelStory: UserModelStory

    // Data sementara Statis
    private lateinit var adapterStatis: ListReportStatisAdapter
    private lateinit var rvReportImageList: RecyclerView
    private val listReport = ArrayList<PhotoLaporanStatis>()

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

        // setupViewModel()
        // setAdapter()
        // isLoading(true)
        // validateUser()

        // Untuk Data Statis
        rvReportImageList = binding.rvImageReport
        rvReportImageList.setHasFixedSize(true)

        listReport.addAll(listReportImageList)
        showRecyclerList()
    }

    // Blok Data Statis
    private val listReportImageList: ArrayList<PhotoLaporanStatis>
        @SuppressLint("Recycle")
        get() {
            val dataNameStatis = resources.getStringArray(R.array.data_name_statis)
            val dataPhotoStatis = resources.getStringArray(R.array.data_photo_statis)
            val dataJobStatis = resources.getStringArray(R.array.data_job_statis)
            val dataLocationStatis = resources.getStringArray(R.array.data_location_statis)
            val dataDateStatis = resources.getStringArray(R.array.data_date_statis)
            val dataDescriptionStatis = resources.getStringArray(R.array.data_description_statis)
            val dataLatitudeStatis = resources.getStringArray(R.array.data_lat_statis)
            val dataLongitudeStatis = resources.getStringArray(R.array.data_lon_statis)

            val listReportImageStatis = ArrayList<PhotoLaporanStatis>()
            for (i in dataNameStatis.indices) {
                val reportStatis = PhotoLaporanStatis(
                    dataNameStatis[i],
                    dataPhotoStatis[i],
                    dataJobStatis[i],
                    dataLocationStatis[i],
                    dataDateStatis[i],
                    dataDescriptionStatis[i],
                    dataLatitudeStatis[i],
                    dataLongitudeStatis[i],
                )
                listReportImageStatis.add(reportStatis)
            }
            return listReportImageStatis
        }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvReportImageList.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvReportImageList.layoutManager = LinearLayoutManager(this)
        }

        val listReportStatisAdapter = ListReportStatisAdapter(listReport)
        rvReportImageList.adapter = listReportStatisAdapter

        listReportStatisAdapter.setOnItemClickCallback(object : ListReportStatisAdapter.OnItemClickCallback {
            override fun onItemClicked(datareport: PhotoLaporanStatis) {
                val intentToDetail = Intent(this@ListLaporanActivity, DetailLaporanStatisActivity::class.java)
                intentToDetail.putExtra(EXTRA_JOB_STATIS, datareport)
                startActivity(intentToDetail)
            }
        })
    }


    // Blok data Dinamis

    private fun validateUser(){
        listReportViewModel.listUser.observe(this) {
            isLoading(false)
        }

        listReportViewModel.isLoading.observe(this) {
            isLoading(it)
        }

        listReportViewModel.apiResponse.observe(this) {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun setAdapter() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvImageReport.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvImageReport.layoutManager = LinearLayoutManager(this)
        }

        adapter = ListReportAdapter()
        binding.rvImageReport.adapter = adapter.withLoadStateFooter(footer = LoadingStateAdapter {
            adapter.retry()
        })
    }

    private fun setupViewModel() {
        listReportViewModel = ViewModelProvider(this, ViewModelFactory(UserPreference.getInstance(dataStore), this))[MainViewModel::class.java]

        listReportViewModel.getUser().observe(this) { user ->
            this.userModelStory = user
            if (user.isLogin) {
                isLoading(false)
                supportActionBar?.title = "${user.name}'s Home Report"

                listReportViewModel.pagingStory(user.token).observe(this) {
                    adapter.submitData(lifecycle, it)
                    Log.d("Paging Story Success: ", user.token )
                }

            } /* else {
                startActivity(Intent(this@ListLaporanActivity, DashboardSistemActivity::class.java))
                finish()
            } */
        }
    }

    private fun isLoading(value:Boolean){
        if (value) {
            binding.rvImageReport.visibility = View.GONE
        } else {
            binding.rvImageReport.visibility = View.VISIBLE
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