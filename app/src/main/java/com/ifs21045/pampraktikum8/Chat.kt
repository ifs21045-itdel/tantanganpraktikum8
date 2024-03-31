package com.ifs21045.pampraktikum8
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chat(
    var name: String,
    var icon: Int,
) : Parcelable
