package com.ujanglukmanbdg.pemeta.ui.sistempemeta.upload

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ujanglukmanbdg.pemeta.data.UserModelStory
import com.ujanglukmanbdg.pemeta.datastories.UserPreference

class UploadViewModel (private val pref: UserPreference) : ViewModel() {
    fun getUser(): LiveData<UserModelStory> {
        return pref.getUser().asLiveData()
    }
}