package com.haru.part3_ch6_shoppingmall.model

data class Horizontal(
    val title: String,
    val items: List<ListItem>
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.HORIZONTAL

}