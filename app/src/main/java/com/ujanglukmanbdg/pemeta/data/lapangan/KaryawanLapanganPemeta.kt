package com.ujanglukmanbdg.pemeta.data.lapangan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KaryawanLapanganPemeta(
    var lapanganName: String,
    var lapanganPhoto: Int,
    var lapanganJabatan: String,
    var lapanganAlamatKtp: String,
    var lapanganEmail: String,
    var lapanganContact: String,
): Parcelable
