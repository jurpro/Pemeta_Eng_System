package com.ujanglukmanbdg.pemeta.data

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PengalamanPemeta(
    var name: String,
    var photo: Int,
    var companyUser: String,
    var aboutExperience: String,
    var location: String,
    var contract_amount: String,
    var contract_jo: String,
    var yearExperience: String,
): Parcelable
