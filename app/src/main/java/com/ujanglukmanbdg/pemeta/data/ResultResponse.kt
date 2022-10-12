package com.ujanglukmanbdg.pemeta.data

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @field:SerializedName("error")
    var error : Boolean,

    @field:SerializedName("message")
    var message : String
)
