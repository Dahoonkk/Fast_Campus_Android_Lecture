package com.example.part3_ch4_imageexractionapp.mvi.repository

import com.example.part3_ch4_imageexractionapp.RetrofitManager
import com.example.part3_ch4_imageexractionapp.mvi.model.Image
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepositoryImpl(private val dispatcher: CoroutineDispatcher = Dispatchers.IO): ImageRepository {

    override suspend fun getRandomImage(): Image = withContext(dispatcher) {
        RetrofitManager.imageService.getRandomImageSuspend().let {
            Image(it.urls.regular, it.color)
        }
    }

}