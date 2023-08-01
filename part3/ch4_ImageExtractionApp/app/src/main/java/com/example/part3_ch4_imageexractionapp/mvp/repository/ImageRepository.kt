package com.example.part3_ch4_imageexractionapp.mvp.repository

interface ImageRepository {

    fun getRandomImage(callBack: CallBack)

    interface CallBack {
        fun loadImage(url: String, color: String)
    }

}