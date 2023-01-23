package com.example.assignment.model

import com.google.gson.annotations.SerializedName

data class Streamable(
    @SerializedName("#text")  val text: String,
    val fulltrack: String
)