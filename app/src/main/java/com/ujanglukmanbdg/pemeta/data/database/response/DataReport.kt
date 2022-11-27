package com.ujanglukmanbdg.pemeta.data.database.response

import com.google.gson.annotations.SerializedName
import com.ujanglukmanbdg.pemeta.data.lapangan.PhotoLaporan

data class DataReport(
    @field:SerializedName("error")
    var error : Boolean,

    @field:SerializedName("message")
    var message : String,

    @field:SerializedName("listReport")
    var listReport: ArrayList<PhotoLaporan>
)
