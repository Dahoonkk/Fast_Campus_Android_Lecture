package com.haru.part3_ch6_shoppingmall.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.haru.part3_ch6_shoppingmall.model.ListItem
import com.haru.part3_ch6_shoppingmall.remote.MainPagingSource
import com.haru.part3_ch6_shoppingmall.remote.MainService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService
): MainRepository {
    override fun loadList() = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            MainPagingSource(mainService)
        }
    ).flow
}