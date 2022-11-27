package com.ujanglukmanbdg.pemeta.data.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_penugasan")
data class ModelDatabaseTugasLapangan(

    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    var id : Int,

    @field:SerializedName("username")
    var username: String,

    @field:SerializedName("name")
    var name : String,

    @field:SerializedName("photo")
    var photo: Int,

    @field:SerializedName("penempatan")
    var penempatan: String,

    @field:SerializedName("satker")
    var satker: String,

    @field:SerializedName("pekerjaan")
    var pekerjaan: String,

    @field:SerializedName("partner")
    var partner: String,

    @field:SerializedName("mobilisasi")
    var mobilisasi: String,

    @field:SerializedName("demobilisasi")
    var demobilisasi: String,

): Parcelable
