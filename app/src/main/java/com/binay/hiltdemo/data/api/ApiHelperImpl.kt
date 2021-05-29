package com.binay.hiltdemo.data.api

import com.binay.hiltdemo.data.model.User
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Binay on 29/5/21.
 */
class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()
}