package com.ujanglukmanbdg.pemeta.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModelStory(
    val userId: String,
    val name: String,
    val token : String,
    val isLogin: Boolean,
): Parcelable
