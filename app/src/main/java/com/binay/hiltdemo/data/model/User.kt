package com.binay.hiltdemo.data.model

import com.squareup.moshi.Json

/**
 * Created by Binay on 29/5/21.
 */
class User(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "email")
    val email: String = "",
    @Json(name = "avatar")
    val avatar: String = ""
)