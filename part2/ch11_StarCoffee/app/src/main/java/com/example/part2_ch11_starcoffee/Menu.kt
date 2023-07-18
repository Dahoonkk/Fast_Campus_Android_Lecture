package com.example.part2_ch11_starcoffee

data class Menu(
    val coffee: List<MenuItem>,
    val food: List<MenuItem>,
)

data class MenuItem(
    val name: String,
    val image: String,
)