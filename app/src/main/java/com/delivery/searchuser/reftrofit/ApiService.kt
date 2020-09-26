package com.delivery.searchuser.reftrofit

import com.delivery.searchuser.database.entities.UserEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/search/user")
    fun getUserList(@Query("q") query : String) : Call<ArrayList<UserEntity>>

}