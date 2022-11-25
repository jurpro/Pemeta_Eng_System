package com.ujanglukmanbdg.pemeta.data.lapangan

data class Absensi (
    val userId: String,
    val name: String,
    val absenMasuk: String,
    val asbenPulang: String,
    val isAbsen: Boolean,
)