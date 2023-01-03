package com.example.googleplay.data

import androidx.annotation.DrawableRes

data class Banners(
    val id: Int,
    @DrawableRes val banners: List<Int>
)
