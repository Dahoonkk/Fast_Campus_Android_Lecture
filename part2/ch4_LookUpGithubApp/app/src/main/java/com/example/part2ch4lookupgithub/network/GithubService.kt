package com.example.part2ch4lookupgithub.network

import com.example.part2ch4lookupgithub.model.Repo
import com.example.part2ch4lookupgithub.model.UserDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("users/{username}/repos") // api 선언
    fun listRepos(@Path("username") username: String, @Query("page")page: Int) : Call<List<Repo>>

    @GET("search/users")
    fun searchUsers(@Query("q") query: String): Call<UserDto>
}