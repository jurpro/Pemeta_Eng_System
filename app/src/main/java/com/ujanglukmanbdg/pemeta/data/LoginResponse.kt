package com.ujanglukmanbdg.pemeta.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("error")
    var error : Boolean,

    @field:SerializedName("message")
    var message : String,

    @field:SerializedName("loginResult")
    var loginResult : LoginResult,
)
