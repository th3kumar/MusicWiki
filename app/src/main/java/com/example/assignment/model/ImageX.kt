package com.example.assignment.model

import com.google.gson.annotations.SerializedName

data class ImageX(
    @SerializedName("#text")  val text: String,
    val size: String
)