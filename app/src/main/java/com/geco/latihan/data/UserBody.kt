package com.geco.latihan.data

import com.google.gson.annotations.SerializedName

data class UserBody(
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String)

