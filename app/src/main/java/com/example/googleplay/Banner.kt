package com.example.googleplay

import androidx.annotation.DrawableRes

data class Banner(
    val id: Int,
    @DrawableRes val image: Int,
    @DrawableRes val icon: Int,
    val name: String,
    val grade: String,
    @DrawableRes val star: Int,
    val memory: String
)
