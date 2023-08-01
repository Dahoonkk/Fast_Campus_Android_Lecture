package com.example.part3_ch4_imageexractionapp.mvvm.repository

import com.example.part3_ch4_imageexractionapp.RetrofitManager
import com.example.part3_ch4_imageexractionapp.mvvm.model.Image
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ImageRepositoryImpl : ImageRepository {

    override fun getRandomImage() = RetrofitManager.imageService.getRandomImageRx()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { item ->
            Single.just(Image(item.urls.regular, item.color))
        }

}