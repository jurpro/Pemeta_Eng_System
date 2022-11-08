package com.ujanglukmanbdg.pemeta.data

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
    var lapanganKotaPenempatan: String,
    var lapanganSatkerPenempatan: String,
    var lapanganTugasPekerjaan: String,
    var lapanganPerusahaanKontrak: String,
    var lapanganMobilisasi: String,
    var lapanganDemobilisasi: String,
): Parcelable
