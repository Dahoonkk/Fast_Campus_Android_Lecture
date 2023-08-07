package com.android.list

import com.android.model.ListItem

interface ItemHandler {
    fun onClickFavorite(item: ListItem)
}