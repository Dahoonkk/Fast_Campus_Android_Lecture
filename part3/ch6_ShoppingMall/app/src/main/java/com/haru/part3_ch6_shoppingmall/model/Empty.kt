package com.haru.part3_ch6_shoppingmall.model

class Empty: ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY

}