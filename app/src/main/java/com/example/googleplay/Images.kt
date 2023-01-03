package com.example.googleplay

import androidx.annotation.DrawableRes

data class Images(
    val id: Int,
    @DrawableRes val image: Int,
    val name: String,
    val san: String,
    @DrawableRes val star: Int
)
