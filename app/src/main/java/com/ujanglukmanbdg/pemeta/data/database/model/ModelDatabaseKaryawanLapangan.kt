package com.ujanglukmanbdg.pemeta.data.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_supervisi")
data class ModelDatabaseKaryawanLapangan(

    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    var id : Int,

    @field:SerializedName("username")
    var username: String,

    @field:SerializedName("name")
    var name : String,

    @field:SerializedName("photo")
    var photo: Int,

    @field:SerializedName("jabatan")
    var jabatan: String,

    @field:SerializedName("alamat")
    var alamat: String,

    @field:SerializedName("email")
    var email: String,

    @field:SerializedName("contact")
    var contact: String,

): Parcelable
