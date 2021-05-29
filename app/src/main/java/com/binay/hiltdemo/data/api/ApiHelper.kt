package com.binay.hiltdemo.data.api

import com.binay.hiltdemo.data.model.User
import retrofit2.Response

/**
 * Created by Binay on 29/5/21.
 */
interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}