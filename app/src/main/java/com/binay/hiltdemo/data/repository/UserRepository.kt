package com.binay.hiltdemo.data.repository

import com.binay.hiltdemo.data.api.ApiHelper
import javax.inject.Inject

/**
 * Created by Binay on 29/5/21.
 */
class UserRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers() =  apiHelper.getUsers()
}