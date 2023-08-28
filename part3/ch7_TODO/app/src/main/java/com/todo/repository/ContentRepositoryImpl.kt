package com.todo.repository

import com.todo.data.dao.ContentDao
import com.todo.model.ContentEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(private val contentDao: ContentDao) : ContentRepository {
    override fun loadList() = contentDao.selectAll()

    override suspend fun insert(item: ContentEntity) {
        contentDao.insert(item)
    }

    override suspend fun modify(item: ContentEntity) {
        contentDao.insert(item) // 덮어씌워지게 해뒀기 때문에 그냥 insert
    }

    override suspend fun delete(item: ContentEntity) {
        contentDao.delete(item)
    }
}