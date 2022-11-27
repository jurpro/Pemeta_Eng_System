package com.ujanglukmanbdg.pemeta.data.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_report")
data class ModelDatabaseReport(
    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    var id: Int,

    @field:SerializedName("name")
    var name: String,

    @field:SerializedName("photo")
    var photo: String,

    @field:SerializedName("job")
    var job: String,

    @field:SerializedName("description")
    var description: String,

    @field:SerializedName("location")
    var location: String,

    @field:SerializedName("date")
    var date: String,

): Parcelable