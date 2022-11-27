package com.ujanglukmanbdg.pemeta.data.database.response

import com.google.gson.annotations.SerializedName

data class LoginResult(
    @field:SerializedName("userId")
    var userId : String,

    @field:SerializedName("name")
    var name : String,

    @field:SerializedName("token")
    var token : String
)
