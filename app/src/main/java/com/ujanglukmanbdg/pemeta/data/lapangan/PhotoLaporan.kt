package com.ujanglukmanbdg.pemeta.data.lapangan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoLaporan(
    var id: Int,
    var uploadName: String,
    var uploadPhoto: Int,
    var uploadJob: String,
    var uploadDescription: String,
    var uploadLocation: String,
    var uploadDate: String,
    var lat: String,
    var lon: String,
): Parcelable
