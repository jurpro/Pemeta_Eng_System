package com.ujanglukmanbdg.pemeta.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "remote_keys_access")
data class RemoteKeysAccess(
    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("prevKey")
    val prevKey: Int?,

    @field:SerializedName("nextKey")
    val nextKey: Int?
)
