package com.android.repository

import com.android.model.ListItem
import io.reactivex.rxjava3.core.Observable

interface SearchRepository {

    fun search(query: String) : Observable<List<ListItem>>

}