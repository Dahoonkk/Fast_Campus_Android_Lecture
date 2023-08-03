package com.android

import com.android.model.ImageListResponse
import com.android.model.VideoListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {

    @Headers("Authorization: KakaoAK 2944a34dc1f6829454eb3d46a66d003b")
    @GET("image")
    fun searchImage(@Query("query") query: String) : Observable<ImageListResponse>

    @Headers("Authorization: KakaoAK 2944a34dc1f6829454eb3d46a66d003b")
    @GET("vclio")
    fun searchVideo(@Query("query") query: String) : Observable<VideoListResponse>

}