package com.example.part2_ch3_daynotice

import com.google.gson.annotations.SerializedName

data class message(
    @SerializedName("message")
    val msg: String
)