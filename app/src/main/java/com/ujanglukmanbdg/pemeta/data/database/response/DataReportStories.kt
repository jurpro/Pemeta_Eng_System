package com.ujanglukmanbdg.pemeta.data.database.response

import com.google.gson.annotations.SerializedName

data class DataReportStories(
    @field:SerializedName("error")
    var error : Boolean,

    @field:SerializedName("message")
    var message : String,

    // @field:SerializedName("listStory")
    // var listStory: ArrayList<ListStory>
)
