package com.ujanglukmanbdg.pemeta.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.paging.ExperimentalPagingApi
import com.google.android.material.snackbar.Snackbar
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.databinding.ActivityLandingPageBinding
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.DashboardSistemActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
@ExperimentalPagingApi
class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        // supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = null
            elevation = 0f
            setDisplayHomeAsUpEnabled(false)
        }

        binding.fabEmailSystem.setOnClickListener { view ->
            Snackbar.make(view, resources.getString(R.string.snackbar_fabEmailBottom), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            switchToSystemActivity()
        }

        val navView: BottomNavigationView = binding.navViewMenu

        navView.background = null
        navView.menu.clear()
        navView.inflateMenu(R.menu.bottom_nav_menu)
        navView.selectedItemId = R.id.navigation_locations

        val navController = findNavController(R.id.nav_host_fragment_activity_landing_page)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_direksi,
                R.id.navigation_placeholder,
                R.id.navigation_locations,
                R.id.navigation_system,
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        /*
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_landing_page)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController) */
    }

    private fun switchToSystemActivity() {
        intent = Intent(this@LandingPageActivity, DashboardSistemActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_landing_page)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}