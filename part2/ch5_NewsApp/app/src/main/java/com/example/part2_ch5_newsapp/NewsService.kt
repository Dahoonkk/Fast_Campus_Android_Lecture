package com.example.part2_ch5_newsapp

import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("ress?hl=ko&gl=KR&ceid=KR:ko")
    fun mainFeed(): Call<NewsRss>
}