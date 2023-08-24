package com.haru.part3_ch6_shoppingmall.remote

import com.haru.part3_ch6_shoppingmall.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("chapter6")
    suspend fun getList(
        @Query("page") page: Int,
        @Query("size") size: Int = 20
    ) : NetworkResponse
}