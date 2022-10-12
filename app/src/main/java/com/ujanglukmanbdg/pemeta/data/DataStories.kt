package com.ujanglukmanbdg.pemeta.data

import com.google.gson.annotations.SerializedName

data class DataStories(
    @field:SerializedName("error")
    var error : Boolean,

    @field:SerializedName("message")
    var message : String,

    // @field:SerializedName("listStory")
    // var listStory: ArrayList<ListStory>
)
