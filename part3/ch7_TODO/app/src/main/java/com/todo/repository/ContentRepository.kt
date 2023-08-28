package com.todo.repository

import com.todo.model.ContentEntity

interface ContentRepository {

    suspend fun insert(item: ContentEntity)
}