package com.ujanglukmanbdg.pemeta.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonilPemeta(
    var personil_name: String,
    var personil_photo: Int,
    var personil_jabatan: String,
    var personil_quote: String,
    var personil_paragraph1: String,
    var personil_paragraph2: String,
    var personil_paragraph3: String,
    var personil_connect: String,
): Parcelable
