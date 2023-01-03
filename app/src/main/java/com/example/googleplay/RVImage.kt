package com.example.googleplay

import android.provider.ContactsContract.CommonDataKinds.Im

data class RVImage(
    val id: Int,
    val images: List<Images>
): Item()
