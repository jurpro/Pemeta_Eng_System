package com.ujanglukmanbdg.pemeta.data.lapangan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KaryawanTugasLapangan (
    var lapanganName: String,
    var lapanganPhoto: Int,
    var lapanganKotaPenempatan: String,
    var lapanganSatkerPenempatan: String,
    var lapanganTugasPekerjaan: String,
    var lapanganPerusahaanKontrak: String,
    var lapanganMobilisasi: String,
    var lapanganDemobilisasi: String,
): Parcelable