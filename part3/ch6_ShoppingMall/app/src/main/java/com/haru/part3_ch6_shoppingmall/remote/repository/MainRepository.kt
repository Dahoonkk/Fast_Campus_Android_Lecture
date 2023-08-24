package com.haru.part3_ch6_shoppingmall.remote.repository

import androidx.paging.PagingData
import com.haru.part3_ch6_shoppingmall.model.ListItem
import kotlinx.coroutines.flow.Flow


interface MainRepository {
    fun loadList() : Flow<PagingData<ListItem>>
}