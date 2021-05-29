package com.binay.hiltdemo.data.api

import com.binay.hiltdemo.data.model.User
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Binay on 29/5/21.
 */
interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}