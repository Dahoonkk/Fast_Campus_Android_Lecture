package com.example.part3_ch4_imageexractionapp.mvp.repository

import com.example.part3_ch4_imageexractionapp.ImageResponse
import com.example.part3_ch4_imageexractionapp.RetrofitManager
import retrofit2.Call
import retrofit2.Response

class ImageRepositoryImpl: ImageRepository {
    override fun getRandomImage(callBack: ImageRepository.CallBack) {
        RetrofitManager.imageService.getRandomImage()
            .enqueue(object : retrofit2.Callback<ImageResponse>{
                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    if(response.isSuccessful) {
                        response.body()?.let {
                            callBack.loadImage(it.urls.regular, it.color)
                        }
                    }
                }

                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {

                }

            })
    }
}