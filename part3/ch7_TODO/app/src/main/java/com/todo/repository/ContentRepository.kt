package com.todo.repository

import com.todo.model.ContentEntity
import kotlinx.coroutines.flow.Flow

interface ContentRepository {

    fun loadList() : Flow<List<ContentEntity>>
    suspend fun insert(item: ContentEntity)
    suspend fun modify(item: ContentEntity)
}