package com.ujanglukmanbdg.pemeta.data.database.response

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "report_image")
data class ListReportItem(
    @PrimaryKey
    @field:SerializedName("id")
    var id : String,

    @field:SerializedName("name")
    var name : String,

    @field:SerializedName("description")
    var description : String,

    @field:SerializedName("photoUrl")
    var photoUrl : String,

    @field:SerializedName("location")
    var location : String,

    @field:SerializedName("dateReport")
    var dateReport : String,

    @field:SerializedName("createdAt")
    var createdAt : String
): Parcelable
