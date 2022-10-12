package com.ujanglukmanbdg.pemeta.ui.home.ui.direksi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.ui.home.ui.Event

class DireksiViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = (R.string.direksi_title).toString()
    }
    val text: LiveData<String> = _text


    private val _navigateToLocation = MutableLiveData<Event<String>>()
    val navigateToLocation : LiveData<Event<String>>
        get() = _navigateToLocation

    fun userClicksOnButton(itemId: String) {
        _navigateToLocation.value = Event(itemId)  // Trigger the event by setting a new Event as a new value
    }

}