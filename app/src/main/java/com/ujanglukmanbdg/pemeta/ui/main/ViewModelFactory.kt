package com.ujanglukmanbdg.pemeta.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.ujanglukmanbdg.pemeta.data.database.repository.Injection
import com.ujanglukmanbdg.pemeta.datastories.UserPreference
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.DashboardSistemViewModel
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.login.LoginViewModel
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.upload.UploadViewModel

@ExperimentalPagingApi
class ViewModelFactory (

    private val pref: UserPreference,
    private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(pref, Injection.provideRepository(context)) as T
            }

            modelClass.isAssignableFrom(UploadViewModel::class.java) -> {
                UploadViewModel(pref) as T
            }

            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(pref) as T
            }

            else -> {throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)}
        }
    }
}