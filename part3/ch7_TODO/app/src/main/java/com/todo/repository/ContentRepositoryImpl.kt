package com.todo.repository

import com.todo.data.dao.ContentDao
import com.todo.model.ContentEntity
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(private val contentDao: ContentDao) : ContentRepository {
    override suspend fun insert(item: ContentEntity) {
        contentDao.insert(item)
    }
}