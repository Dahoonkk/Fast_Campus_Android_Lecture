package com.example.part3_ch4_imageexractionapp.mvvm.repository

import com.example.part3_ch4_imageexractionapp.mvvm.model.Image
import io.reactivex.Single

interface ImageRepository {
    fun getRandomImage() : Single<Image>
}