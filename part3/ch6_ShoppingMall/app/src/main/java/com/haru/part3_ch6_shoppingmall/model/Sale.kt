package com.haru.part3_ch6_shoppingmall.model

import com.google.gson.annotations.SerializedName

data class Sale(
    @SerializedName("imageUrl")
    val imageUrl : String,

    @SerializedName("sale")
    val sale : String,
    @SerializedName("name")
    val name : String,
    @SerializedName("badge")
    val badge : String? = null,
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.SALE
}