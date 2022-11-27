package com.ujanglukmanbdg.pemeta.data.lapangan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoLaporanStatis (
    var nameStatis: String,
    var photoStatis: String,
    var jobStatis: String,
    var locationStatis: String,
    var dateStatis: String,
    var descriptionStatis: String,
    var latStatis: String,
    var lonStatis: String,
): Parcelable