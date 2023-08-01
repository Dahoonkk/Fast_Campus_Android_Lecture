package com.example.part3_ch4_imageexractionapp.mvi

import com.example.part3_ch4_imageexractionapp.mvi.model.Image

sealed class MviState {

    object Idle: MviState()
    object Loading: MviState()
    data class LoadedImage(val image: Image, val count:Int) : MviState()

}