package com.haru.part3_ch6_shoppingmall.di

import com.haru.part3_ch6_shoppingmall.remote.MainService
import com.haru.part3_ch6_shoppingmall.remote.repository.MainRepository
import com.haru.part3_ch6_shoppingmall.remote.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainRepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesMainRepository(
        mainService : MainService
    ) : MainRepository = MainRepositoryImpl(mainService)
}