package com.ujanglukmanbdg.pemeta.data.database.response

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @field:SerializedName("error")
    var error : Boolean,

    @field:SerializedName("message")
    var message : String
)
