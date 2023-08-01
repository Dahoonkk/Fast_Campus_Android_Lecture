package com.example.part3_ch4_imageexractionapp.mvi.repository

import com.example.part3_ch4_imageexractionapp.mvi.model.Image

interface ImageRepository {

    suspend fun getRandomImage() : Image

}