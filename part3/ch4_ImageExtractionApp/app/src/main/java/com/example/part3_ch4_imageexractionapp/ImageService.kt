package com.example.part3_ch4_imageexractionapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {

    @Headers("Authorization: Client-ID 61NDY_-T27aff9fJIggUxPqFHG9jaZ94JCMrjlIg1bU")
    @GET("random")
    fun getRandomImage(): Call<ImageResponse>
}