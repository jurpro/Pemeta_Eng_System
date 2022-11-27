package com.ujanglukmanbdg.pemeta.data.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_absensi")
data class ModelDatabaseAbsensi(

    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    var id : Int,

    @field:SerializedName("username")
    var username: String,

    @field:SerializedName("name")
    var name : String,

    @field:SerializedName("absenMasuk")
    var absenMasuk: String,

    @field:SerializedName("absenPulang")
    var asbenPulang: String,

    @field:SerializedName("isAbsen")
    var isAbsen: Boolean,

): Parcelable