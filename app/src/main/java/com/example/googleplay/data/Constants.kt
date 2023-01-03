package com.example.googleplay.data

import com.example.googleplay.Banner
import com.example.googleplay.Grade
import com.example.googleplay.R

object Constants {

    fun getIcons(): List<Icons> {
        return listOf(
            Icons(1, listOf(
                R.drawable.img_1,
                R.drawable.img_2,
                R.drawable.img_3,
                R.drawable.img_4))
        )
    }

    fun getBanners(): List<Banners> {
        return listOf(
            Banners(1, listOf(
                R.drawable.banner_1,
                R.drawable.banner_2,
                R.drawable.banner_3,
                R.drawable.banner_4,
            ))
        )
    }

    fun getGrades(): List<Gradelar> {
        return listOf(
            Gradelar(1, listOf(
                R.drawable.grade_2,
                R.drawable.img_1,
                R.drawable.grade_3,
            ))
        )
    }
}