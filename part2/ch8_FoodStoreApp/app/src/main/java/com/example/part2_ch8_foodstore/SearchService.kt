package com.example.part2_ch8_foodstore

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("v1/search/local.json")
    fun getGoodRestaurant(
        @Query("query") query: String,
        @Query("display") display: Int,
    ): Call<SearchResult>
}