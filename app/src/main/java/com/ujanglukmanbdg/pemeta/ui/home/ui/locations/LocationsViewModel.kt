package com.ujanglukmanbdg.pemeta.ui.home.ui.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ujanglukmanbdg.pemeta.datastories.UserPreference

class LocationsViewModel(private val pref: UserPreference): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

}