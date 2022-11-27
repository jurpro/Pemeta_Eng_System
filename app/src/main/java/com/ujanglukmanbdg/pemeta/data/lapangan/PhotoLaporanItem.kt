package com.ujanglukmanbdg.pemeta.data.lapangan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoLaporanItem (
    var id: String,
    var uploadName: String,
    var uploadPhoto: Int,
    var uploadJob: String,
    var uploadLocation: String,
    var uploadDate: String,
): Parcelable